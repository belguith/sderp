package services.interfaces;

import javax.ejb.Local;

import entities.Inventory;

@Local
public interface InventoryServiceLocal extends IService<Inventory> {

}
