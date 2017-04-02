package services.impl;

import javax.ejb.Remote;

import services.interfaces.IService;

@Remote
public interface ServiceRemote extends IService<Object>{

}
