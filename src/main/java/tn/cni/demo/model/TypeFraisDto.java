package tn.cni.demo.model;

import java.util.Date;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;




public class TypeFraisDto {
	@NonNull
	private Integer idTypeFrais;
	@NonNull
	private String codeTypFrais;
	@NonNull
	private String libLang1;
	@NonNull
	private String libLang2;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

	private Date dateCr;
	public TypeFraisDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdTypeFrais() {
		return idTypeFrais;
	}
	public void setIdTypeFrais(Integer idTypeFrais) {
		this.idTypeFrais = idTypeFrais;
	}
	public String getCodeTypFrais() {
		return codeTypFrais;
	}
	public void setCodeTypFrais(String codeTypFrais) {
		this.codeTypFrais = codeTypFrais;
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
	public Date getDateCr() {
		return dateCr;
	}
	public void setDateCr(Date dateCr) {
		this.dateCr = dateCr;
	}
	public TypeFraisDto(Integer idTypeFrais, String codeTypFrais, String libLang1, String libLang2, Date dateCr) {
		super();
		this.idTypeFrais = idTypeFrais;
		this.codeTypFrais = codeTypFrais;
		this.libLang1 = libLang1;
		this.libLang2 = libLang2;
		this.dateCr = dateCr;
	}
	
	
}