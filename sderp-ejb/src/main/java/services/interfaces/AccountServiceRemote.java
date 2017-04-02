package services.interfaces;

import javax.ejb.Remote;

import entities.Account;

@Remote
public interface AccountServiceRemote extends IService<Account> {

}
