package tn.cni.demo.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.NonNull;

import tn.cni.demo.model.TypeFrais;
import tn.cni.demo.model.TypeFraisDto;
import tn.cni.demo.model.TypeFraisRequest;

public class ConvertUtilitiesParam {
	
	public static TypeFraisDto convertToTypeFraisDto(@NonNull TypeFrais typeF) {

		TypeFraisDto tfDto = new TypeFraisDto();
		tfDto.setIdTypeFrais(typeF.getId());
		tfDto.setCodeTypFrais(typeF.getCode());
		tfDto.setLibLang1(typeF.getDesLang1());
		tfDto.setLibLang2(typeF.getDesLang2());

		return tfDto;
	}

	
	public static List<TypeFraisDto> convertToLstTypeFraisDto(List<TypeFrais> list) {

		List<TypeFraisDto> lstResp = new ArrayList<>();
		if (list != null) {
			for (TypeFrais tf : list) {
				lstResp.add(convertToTypeFraisDto(tf));
			}
		}
		return lstResp;
	}

	public static TypeFrais convertToTypeFraisEntity(@NonNull TypeFraisDto typeFDto) {

		TypeFrais tf = new TypeFrais();
		tf.setId(typeFDto.getIdTypeFrais());
		tf.setCode(typeFDto.getCodeTypFrais());
		tf.setDesLang2(typeFDto.getLibLang2());
		tf.setDesLang1(typeFDto.getLibLang1());
		return tf;
	}

	
	public static TypeFrais convertToTypeFraisEntity(TypeFraisRequest typeFR) {

		TypeFrais typeF = new TypeFrais();
		
		if (typeFR != null) {

			typeF.setCode(typeFR.getCode().replace(" ", "").replaceAll("[\r\n]+", "").toUpperCase());
			typeF.setDesLang1(typeFR.getLibLang1());
			typeF.setDesLang2(typeFR.getLibLang2().toUpperCase());
		
		}
		return typeF;
	}



}
