package beans.sessionBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Employee;
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

	private List<Employee> listEmployee = new ArrayList<>();

	private List<FicheDePaie> listFicheDePaie = new ArrayList<>();

	private User selectedUser = new User();
	private Employee selectedEmployee = new Employee();
	private FicheDePaie selectedFicheDePaie = new FicheDePaie();

	private Integer selectedEmployeeID = 0;
	private Integer selectedFicheID = 0;
	private Integer selectedUserID = 0;

	public String test = "test string from global bean";

	public GlobalBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {

		this.listUser = userLocal.findWithNamedQuery("User.findAll");
		this.listEmployee = employeeLocal.findWithNamedQuery("Employee.findAll");
		this.listFicheDePaie = ficheDePaieLocal.findWithNamedQuery("FicheDePaie.findAll");
	}

	///////////////////////// Core Methods //////////////////////////////////

	////////////////////////// Navigation Actions////////////////////////////

	/***** Users ******/
	public String goToDetailsUser() {
		if (this.selectedUserID != 0) {
			this.selectedUser = userLocal.find(selectedUserID);
			return "/pages/details/user?faces-redirect=true";
		}
		return "/pages/lists/users?faces-redirect=true";
	}

	public String goToEditUser() {
		if (this.selectedUserID != 0) {
			this.selectedUser = userLocal.find(selectedUserID);
			return "/pages/forms/user?faces-redirect=true";
		}
		return "/pages/forms/user?faces-redirect=true";

	}

	public String goToListUsers() {
		this.listUser = userLocal.findWithNamedQuery("User.findAll");
		this.selectedUser = new User();
		this.selectedUserID = 0;
		return "/pages/lists/users?faces-redirect=true";
	}

	/***** Employee ******/
	public String goToListEmployee() {
		this.listEmployee = employeeLocal.findWithNamedQuery("Employee.findAll");
		this.selectedUser = new User();
		this.selectedUserID = 0;
		return "/pages/lists/employees?faces-redirect=true";
	}

	public String goToDetailsEmployee() {
		if (this.selectedEmployeeID != 0) {
			this.selectedEmployee = employeeLocal.find(selectedEmployeeID);
			return "/pages/details/employee?faces-redirect=true";
		}
		return "/pages/lists/employees?faces-redirect=true";
	}

	public String goToEditEmloyee() {
		if (this.selectedEmployeeID != 0) {
			this.selectedEmployee = employeeLocal.find(selectedEmployeeID);
			return "/pages/forms/employee?faces-redirect=true";
		}
		return "/pages/forms/employee?faces-redirect=true";

	}
	
	
	/***** Fiche de Paie ******/
	public String goToListFicheDePaie() {
		this.listFicheDePaie = ficheDePaieLocal.findWithNamedQuery("Employee.findAll");
		this.selectedFicheDePaie = new FicheDePaie();
		this.selectedFicheID = 0;
		return "/pages/lists/fiche?faces-redirect=true";
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
	
	////////////////////////////////////////////////////////////////////

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public List<Employee> getListEmployee() {
		return listEmployee;
	}

	public List<FicheDePaie> getListFicheDePaie() {
		return listFicheDePaie;
	}

	public void setListFicheDePaie(List<FicheDePaie> listFicheDePaie) {
		this.listFicheDePaie = listFicheDePaie;
	}

	public void setListEmployee(List<Employee> listEmployee) {
		this.listEmployee = listEmployee;
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
	 * @return the selectedEmployee
	 */
	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	/**
	 * @param selectedEmployee the selectedEmployee to set
	 */
	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	/**
	 * @return the selectedEmployeeID
	 */
	public Integer getSelectedEmployeeID() {
		return selectedEmployeeID;
	}

	/**
	 * @param selectedEmployeeID the selectedEmployeeID to set
	 */
	public void setSelectedEmployeeID(Integer selectedEmployeeID) {
		this.selectedEmployeeID = selectedEmployeeID;
	}

	/**
	 * @param selectedUserID the selectedUserID to set
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
	
	
	
	

}
