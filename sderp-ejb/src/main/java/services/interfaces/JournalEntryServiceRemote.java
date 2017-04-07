package services.interfaces;

import javax.ejb.Remote;

import entities.JournalEntry;

@Remote
public interface JournalEntryServiceRemote extends IService<JournalEntry> {

}
