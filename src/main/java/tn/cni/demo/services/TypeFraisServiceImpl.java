package tn.cni.demo.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.cni.demo.exception.InvalidParmException;
import tn.cni.demo.exception.ResourceNotFoundException;
import tn.cni.demo.model.TypeFrais;
import tn.cni.demo.model.TypeFraisDto;
import tn.cni.demo.model.TypeFraisRequest;
import tn.cni.demo.repositories.TypeFraisRepo;
import tn.cni.demo.utilities.ConvertUtilitiesParam;

@Service
public class TypeFraisServiceImpl implements TypeFraisService {
	private static final Logger logger = LoggerFactory.getLogger(TypeFraisServiceImpl.class);
	@Autowired
	TypeFraisRepo typeFraisRepo;
	@Autowired
	MessageSource messageSource;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<TypeFraisDto> findListTypeFrais() throws Exception {

		logger.info("findListTypeFrais() : before");
		List<TypeFrais> lstType = typeFraisRepo.findByOrderByIdDescCodeAsc();
		List<TypeFraisDto> lst = ConvertUtilitiesParam.convertToLstTypeFraisDto(lstType);
		logger.info("findListTypeFrais()+ : after  List<TypeFraisDto>  length = {}", lst.size());
		return lst;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer addTypeFrais(TypeFraisRequest typeFraisR) throws Exception {

		logger.info("addTypeFrais() : before save type frais = {} ", typeFraisR);

		TypeFrais tf = typeFraisRepo.save(ConvertUtilitiesParam.convertToTypeFraisEntity(typeFraisR));
		if (tf.getId() == null) {
			throw new InvalidParmException(typeFraisR,
					messageSource.getMessage("typeF.operation.failed.add", null, LocaleContextHolder.getLocale()));
		}
		logger.info("addTypeFrais() : after save TypeFrais = {} ", tf);

		return tf.getId();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer updateTypeFrais(TypeFraisDto tfDto) throws Exception {

		TypeFrais typef = typeFraisRepo.findById(tfDto.getIdTypeFrais())
				.orElseThrow(() -> new ResourceNotFoundException(
						messageSource.getMessage("typeF.param.invalid.typeF", null, LocaleContextHolder.getLocale())));

		tfDto.setCodeTypFrais(typef.getCode());

		entityManager.detach(typef);

		logger.info("updateTypeFrais() : before update TypeFrais = {} , ip adresse : {} ", tfDto);

		TypeFrais res = null;

		TypeFrais typefMaj = ConvertUtilitiesParam.convertToTypeFraisEntity(tfDto);
		typefMaj.setDateCr(typef.getDateCr());
		res = typeFraisRepo.save(typefMaj);
		logger.info("updateTypeFrais() : after update TypeFrais = {} ", typefMaj);

		return res.getId();

	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Boolean deleteTypeFrais(Integer idTypeF) throws Exception {
		logger.info("deleteTypeFrais() : Before delete Type Frais id = {} ", idTypeF);
		TypeFrais typeFrais = typeFraisRepo.findById(idTypeF).orElseThrow(() -> new ResourceNotFoundException(
				messageSource.getMessage("typeF.param.invalid.typeF", null, LocaleContextHolder.getLocale())));
		if (typeFrais.getId() != null) {
			typeFraisRepo.delete(typeFrais);
			logger.info("deleteTypeFrais() : after delete Type Frais = {} ", typeFrais);
			return true;
		} else
			return false;
	}
}
