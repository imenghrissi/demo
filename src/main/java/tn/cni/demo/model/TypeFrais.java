package tn.cni.demo.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

public class TypeFrais {
	
	
	@Id
	@GeneratedValue(generator = "int-generator")
	@GenericGenerator(name = "int-generator", strategy = "tn.cni.rached.entities.customGenerator.GeneratorIntegerID")
	
	private Integer id;
	public TypeFrais() {
		super();
		// TODO Auto-generated constructor stub
	}
	@NonNull
	@Column(name = "code", nullable = false, columnDefinition = "character varying(3)")
	private String code;
	@NonNull
	@Column(name = "lib_lang1", nullable = false, columnDefinition = "character varying(120)")
	private String desLang1;
	@NonNull
	@Column(name = "lib_lang2", nullable = false, columnDefinition = "character varying(120)")
	private String desLang2;
	@CreationTimestamp
	@Column(name = "date_cr", nullable = false)
	private Date dateCr;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesLang1() {
		return desLang1;
	}
	public void setDesLang1(String desLang1) {
		this.desLang1 = desLang1;
	}
	public String getDesLang2() {
		return desLang2;
	}
	public void setDesLang2(String desLang2) {
		this.desLang2 = desLang2;
	}
	public Date getDateCr() {
		return dateCr;
	}
	public void setDateCr(Date dateCr) {
		this.dateCr = dateCr;
	}
	@Override
	public String toString() {
		return "TypeFrais [id=" + id + ", code=" + code + ", desLang1=" + desLang1 + ", desLang2=" + desLang2
				+ ", dateCr=" + dateCr + "]";
	}
	public TypeFrais(Integer id, String code, String desLang1, String desLang2, Date dateCr) {
		super();
		this.id = id;
		this.code = code;
		this.desLang1 = desLang1;
		this.desLang2 = desLang2;
		this.dateCr = dateCr;
	}
	
	
}
