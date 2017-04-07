package services.interfaces;

import javax.ejb.Local;

import entities.Invoice;

@Local
public interface InvoiceServiceLocal extends IService<Invoice> {

}
