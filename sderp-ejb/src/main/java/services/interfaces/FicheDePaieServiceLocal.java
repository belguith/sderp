package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.FicheDePaie;

@Local
public interface FicheDePaieServiceLocal extends IService<FicheDePaie> {
	public List<FicheDePaie> findAllFichesByEmployeeId(Integer employeeId);

}
