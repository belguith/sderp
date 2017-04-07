package services.interfaces;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserServiceLocal extends IService<User> {
	public User logIn(String userName,String password);

}
