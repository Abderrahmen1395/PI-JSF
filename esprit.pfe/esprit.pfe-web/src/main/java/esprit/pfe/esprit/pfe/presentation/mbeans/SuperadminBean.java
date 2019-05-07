package esprit.pfe.esprit.pfe.presentation.mbeans;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Part;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.user;
import esprit.pfe.esprit.pfe.services.SuperAdmin;
import esprit.pfe.esprit.pfe.services.SuperAdminRemote;
import esprit.pfe.esprit.pfe.util.EJBLookUpUtil;
import javafx.event.ActionEvent;

@ManagedBean
@SessionScoped
public class SuperadminBean {
	 
		
	   
	    private String nomEmploye;
	    
	  
		 
	    private String prenomEmploye;
	    
	   
	    private String ecoleEmploye;
	    
	    
	    private String emailEmploye;
	    
	    
	  
		   
	    private String userNameEmploye;
	    private List<Employe> emp;
	    
	    @EJB
	    SuperAdmin sa;
	    
	    public String addadmin(){
	    	if (!sa.verifecole1(ecoleEmploye)){
	    	String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkl"
					+ "mnopqrstuvwxyz0123456789!@#$%&*()-_=+;:\'\",<.>/?";
			String pwd = RandomStringUtils.random( 15, characters );
		
			
			
			
	    	sa.ajouteradminecole(new Employe(nomEmploye,prenomEmploye,ecoleEmploye,emailEmploye,pwd,userNameEmploye,"Admin"));
	    	sa.ajouteradminecoleuser(new Employe(nomEmploye,prenomEmploye,ecoleEmploye,emailEmploye,pwd,userNameEmploye,"Admin"));
	    	addMessage("Added!", "The admin is now added.");
	    	return "affadmin.xhtml?faces-redirect=true";
	    	}
	    	
	    	return "supeeradmin.xhtml?faces-redirect=true";
	    }
	    
		public void validate(FacesContext context, UIComponent component, Object value) {
			
			if (nomEmploye.equals("aa")) 
				throw new ValidatorException(new FacesMessage("File is not a pdf file"));
		}
	    
	   
	    /*
	    public void modifier(Employe e){
	    	sa.modifadmin(e);
	    	
	    }*/
	    public String mettreAjourEmploye(){
	    	if(!sa.verifecole1(school)){
	    	sa.modifadmin(new Employe(employeIdToBeUpdated,nom,prenom,school,email,username));
	    	addMessage("Edited!", "The admin you choose is now edited.");
	    	return "affadmin.xhtml?faces-redirect=true";}
	    	else {
	    		return "edit.xhtml?faces-redirect=true";
	    	}
	    	}
	    
	    
	    public void mettreAjoursa(){
	    	sa.modifsuperadmin(new user(usernamesa,mdpsa,nomsa,prenomsa));
	    	
	    	}
	    
	    
	    
	    private String prenomsa;
	    private String nomsa;
	    private String usernamesa;
	    private String mdpsa;
	    
	    
	    
	    
	    public String getPrenomsa() {
			return prenomsa;
		}


		public void setPrenomsa(String prenomsa) {
			this.prenomsa = prenomsa;
		}


		public String getNomsa() {
			return nomsa;
		}


		public void setNomsa(String nomsa) {
			this.nomsa = nomsa;
		}


		public String getUsernamesa() {
			return usernamesa;
		}


		public void setUsernamesa(String usernamesa) {
			this.usernamesa = usernamesa;
		}


		public String getMdpsa() {
			return mdpsa;
		}


		public void setMdpsa(String mdpsa) {
			this.mdpsa = mdpsa;
		}



		private String prenom;
	    private String nom;
	    private String username;
	    private String email;
	    private String school;
	    private List<Employe> employes;
	    private Integer employeIdToBeUpdated;

	    public String getPrenom() {
			return prenom;
		}





		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}





		public String getNom() {
			return nom;
		}





		public void setNom(String nom) {
			this.nom = nom;
		}





		public String getUsername() {
			return username;
		}





		public void setUsername(String username) {
			this.username = username;
		}





		public String getEmail() {
			return email;
		}





		public void setEmail(String email) {
			this.email = email;
		}





		public String getSchool() {
			return school;
		}





		public void setSchool(String school) {
			this.school = school;
		}





		public List<Employe> getEmployes() {
			return employes;
		}





		public void setEmployes(List<Employe> employes) {
			this.employes = employes;
		}





		public Integer getEmployeIdToBeUpdated() {
			return employeIdToBeUpdated;
		}





		public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) {
			this.employeIdToBeUpdated = employeIdToBeUpdated;
		}





		public String modifier(Employe employe) throws IOException{
			
	   this.setNom(employe.getNomEmploye());
	    this.setPrenom(employe.getPrenomEmploye());
	    this.setEmail(employe.getEmailEmploye());
	    this.setUsername(employe.getUserNameEmploye());
	    this.setSchool(employe.getEcoleEmploye());
	    this.setEmployeIdToBeUpdated(employe.getIdEmploye());
	    
			return "edit.xhtml?faces-redirect=true";
	    }
	

	    
	    
	    
		public List<Employe> getEmp() {
			return emp;
		}




		public void setEmp(List<Employe> emp) {
			this.emp = emp;
		}




		public String getNomEmploye() {
			return nomEmploye;
		}

		public void setNomEmploye(String nomEmploye) {
			this.nomEmploye = nomEmploye;
		}

		public String getPrenomEmploye() {
			return prenomEmploye;
		}

		public void setPrenomEmploye(String prenomEmploye) {
			this.prenomEmploye = prenomEmploye;
		}

		public String getEcoleEmploye() {
			return ecoleEmploye;
		}

		public void setEcoleEmploye(String ecoleEmploye) {
			this.ecoleEmploye = ecoleEmploye;
		}

		public String getEmailEmploye() {
			return emailEmploye;
		}

		public void setEmailEmploye(String emailEmploye) {
			this.emailEmploye = emailEmploye;
		}

		public String getUserNameEmploye() {
			return userNameEmploye;
		}

		public void setUserNameEmploye(String userNameEmploye) {
			this.userNameEmploye = userNameEmploye;
		}

		public SuperAdmin getSa() {
			return sa;
		}

		public void setSa(SuperAdmin sa) {
			this.sa = sa;
		}
		public String supprimer(Integer empid,String empsch){
			addMessage("Deleted!", "The admin you choose is now deleted.");
	    
			sa.supprimeradmin(empid);
			sa.supprimeruser(empsch);
			return "affadmin.xhtml?faces-redirect=true";
		}
		public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	    
		   
	    public List<Employe> affadmin(){
	    	emp= sa.afficheadmin();
	    	return emp;
	    	
	    }    
	    
	 /*   public void exporter(List<Employe> a) throws ParseException, IOException{
			sa.export(a);
		}*/
	    
	    
/*	  public  void export(ActionEvent event) throws IOException, ParseException {
	    	 String[] columns = { "Ecole", "Email", "Nom",
	    	    	    "Prenom","Username" };
	    	    	  List<Employe> empl = new ArrayList<Employe>();

	    	    	  DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	    	  	    Date today = new Date();

	    	  	    Date todayWithZeroTime = formatter.parse(formatter.format(today));
	    	    	   

	    	    	    Workbook workbook = new XSSFWorkbook();
	    	    	    Sheet sheet = (Sheet) workbook.createSheet("Admin"+"_"+todayWithZeroTime.toString().substring(4,10)+".xlsx");

	    	    	    Font headerFont = workbook.createFont();
	    	    	    headerFont.setBold(true);
	    	    	    headerFont.setFontHeightInPoints((short) 14);
	    	    	    headerFont.setColor(IndexedColors.RED.getIndex());

	    	    	    CellStyle headerCellStyle = workbook.createCellStyle();
	    	    	    headerCellStyle.setFont(headerFont);

	    	    	    // Create a Row
	    	    	    Row headerRow = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(0);

	    	    	    for (int i = 0; i < columns.length; i++) {
	    	    	      Cell cell = headerRow.createCell(i);
	    	    	      cell.setCellValue(columns[i]);
	    	    	      cell.setCellStyle(headerCellStyle);
	    	    	    }

	    	    	    // Create Other rows and cells with contacts data
	    	    	    int rowNum = 1;
	    	    	   
	    	   		 
	    	   		 List<Employe> a=sa.afficheadmin();

	    	    	    for (Employe contact : a) {
	    	    	      Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(rowNum++);
	    	    	      row.createCell(0).setCellValue(contact.getEcoleEmploye());
	    	    	      row.createCell(1).setCellValue(contact.getEmailEmploye());
	    	    	      row.createCell(2).setCellValue(contact.getNomEmploye());
	    	    	      row.createCell(3).setCellValue(contact.getPrenomEmploye());
	    	    	      row.createCell(4).setCellValue(contact.getUserNameEmploye());
	    	    	    }

	    	    	    // Resize all columns to fit the content size
	    	    	    for (int i = 0; i < columns.length; i++) {
	    	    	      ((org.apache.poi.ss.usermodel.Sheet) sheet).autoSizeColumn(i);
	    	    	    }

	    	    	    // Write the output to a file
	    	    	    
	    	    	    
	    	    	    FileOutputStream fileOut = new FileOutputStream("Admin"+"_"+todayWithZeroTime.toString().substring(4,10)+".xlsx");
	    	    	    workbook.write(fileOut);
	    	    	    fileOut.close();
	    	    	System.out.println("ok");
	    	    	

	    	}*/
	    
	    
}
