package services.interfaces;

import javax.ejb.Remote;

import entities.Account;
import entities.DeliveryOrder;

@Remote
public interface DeliveryOrderServiceRemote extends IService<DeliveryOrder>{

}
