package services.interfaces;

import javax.ejb.Remote;

import entities.Invoice;

@Remote
public interface InvoiceServiceRemote extends IService<Invoice> {

}
