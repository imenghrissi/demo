package tn.cni.demo.model;


public class IdRequest {
	
	private Long id;
	private Long id2;
	private Boolean resultat;
	private String numero;
	private String Date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId2() {
		return id2;
	}
	public void setId2(Long id2) {
		this.id2 = id2;
	}
	public Boolean getResultat() {
		return resultat;
	}
	public void setResultat(Boolean resultat) {
		this.resultat = resultat;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	@Override
	public String toString() {
		return "IdRequest [id=" + id + ", id2=" + id2 + ", resultat=" + resultat + ", numero=" + numero + ", Date="
				+ Date + "]";
	}

	
}
