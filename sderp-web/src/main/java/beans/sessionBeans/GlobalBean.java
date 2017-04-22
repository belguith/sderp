package beans.sessionBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.FicheDePaie;
import entities.User;
import services.interfaces.EmployeeServiceLocal;
import services.interfaces.FicheDePaieServiceLocal;
import services.interfaces.UserServiceLocal;

@ManagedBean(name = "globalbean")
@SessionScoped
public class GlobalBean {

	@EJB
	private UserServiceLocal userLocal;
	@EJB
	private EmployeeServiceLocal employeeLocal;
	@EJB
	private FicheDePaieServiceLocal ficheDePaieLocal;

	private List<User> listUser = new ArrayList<>();

	private List<FicheDePaie> listFicheDePaie = new ArrayList<>();

	private User selectedUser = new User();
	private FicheDePaie selectedFicheDePaie = new FicheDePaie();

	private Integer selectedFicheID = 0;
	private Integer selectedUserID = 0;

	private List<String> breadcrumb = new ArrayList<>();
	public String test = "test string from global bean";

	public GlobalBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {

		this.listUser = userLocal.findWithNamedQuery("User.findAll");
		this.listFicheDePaie = ficheDePaieLocal.findWithNamedQuery("FicheDePaie.findAll");
	}

	public List<FicheDePaie> allfichesByEmployee(Integer employeeId) {
		return ficheDePaieLocal.findAllFichesByEmployeeId(employeeId);
	}
	///////////////////////// Core Methods //////////////////////////////////

	////////////////////////// Navigation Actions////////////////////////////

	/***** Employee ******/
	public String goToListEmployee() {
		this.listUser = userLocal.findWithNamedQuery("User.findAll");
		this.selectedUser = new User();
		this.selectedUserID = 0;
		this.breadcrumb.add(0, "List");
		this.breadcrumb.add(1, "Employee");
		return "/pages/lists/employees?faces-redirect=true";
	}

	public String goToDetailsEmployee() {
		if (this.selectedUserID != 0) {
			System.out.println("globalbean.selectduserID " + this.selectedUserID);

			this.breadcrumb.add(0, "Profile");
			this.breadcrumb.add(1, "Employee");
			return "/pages/details/profile?faces-redirect=true";
		}
		this.breadcrumb.add(0, "List");
		this.breadcrumb.add(1, "Employee");
		return "/pages/lists/employees?faces-redirect=true";
	}

	public String goToEditEmloyee() {
		if (this.selectedUserID != 0) {
			System.out.println("globalbean.selectduserID " + this.selectedUserID);
			this.breadcrumb.add(0, "Form");
			this.breadcrumb.add(1, "Employee");
			return "/pages/forms/employee?faces-redirect=true";
		}
		this.breadcrumb.add(0, "Form");
		this.breadcrumb.add(1, "Employee");
		return "/pages/forms/employee?faces-redirect=true";

	}

	/***** Fiche de Paie ******/
	public String goToListFicheDePaie() {
		this.listFicheDePaie = ficheDePaieLocal.findWithNamedQuery("FicheDePaie.findAll");
		this.selectedFicheDePaie = new FicheDePaie();
		this.selectedFicheID = 0;
		return "/pages/lists/fiches?faces-redirect=true";
	}

	public String goToDetailsFicheDePaie() {
		if (this.selectedFicheID != 0) {
			this.selectedFicheDePaie = ficheDePaieLocal.find(selectedFicheID);
			return "/pages/details/fiche?faces-redirect=true";
		}
		return "/pages/lists/fiche?faces-redirect=true";
	}

	public String goToEditFicheDePaie() {
		if (this.selectedFicheID != 0) {
			this.selectedFicheDePaie = ficheDePaieLocal.find(selectedFicheID);
			return "/pages/forms/fiche?faces-redirect=true";
		}
		return "/pages/forms/fiche?faces-redirect=true";

	}

	public String goToDashboard() {
		this.breadcrumb = new ArrayList<>();
		return "/index?faces-redirect=true";
	}

	////////////////////////////////////////////////////////////////////

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public List<FicheDePaie> getListFicheDePaie() {
		return listFicheDePaie;
	}

	public void setListFicheDePaie(List<FicheDePaie> listFicheDePaie) {
		this.listFicheDePaie = listFicheDePaie;
	}

	public Integer getSelectedUserID() {
		return selectedUserID;
	}

	public UserServiceLocal getUserLocal() {
		return userLocal;
	}

	public void setUserLocal(UserServiceLocal userLocal) {
		this.userLocal = userLocal;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	/**
	 * @param selectedUserID
	 *            the selectedUserID to set
	 */
	public void setSelectedUserID(Integer selectedUserID) {
		this.selectedUserID = selectedUserID;
	}

	public FicheDePaie getSelectedFicheDePaie() {
		return selectedFicheDePaie;
	}

	public void setSelectedFicheDePaie(FicheDePaie selectedFicheDePaie) {
		this.selectedFicheDePaie = selectedFicheDePaie;
	}

	public Integer getSelectedFicheID() {
		return selectedFicheID;
	}

	public void setSelectedFicheID(Integer selectedFicheID) {
		this.selectedFicheID = selectedFicheID;
	}

	public List<String> getBreadcrumb() {
		return breadcrumb;
	}

	public void setBreadcrumb(List<String> breadcrumb) {
		this.breadcrumb = breadcrumb;
	}

}
