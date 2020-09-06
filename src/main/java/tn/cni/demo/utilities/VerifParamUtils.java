package tn.cni.demo.utilities;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import tn.cni.demo.exception.InvalidParmException;
import tn.cni.demo.model.TypeFraisDto;
import tn.cni.demo.model.TypeFraisRequest;

public class VerifParamUtils {
	
	private VerifParamUtils() {

		super();
	}

	
	public static void verifTypeFraisRequest(TypeFraisRequest typeFR, MessageSource messageSource) throws Exception {

		if (typeFR.getCode() == null || typeFR.getCode().length() > 3
				|| typeFR.getCode().replace(" ", "").replaceAll("[\r\n]+", "").length() == 0) {
			throw new InvalidParmException(typeFR,
					messageSource.getMessage("typeF.param.invalid.codth", null, LocaleContextHolder.getLocale()));
		}

		if (typeFR.getLibLang1() == null || typeFR.getLibLang1().length() > 200
				|| typeFR.getLibLang1().replace(" ", "").replaceAll("[\r\n]+", "").length() == 0) {
			throw new InvalidParmException(typeFR,
					messageSource.getMessage("typeF.param.invalid.namelang1", null, LocaleContextHolder.getLocale()));
		}
		if (typeFR.getLibLang2() == null || typeFR.getLibLang2().length() > 200
				|| typeFR.getLibLang2().replace(" ", "").replaceAll("[\r\n]+", "").length() == 0) {
			throw new InvalidParmException(typeFR,
					messageSource.getMessage("typeF.param.invalid.namelang2", null, LocaleContextHolder.getLocale()));
		}

	}
	
	public static void verifUpdateTypeFraisDto(TypeFraisDto tfDto, MessageSource messageSource)
			throws Exception {

		if (tfDto.getLibLang1() == null || tfDto.getLibLang1().length() > 300
				|| tfDto.getLibLang1().replace(" ", "").replaceAll("[\r\n]+", "").length() == 0) {
			throw new InvalidParmException(tfDto, messageSource
					.getMessage("typeF.param.invalid.namelang1", null, LocaleContextHolder.getLocale()));
		}
		if (tfDto.getLibLang2() == null || tfDto.getLibLang2().length() > 300
				|| tfDto.getLibLang2().replace(" ", "").replaceAll("[\r\n]+", "").length() == 0)
			 {
			throw new InvalidParmException(tfDto, messageSource
					.getMessage("typeF.param.invalid.namelang2", null, LocaleContextHolder.getLocale()));

		}
		

	}
	
}
