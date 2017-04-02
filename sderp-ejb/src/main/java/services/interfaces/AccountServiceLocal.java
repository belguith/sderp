package services.interfaces;

import javax.ejb.Local;

import entities.Account;

@Local
public interface AccountServiceLocal extends IService<Account> {

}
