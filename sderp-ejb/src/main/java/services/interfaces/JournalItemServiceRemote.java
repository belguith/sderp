package services.interfaces;

import javax.ejb.Remote;

import entities.JournalItem;

@Remote
public interface JournalItemServiceRemote extends IService<JournalItem> {

}
