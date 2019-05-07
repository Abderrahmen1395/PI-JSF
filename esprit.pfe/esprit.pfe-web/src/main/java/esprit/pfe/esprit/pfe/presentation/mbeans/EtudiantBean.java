package esprit.pfe.esprit.pfe.presentation.mbeans;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import esprit.pfe.esprit.pfe.persistence.ESP;
import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Etudiant;
import esprit.pfe.esprit.pfe.services.SuperAdmin;

@ManagedBean
@SessionScoped
public class EtudiantBean {
	 
		
	   
	    
	    
	    @EJB
	    SuperAdmin sa;
	    
	    
	    
	    
	    private int ids=1;
	    private String noms="hadjsalah";
	    private String prenoms="abderrahmen";
	    private String ecoles="ESPRIT";
	    private String emails="abd@esprit.tn";
	    private String mdps="abd95";
	    private String usernames="abdou95";
	    private int autorisationesp;
	    private int autorisationespoui=1;
	    private int autorisationespnon=0;
	    private String esppdf;
	    private UploadedFile file;
	    private Part part;
	    
	    
	    public UploadedFile getFile() {
			return file;
		}


		public void setFile(UploadedFile file) {
			this.file = file;
		}


		public int getAutorisationespoui() {
			return autorisationespoui;
		}


		public void setAutorisationespoui(int autorisationespoui) {
			this.autorisationespoui = autorisationespoui;
		}


		public int getAutorisationespnon() {
			return autorisationespnon;
		}


		public void setAutorisationespnon(int autorisationespnon) {
			this.autorisationespnon = autorisationespnon;
		}


		public String getEsppdf() {
			return esppdf;
		}


		public void setEsppdf(String esppdf) {
			this.esppdf = esppdf;
		}


		


		


		public int getIds() {
			return ids;
		}


		public void setIds(int ids) {
			this.ids = ids;
		}


		public String getNoms() {
			return noms;
		}


		public void setNoms(String noms) {
			this.noms = noms;
		}


		public String getPrenoms() {
			return prenoms;
		}


		public void setPrenoms(String prenoms) {
			this.prenoms = prenoms;
		}


		public String getEcoles() {
			return ecoles;
		}


		public void setEcoles(String ecoles) {
			this.ecoles = ecoles;
		}


		public String getEmails() {
			return emails;
		}


		public void setEmails(String emails) {
			this.emails = emails;
		}


		public String getMdps() {
			return mdps;
		}


		public void setMdps(String mdps) {
			this.mdps = mdps;
		}


		public String getUsernames() {
			return usernames;
		}


		public void setUsernames(String usernames) {
			this.usernames = usernames;
		}


		Etudiant s=new Etudiant(ids,noms,prenoms,ecoles,emails,mdps,usernames);
		
		
		 public void ajoutesp() throws IOException{
			 part.write("C:\\Users\\LENOVO\\workspace\\esprit.pfe\\esprit.pfe-web\\src\\main\\webapp\\resources\\images\\"+getFileName(part));
				this.esppdf=	getFileName(this.part);
				String str = Arrays.toString(selectedCities2);
				String str1 = str.substring(1,str.length()-1);
	    	sa.ajouteresp(new ESP(noms,prenoms,str1,ecoles,emails,autorisationesp,esppdf));
	    	
	    	//System.out.println(file.getFileName());
	    	}


		public int getAutorisationesp() {
			return autorisationesp;
		}


		public void setAutorisationesp(int autorisationesp) {
			this.autorisationesp = autorisationesp;
		}


		public Part getPart() {
			return part;
		}


		public void setPart(Part part) {
			this.part = part;
		}
	    
		public String Upload() throws IOException {
			part.write("C:\\Users\\LENOVO\\workspace\\esprit.pfe\\esprit.pfe-web\\src\\main\\webapp\\resources\\images\\"+getFileName(part));
			return "result";
		}
		
		private List<ESP> espz;
		
		public void validate(FacesContext context, UIComponent component, Object value) {
			Part file = (Part) value;
			if (file.getSize() > 500000) {
				throw new ValidatorException(new FacesMessage("File is too large"));
			}
			if (!file.getContentType().equals("application/pdf")) 
				throw new ValidatorException(new FacesMessage("File is not a pdf file"));
		}
		
		
public List<ESP> getEspz() {
			return espz;
		}


		public void setEspz(List<ESP> espz) {
			this.espz = espz;
		}


private static String getFileName(Part part){
			
			for(String cd: part.getHeader("content-disposition").split(";")){
				
				if(cd.trim().startsWith("filename")){
					
					String filename= cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
					return filename.substring(filename.lastIndexOf('/')+1).substring(filename.lastIndexOf('\\')+1);
				}
				
			}
			return null;
			
		}

private String ss;


public String getSs() {
	return ss;
}


public void setSs(String ss) {
	this.ss = ss;
}

public String esps() throws IOException{
	return "displayesps.xhtml?faces-redirect=true";
	    

	
}   
public String esp() throws IOException{
	return "displayesp.xhtml?faces-redirect=true";
	    

	
} 
public List<ESP> affesp() throws IOException{
	// String uri = "displayesp.xhtml";
	   // FacesContext.getCurrentInstance().getExternalContext().dispatch(uri);
	espz= sa.afficheesp();
	return espz;
	
}    
public List<ESP> affesps() throws IOException{
	// String uri = "displayesp.xhtml";
	   // FacesContext.getCurrentInstance().getExternalContext().dispatch(uri);
	espz= sa.searchecole(ss);
	return espz;
	
}    



private String[] selectedConsoles;
private String[] selectedConsoles2;
private String[] selectedCities;
private String[] selectedCities2;
private List<String> cities;
private List<SelectItem> cars;
private String[] selectedCars;

@PostConstruct
public void init() {
    cities = new ArrayList<String>();
    cities.add("JAVA");
    cities.add("JEE");
    cities.add("Symfony");
    cities.add("PHP");
    cities.add("HTML");
    cities.add("Network");
    cities.add("Electronic");
    cities.add("Mecanic");
    cities.add("Bussines");
    cities.add("Finance");
    cities.add("Python");
    cities.add("French");
    cities.add("English");
     
 
}

public String[] getSelectedConsoles() {
    return selectedConsoles;
}

public void setSelectedConsoles(String[] selectedConsoles) {
    this.selectedConsoles = selectedConsoles;
}

public String[] getSelectedCities() {
    return selectedCities;
}

public void setSelectedCities(String[] selectedCities) {
    this.selectedCities = selectedCities;
}

public String[] getSelectedCities2() {
    return selectedCities2;
}

public void setSelectedCities2(String[] selectedCities2) {
    this.selectedCities2 = selectedCities2;
}

public String[] getSelectedConsoles2() {
    return selectedConsoles2;
}

public void setSelectedConsoles2(String[] selectedConsoles2) {
    this.selectedConsoles2 = selectedConsoles2;
}

public List<String> getCities() {
    return cities;
}

public List<SelectItem> getCars() {
    return cars;
}

public void setCars(List<SelectItem> cars) {
    this.cars = cars;
}

public String[] getSelectedCars() {
    return selectedCars;
}

public void setSelectedCars(String[] selectedCars) {
    this.selectedCars = selectedCars;
}
}
