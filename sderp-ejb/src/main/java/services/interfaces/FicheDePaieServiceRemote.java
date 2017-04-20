package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.FicheDePaie;

@Remote
public interface FicheDePaieServiceRemote extends IService<FicheDePaie> {
	public List<FicheDePaie> findAllFichesByEmployeeId(Integer employeeId);

}
