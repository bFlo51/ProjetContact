package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nom;
	private String pnom;
	
	
	public Contact(String pnom, String nom) {
		this.pnom = pnom;
		this.nom = nom;
	}
	
	public Contact(){
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}
	
	public String getUrlModif() {
		return "location.href='/modifContact/" + this.id + "'";
	}
	
	public String getUrlSuppr() {
		return "location.href='/contactSuppr/" + this.id + "'";
	}
	

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPnom() {
		return pnom;
	}

	public void setPnom(String pnom) {
		this.pnom = pnom;
	}

	
	@Override
    public String toString() {
        return String.format(
                "Contact[id=%d, pnom='%s', nom='%s']",
                id, pnom, nom);
    }
}
