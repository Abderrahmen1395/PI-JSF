package esprit.pfe.esprit.pfe.services;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import esprit.pfe.esprit.pfe.persistence.ESP;
import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Etudiant;
import esprit.pfe.esprit.pfe.persistence.user;



@Stateless
@LocalBean
public  class SuperAdmin implements SuperAdminRemote, SuperAdminLocal{

	@PersistenceContext()
	private EntityManager entityManager;
	
	
	public void ajouteradminecole(Employe e) {
		entityManager.merge(e);
		
	}
	public void ajouteresp(ESP esp) {
		entityManager.merge(esp);
		
		
	}
	 
   
	public void ajouteradminecoleuser(Employe e) {
		Query query = entityManager.createNativeQuery("INSERT into user (nom,  	prenom , 	username ,  "
				+ "	mdp ,role,idrole,ecoleEmploye,connected)"+
		" Values ( :a ,:b, :c, :d,:t,:n,:e,:f)",Employe.class);
			
				query
				.setParameter("a",e.getNomEmploye() )
				.setParameter("b", e.getPrenomEmploye())
				.setParameter("c",e.getUserNameEmploye())
				.setParameter("d", e.getPasswordEmploye())
				.setParameter("t",2)
				.setParameter("n",2)
				.setParameter("e",e.getEcoleEmploye())
				.setParameter("f",0)
				
				.executeUpdate();
		
		
	}
	public boolean verifecole1(String ecole) {
		boolean b=false;
		
		List<Employe> emp = new ArrayList<Employe>();
		
		
     	TypedQuery<Employe> query = entityManager.createQuery("SELECT e  FROM Employe e WHERE e.employeRole =:l" ,
     			Employe.class);
     	emp = query.setParameter("l","Admin").getResultList();
     			
    
		
		
		
		for(Employe e : emp)
		{if(e.getEcoleEmploye().equalsIgnoreCase(ecole)){
			b=true;
		}}
		

		
		
		return b;
		
	}
	
	
	public boolean verifecole(String ecole,String a) {
		boolean b=false;
		
		List<Employe> emp = new ArrayList<Employe>();
		
		
     	TypedQuery<Employe> query = entityManager.createQuery("SELECT e  FROM Employe e WHERE e.employeRole =:l" ,
     			Employe.class);
     	emp = query.setParameter("l","Admin").getResultList();
     			
    
		
		
		
		for(Employe e : emp)
		{if(e.getEcoleEmploye().equalsIgnoreCase(ecole)&&ecole!=a){
			b=true;
		}}
		

		
		
		return b;
		
	}
	
	
	public List<Employe> afficheadmin() {
		
		
		List<Employe> emp = new ArrayList<Employe>();
		
		
     	TypedQuery<Employe> query = entityManager.createQuery("SELECT e  FROM Employe e WHERE e.employeRole =:l" ,
     			Employe.class);
     	emp = query.setParameter("l","Admin").getResultList();
     	return emp;
	}
public List<ESP> afficheesp() {
		
		
		List<ESP> emp = new ArrayList<ESP>();
		
		
     	TypedQuery<ESP> query = entityManager.createQuery("SELECT e  FROM ESP e WHERE e.autorisationESP =:l" ,
     			ESP.class);
     	emp = query.setParameter("l",1).getResultList();
     	return emp;
	}
	public List<Employe> search(String ecole) {
		
		
		List<Employe> emp = new ArrayList<Employe>();
		
		
     	TypedQuery<Employe> query = entityManager.createQuery("SELECT e  FROM Employe e WHERE  e.ecoleEmploye =:a" ,
     			Employe.class);
     	emp = query.setParameter("a",ecole).getResultList();
     	return emp;
	}
public List<ESP> searchecole(String ecole) {
		
		
		List<ESP> emp = new ArrayList<ESP>();
		
		
     	TypedQuery<ESP> query = entityManager.createQuery("SELECT e  FROM ESP e WHERE  e.ecoleEtudiantesp =:a" ,
     			ESP.class);
     	emp = query.setParameter("a",ecole).getResultList();
     	return emp;
	}
	
	public void supprimeradmin(int id) {
		
		Query query = entityManager.createNativeQuery("DELETE FROM Employe WHERE 	ID=:a");
			
				query
				.setParameter("a",id )
				
				.executeUpdate();
	
       

}
public void supprimeruser(String id) {
		
		Query query = entityManager.createNativeQuery("DELETE FROM user WHERE 	ecoleEmploye=:a");
			
				query
				.setParameter("a",id )
				
				.executeUpdate();
	
       

}
	public void modifadmin(Employe e) {
		Query query = entityManager.createNativeQuery("UPDATE `Employe` SET `nomEmploye`=:a "
				+ ", `prenomEmploye`=:b , `ecoleEmploye`=:c , `emailEmploye`=:d , `userNameEmploye`=:e  ,  `employeRole`=:f,  `"
				+ "first`=:n"
				+ " WHERE ID=:l " );
		query
		.setParameter("a", e.getNomEmploye())
		.setParameter("b", e.getPrenomEmploye())
		.setParameter("c", e.getEcoleEmploye())
		.setParameter("d", e.getEmailEmploye())
		.setParameter("e", e.getUserNameEmploye())
		.setParameter("f", "Admin")
		.setParameter("l", e.getIdEmploye())
		.setParameter("n", 1)
		
		.executeUpdate();
		
		
	}
	
	public void modifsuperadmin(user e) {
		Query query = entityManager.createNativeQuery("UPDATE `user` SET `nom`=:a , `prenom`=:b , `username`=:e , `mdp`=:o  WHERE ID=:l " );
		query
		.setParameter("a", e.getNom())
		.setParameter("b", e.getPrenom())
		

		.setParameter("e", e.getUsername())
		.setParameter("o", e.getMdp())
	
		.setParameter("l", 0)
		
		
		.executeUpdate();
		
		
	}
}
