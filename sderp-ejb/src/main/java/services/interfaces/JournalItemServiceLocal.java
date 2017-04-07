package services.interfaces;

import javax.ejb.Local;

import entities.JournalItem;

@Local
public interface JournalItemServiceLocal extends IService<JournalItem> {

}
