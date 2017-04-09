package beans.viewBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import beans.sessionBeans.GlobalBean;
import entities.User;
import services.interfaces.UserServiceLocal;

@ManagedBean(name = "profilebean")
@ViewScoped
public class ProfileBean {
	
	@EJB
	UserServiceLocal userLocal;
	
	@ManagedProperty(value = "#{globalbean}")
	private GlobalBean globalbean;
	
	private List<User> listUser;
	private User selectedUser;
	private Integer selectedUserID;
	
	
	public ProfileBean() {
		super();
		// TODO Auto-generated constructor stub
	}


}
