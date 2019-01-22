package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import metier.Compte;

@Path("/banque")
public class BanqueRestService {
	
	/*
	 * static veut dire qu'il appartient à la classe; qu'il sera 
	 * charger une seule fois. S'il n'est pas static à chaque fois 
	 * qu'on va appeler une méthode du webservice; le webservice 
	 * par défaut, il est instancié. S'il est instancié à chaque fois
	 * cela veut dire que la collection va être initialiser.
	 * La collection static de type Map, representera un base de données
	 */
	private static Map<Integer, Compte> comptes = new HashMap<>();
	
	@GET
	@Path("/conversion/{montant}")
	@Produces(MediaType.APPLICATION_JSON)
	public double conversion(@PathParam(value="montant")double mt) {
		return mt*88.4693;
	}
	
	@GET
	@Path("/comptes/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Compte getCompte(@PathParam("code") int code) {
		return comptes.get(code);
	}
	
	@GET
	@Path("/comptes")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Compte> getComptes(){
		return new ArrayList<>(comptes.values());
	}
	
	@POST
	@Path("/comptes/saveCompte")
	@Produces(MediaType.APPLICATION_JSON)
	public Compte saveCompte(Compte cp) {
		cp.setDate(new Date()); //Dans le cas on ajoute pas la date. On l'ajoute ici
		comptes.put(cp.getCode(), cp);
		return cp;
	}
	
	@PUT
	@Path("/comptes/updateCompte/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Compte updateCompte(@PathParam("code") int code, Compte cp) {
		comptes.put(code, cp);
		return cp;
	}
	
	@DELETE
	@Path("/comptes/deleteCompte/{code}")
	public void deleteCompte(@PathParam("code") int code) {
		comptes.remove(code);
	}
}
