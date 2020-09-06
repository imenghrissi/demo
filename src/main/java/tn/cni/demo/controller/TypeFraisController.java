package tn.cni.demo.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.cni.demo.exception.InvalidParmException;
import tn.cni.demo.model.IdRequest;
import tn.cni.demo.model.TypeFraisDto;
import tn.cni.demo.model.TypeFraisRequest;
import tn.cni.demo.services.TypeFraisService;
import tn.cni.demo.utilities.VerifParamUtils;


@RestController
public class TypeFraisController {
	private static final Logger logger = LoggerFactory.getLogger(TypeFraisController.class);
	@Autowired
	TypeFraisService typeFraisService;
	@Autowired
	MessageSource messageSource;
	
	
	@GetMapping(path = "/findListTypeFrais")
	public ResponseEntity<Object> findListTypeFrais() throws Exception {

		logger.info("findListTypeFrais(): before");
		List<TypeFraisDto> lst;
		lst = typeFraisService.findListTypeFrais();
		logger.info("findListTypeFrais() : After : list size : {} ", lst.size());
		return new ResponseEntity<>(lst, HttpStatus.OK);
	}
	
	@PostMapping(path = "/addTypeFrais")
	public ResponseEntity<Integer> addTypeFrais(@RequestBody @NonNull TypeFraisRequest typeFReq)
			throws Exception {
		logger.info("addTypeFrais(): before : TypeFraisRequest : {} ", typeFReq);
		
		/*
		 * add typeFrais
		 */
		VerifParamUtils.verifTypeFraisRequest(typeFReq, messageSource);
		Integer idTh = typeFraisService.addTypeFrais(typeFReq);
		logger.info("addTypeFrais(): after : id added TypeFrais : {} ", idTh);
		return new ResponseEntity<Integer>(idTh, HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/updateTypeFrais")
	public ResponseEntity<Integer> updateTypeFrais(@RequestBody @NonNull TypeFraisDto tfDto)
			throws Exception {
		logger.info("updateTypeFrais(): before : TypeFraisDto : {} ", tfDto);
		
		VerifParamUtils.verifUpdateTypeFraisDto(tfDto, messageSource);
		Integer resUpdate = typeFraisService.updateTypeFrais(tfDto);
		if (resUpdate == null || resUpdate == 0) {
			logger.info("UpdateTypeFrais(): after : update result : {} ", resUpdate);
			throw new InvalidParmException(resUpdate, messageSource.getMessage("typeF.operation.failed.update",
					null, LocaleContextHolder.getLocale()));
		} else
			return new ResponseEntity<Integer>(resUpdate, HttpStatus.OK);
	}
	
	@PostMapping(path = "/deleteTypeFrais")
	public ResponseEntity<Boolean> deleteTypeFrais(@NonNull @RequestBody IdRequest idTypeF)
			throws Exception {
		
		logger.info("deleteTypeFrais() : Before : Type Frais Id : {}", idTypeF.getId());
		Boolean deleted = false;

		try {
			deleted = typeFraisService.deleteTypeFrais(idTypeF.getId().intValue());
	    	} catch (DataIntegrityViolationException e) {
			String m = messageSource.getMessage("typeF.operation.failed.delete", null,
					LocaleContextHolder.getLocale());
			throw new DataIntegrityViolationException(m);
	     	}
	
	logger.info("deleteTypeFrais() : After : Type Frais : {}", idTypeF.getId());

	return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
}
