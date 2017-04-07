package services.interfaces;

import javax.ejb.Remote;

import entities.Journal;

@Remote
public interface JournalServiceRemote extends IService<Journal> {

}
