package beans.sessionBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.User;
import services.interfaces.UserServiceLocal;

@ManagedBean(name = "globalbean")
@SessionScoped
public class GlobalBean {

	

	@EJB
	private UserServiceLocal userLocal;

	
	private List<User> listUser = new ArrayList<>();

	
	private User selectedUser = new User();

	
	private Integer selectedUserID = 0;

	public String test = "test string from global bean";

	public GlobalBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {

		
		this.listUser = userLocal.findWithNamedQuery("User.findAll");

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

	////////////////////////////////////////////////////////////////////

	
	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
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

	

}
