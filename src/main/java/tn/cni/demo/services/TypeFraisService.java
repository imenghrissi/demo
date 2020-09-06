package tn.cni.demo.services;
import java.util.List;

import org.springframework.lang.NonNull;

import tn.cni.demo.model.TypeFraisDto;
import tn.cni.demo.model.TypeFraisRequest;

public interface TypeFraisService {
	
	public List<TypeFraisDto> findListTypeFrais() throws Exception;
	
	public Integer addTypeFrais(@NonNull TypeFraisRequest typeFraisR) throws Exception;
	
	public Integer updateTypeFrais(@NonNull TypeFraisDto tfDto)	throws Exception;
	
	public Boolean deleteTypeFrais(@NonNull Integer idTypeF)throws Exception;

}
