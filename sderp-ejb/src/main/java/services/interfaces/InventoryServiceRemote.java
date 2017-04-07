package services.interfaces;

import javax.ejb.Remote;

import entities.Inventory;

@Remote
public interface InventoryServiceRemote extends IService<Inventory> {

}
