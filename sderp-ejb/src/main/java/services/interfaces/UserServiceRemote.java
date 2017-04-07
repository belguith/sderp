package services.interfaces;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserServiceRemote extends IService<User> {
	public User logIn(String userName);

}
