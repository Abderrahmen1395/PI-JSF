package esprit.pfe.esprit.pfe.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.pfe.esprit.pfe.persistence.ESP;
import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.user;

	@Remote
	public interface SuperAdminRemote  {
		public void ajouteradminecole(Employe e);
		public boolean verifecole(String ecole,String a);
		public boolean verifecole1(String ecole);
		public List<Employe> afficheadmin();
		public void supprimeradmin(int id);
		public void modifadmin(Employe e);
		public List<Employe> search(String ecole);
		public void ajouteradminecoleuser(Employe e);
		public void modifsuperadmin(user e);
		public void supprimeruser(String id);
		public void ajouteresp(ESP esp) ;
		public List<ESP> afficheesp();
		public List<ESP> searchecole(String ecole);
}
