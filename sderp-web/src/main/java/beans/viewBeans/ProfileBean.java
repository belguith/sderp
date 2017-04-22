package beans.viewBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import beans.sessionBeans.GlobalBean;
import entities.Employee;
import entities.User;
import enums.Dempartement;
import enums.JobTitle;
import enums.UserType;
import services.interfaces.EmployeeServiceLocal;
import services.interfaces.UserServiceLocal;

@ManagedBean(name = "profilebean")
@ViewScoped
public class ProfileBean {

	@EJB
	UserServiceLocal userLocal;
	
	@EJB
	EmployeeServiceLocal employeeLocal;

	@ManagedProperty(value = "#{globalbean}")
	private GlobalBean globalbean;

	private List<User> listUser;
	private UserType[] userTypes;
	private JobTitle[] jobTitles;
	private Dempartement[] departements;
	private User selectedUser;
	private Integer selectedUserID;
	private Boolean falilly = false;
	private Integer selectedManagerID=0;
	

	public ProfileBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	private void init() {
		this.userTypes = UserType.values();
		this.jobTitles = JobTitle.values();
		this.departements = Dempartement.values();

		this.selectedUser = new User();
		this.selectedUser.setEmployee(new Employee());
		this.listUser = globalbean.getListUser();
		this.selectedUserID = 0;
		this.selectedManagerID=0;

		if (this.globalbean.getSelectedUserID() != 0) {
			System.out.println("selected user "+this.globalbean.getSelectedUserID());
			this.selectedUserID = this.globalbean.getSelectedUserID();
			this.selectedUser = userLocal.find(selectedUserID);
			
			System.out.println("Details OK" + this.selectedUser.getLogin());
		}

	}

	public String doAddOrUpdate() {
		if (this.selectedUserID == 0) {
			System.out.println("Ajout");
			System.out.println("manager id "+this.selectedManagerID);
			if(this.selectedManagerID!=0)
			this.selectedUser.getEmployee().setEmployee(employeeLocal.find(selectedManagerID));
			this.selectedUser.setEmployee(employeeLocal.create(this.selectedUser.getEmployee()));
			this.selectedUser = userLocal.create(this.selectedUser);
		} else if (this.selectedUserID != 0) {
			System.out.println("Update");
			if(this.selectedManagerID!=0)
			this.selectedUser.getEmployee().setEmployee(employeeLocal.find(selectedManagerID));
			this.selectedUser.setEmployee(employeeLocal.update(this.selectedUser.getEmployee()));
			this.selectedUser = userLocal.update(this.selectedUser);
		}

		return this.globalbean.goToListEmployee();
	}

	public String doResetForm() {
		this.selectedUserID = 0;
		this.selectedUser = new User();
		this.globalbean.setSelectedUserID(0);

		return "";
	}

	//////////// Getter & Setters /////////////
	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public Integer getSelectedUserID() {
		return selectedUserID;
	}

	public void setSelectedUserID(Integer selectedUserID) {
		this.selectedUserID = selectedUserID;
	}

	public GlobalBean getGlobalbean() {
		return globalbean;
	}

	public void setGlobalbean(GlobalBean globalbean) {
		this.globalbean = globalbean;
	}

	public UserType[] getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(UserType[] userTypes) {
		this.userTypes = userTypes;
	}

	public JobTitle[] getJobTitles() {
		return jobTitles;
	}

	public void setJobTitles(JobTitle[] jobTitles) {
		this.jobTitles = jobTitles;
	}

	public Dempartement[] getDepartements() {
		return departements;
	}

	public void setDepartements(Dempartement[] departements) {
		this.departements = departements;
	}

	public Boolean getFalilly() {
		return falilly;
	}

	public void setFalilly(Boolean falilly) {
		this.falilly = falilly;
	}

	public Integer getSelectedManagerID() {
		return selectedManagerID;
	}

	public void setSelectedManagerID(Integer selectedManagerID) {
		this.selectedManagerID = selectedManagerID;
	}
	
	

}
