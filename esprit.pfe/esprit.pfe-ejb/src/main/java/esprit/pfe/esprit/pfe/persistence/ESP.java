package esprit.pfe.esprit.pfe.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ESP implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
    private int idESP;
	
	   
	    private String nomEtudiantesp;
	    
	  
		 
	    private String prenomEtudiantesp;
	    private String keyy;
	    
	   
	    private String ecoleEtudiantesp;
	    
	    
	    private String emailEtudiantesp;
	    private int autorisationESP;
	    private String Esp;
	    
	   
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID")
		public int getIdESP() {
			return idESP;
		}
		public void setIdESP(int idESP) {
			this.idESP = idESP;
		}
		
		public String getKeyy() {
			return keyy;
		}
		public void setKeyy(String keyy) {
			this.keyy = keyy;
		}
		public String getNomEtudiantesp() {
			return nomEtudiantesp;
		}
		public void setNomEtudiantesp(String nomEtudiantesp) {
			this.nomEtudiantesp = nomEtudiantesp;
		}
		public String getPrenomEtudiantesp() {
			return prenomEtudiantesp;
		}
		public void setPrenomEtudiantesp(String prenomEtudiantesp) {
			this.prenomEtudiantesp = prenomEtudiantesp;
		}
		public String getEcoleEtudiantesp() {
			return ecoleEtudiantesp;
		}
		public void setEcoleEtudiantesp(String ecoleEtudiantesp) {
			this.ecoleEtudiantesp = ecoleEtudiantesp;
		}
		public String getEmailEtudiantesp() {
			return emailEtudiantesp;
		}
		public void setEmailEtudiantesp(String emailEtudiantesp) {
			this.emailEtudiantesp = emailEtudiantesp;
		}
		public int getAutorisationESP() {
			return autorisationESP;
		}
		public void setAutorisationESP(int autorisationESP) {
			this.autorisationESP = autorisationESP;
		}
		public String getEsp() {
			return Esp;
		}
		public void setEsp(String esp) {
			Esp = esp;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public ESP() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ESP(int idESP, String nomEtudiantesp, String prenomEtudiantesp, String ecoleEtudiantesp,
				String emailEtudiantesp, int autorisationESP, String esp) {
			super();
			this.idESP = idESP;
			this.nomEtudiantesp = nomEtudiantesp;
			this.prenomEtudiantesp = prenomEtudiantesp;
			this.ecoleEtudiantesp = ecoleEtudiantesp;
			this.emailEtudiantesp = emailEtudiantesp;
			this.autorisationESP = autorisationESP;
			Esp = esp;
		}
		public ESP(String nomEtudiantesp, String prenomEtudiantesp, String ecoleEtudiantesp, String emailEtudiantesp,
				int autorisationESP, String esp) {
			super();
			this.nomEtudiantesp = nomEtudiantesp;
			this.prenomEtudiantesp = prenomEtudiantesp;
			this.ecoleEtudiantesp = ecoleEtudiantesp;
			this.emailEtudiantesp = emailEtudiantesp;
			this.autorisationESP = autorisationESP;
			Esp = esp;
		}
		public ESP(String nomEtudiantesp, String prenomEtudiantesp, String keyy, String ecoleEtudiantesp,
				String emailEtudiantesp, int autorisationESP, String esp) {
			super();
			this.nomEtudiantesp = nomEtudiantesp;
			this.prenomEtudiantesp = prenomEtudiantesp;
			this.keyy = keyy;
			this.ecoleEtudiantesp = ecoleEtudiantesp;
			this.emailEtudiantesp = emailEtudiantesp;
			this.autorisationESP = autorisationESP;
			Esp = esp;
		}
		
	    
	    
	    
}
