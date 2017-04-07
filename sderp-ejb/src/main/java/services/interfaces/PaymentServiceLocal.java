package services.interfaces;

import javax.ejb.Local;

import entities.Payment;

@Local
public interface PaymentServiceLocal extends IService<Payment> {

}
