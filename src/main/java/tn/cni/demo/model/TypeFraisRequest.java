package tn.cni.demo.model;


import org.springframework.lang.NonNull;

public class TypeFraisRequest {
	@NonNull
	private String code;
	@NonNull
	private String libLang1;
	@NonNull
	private String libLang2;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibLang1() {
		return libLang1;
	}
	public void setLibLang1(String libLang1) {
		this.libLang1 = libLang1;
	}
	public String getLibLang2() {
		return libLang2;
	}
	public void setLibLang2(String libLang2) {
		this.libLang2 = libLang2;
	}
	public TypeFraisRequest(String code, String libLang1, String libLang2) {
		super();
		this.code = code;
		this.libLang1 = libLang1;
		this.libLang2 = libLang2;
	}
	
}

