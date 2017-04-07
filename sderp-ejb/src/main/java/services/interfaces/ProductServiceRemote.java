package services.interfaces;

import javax.ejb.Remote;

import entities.Product;

@Remote
public interface ProductServiceRemote extends IService<Product> {

}
