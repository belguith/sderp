package services.interfaces;

import javax.ejb.Local;

import entities.JournalEntry;

@Local
public interface JournalEntryServiceLocal extends IService<JournalEntry> {

}
