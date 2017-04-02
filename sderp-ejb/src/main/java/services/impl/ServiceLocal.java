package services.impl;

import javax.ejb.Local;

import services.interfaces.IService;

@Local
public interface ServiceLocal extends IService<Object> {

}
