package sessionBeans;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.User;
import services.interfaces.UserServiceLocal;

@ManagedBean(name = "loginbean")
@SessionScoped
public class LoginBean {
	@EJB
	private UserServiceLocal userLocal;
	private User user = null;
	private String login = "";
	private String password = "";
	private Boolean isLoggedIn = false;

	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		System.out.println("Test init login");
		user = new User();
	}

	public String doLogin() {
		User userLoggedIn = null;
		String navigateTo = "";
		userLoggedIn = userLocal.logIn(login);
		if (userLoggedIn != null) {
			if (userLoggedIn.getPassword().equals(this.password)) {
				this.user = userLoggedIn;
				this.isLoggedIn = true;
				navigateTo = "/index?faces-redirect=true";
			} else {
				navigateTo = "/404?face-redirect=true";
			}
		} else {
			navigateTo = "/404?face-redirect=true";
		}
		return navigateTo;
	}

	public String doLogOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserServiceLocal getUserLocal() {
		return userLocal;
	}

	public void setUserLocal(UserServiceLocal userLocal) {
		this.userLocal = userLocal;
	}

	public Boolean getIsLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
}