package metier;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

/*
 * Si on veut afficher les resultat en xml il utiliser jaxb;
 * Plus precisemment l'annotation @XmlRootElement de jaxb.
 * L'objet Compte va être converti en un élément xml qui 
 * s'appelle.
 * La racine de l'élément xml, c'est compte. Les objets se trouvent 
 * dans un arbre, il faut spécifier quel est objet racine, l'élément
 * racine.
 */
@XmlRootElement
public class Compte implements Serializable{
	
	private int code;
	private double solde;
	

	private Date date;
	
	
	public Compte() {
		super();
	}

	public Compte(int code, double solde, Date date) {
		super();
		this.code = code;
		this.solde = solde;
		this.date = date;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}


	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	/*
	 * Si on ne veut pas envoyer la date au client
	 * on peut utiliser l'anotation JsonIgnore
	 * C'est une annotation de jackson; quand il convertira
	 * cette objet en json, il ne va pas prendre l'attribut date
	 * en consideration
	 * Ici, on utilisera pas l'annotation @JsonIgnore 
	 * Car on utilise l'anotation jaxb  @XmlRootElement. 
	 * On utilisera l'anotation @XmlTransient. 
	 * Jackson prend en compte les annotations jaxb tel que @XmlTransient.
	 * Quand on utilise l'annotation @XmlRootElement,
	 * Ce qu'on va utiliser l'annotation @XmlTransient, dans le
	 * cas où on ne veut pas envoyer une information
	 * au client.
	 * Si on utilise pas @XmlRootElement c'est que ce n'est pas
	 * un objet jaxb; donc on peut utiliser @JsonIgnore.
	 * Ici on serialise un compte mais ce n'est pas la peine de 
	 * prendre en compte la date
	 */ 
	//@JsonIgnore
	@XmlTransient 
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

}
