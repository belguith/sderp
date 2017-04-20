package beans.viewBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import beans.sessionBeans.GlobalBean;
import entities.Employee;
import entities.FicheDePaie;
import services.impl.FicheDePaieService;
import services.interfaces.EmployeeServiceLocal;
import utils.SalaryCalculations;

@ManagedBean(name = "fichebean")
@ViewScoped
public class FicheBean {

	@EJB
	FicheDePaieService ficheDePaieLocal;
	@EJB
	EmployeeServiceLocal employeeLocal;

	private List<Employee> allEmployees;
	private Integer employeeID;

	private List<FicheDePaie> listFicheDePaie;
	private FicheDePaie selectedFicheDePaie;
	private Integer selectedFicheDePaieID;
	private Double salaireBrut;
	private Double salaireNet;
	private Double impotSurRevenu;
	private Double salaireImposable;

	// private UserType userTypes;
	// private UserType selectedUserType;
	@ManagedProperty(value = "#{globalbean}")
	private GlobalBean globalbean;

	public FicheBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		this.selectedFicheDePaie = new FicheDePaie();
		this.listFicheDePaie = new ArrayList<>();
		this.allEmployees = new ArrayList<>();
		this.selectedFicheDePaieID = /* 12; */ 0;
		this.allEmployees = employeeLocal.findWithNamedQuery("Employee.findAll");
		for (Employee employee : allEmployees) {
			System.out.println("/////////////////////////");

			System.out.println("___________________________________" + employee.getFirstName());

			System.out.println("/////////////////////////");

		}
		System.out.println("Init User");
		if (this.globalbean.getSelectedFicheID() != 0) {
			this.selectedFicheDePaieID = /* 2; */ this.globalbean.getSelectedFicheID();
			this.selectedFicheDePaie = ficheDePaieLocal.find(selectedFicheDePaieID);
			// this.allEmployees =
			// employeeLocal.findWithNamedQuery("Employee.findAll");
			this.salaireBrut = SalaryCalculations.salaireBruteMensuel(this.selectedFicheDePaie);
			this.impotSurRevenu = SalaryCalculations.impoSurRevenue(this.selectedFicheDePaie);
			this.salaireImposable = SalaryCalculations.salaireImposableMensuel(this.selectedFicheDePaie);
			this.salaireNet = SalaryCalculations.salaireNet(this.selectedFicheDePaie);
			System.out.println("Details OK");
		}
		System.out.println("Details OK");
	}

	public String doAddOrUpdateFicheDePaie() {
		if (this.selectedFicheDePaieID == 0) {
			this.selectedFicheDePaie.setEmployee(employeeLocal.find(employeeID));

			this.selectedFicheDePaie.setDateFiche(new Date());
			this.selectedFicheDePaie = ficheDePaieLocal.create(this.selectedFicheDePaie);
			return this.globalbean.goToListFicheDePaie();
		} else if (this.selectedFicheDePaieID != 0) {
			this.selectedFicheDePaie.setDateFiche(new Date());
			this.selectedFicheDePaie = ficheDePaieLocal.update(this.selectedFicheDePaie);
		}
		return this.globalbean.goToListFicheDePaie();
	}

	public String doResetForm() {
		this.selectedFicheDePaieID = 0;
		this.selectedFicheDePaie = new FicheDePaie();
		this.globalbean.setSelectedFicheID(0);
		return "";
	}

	/*********** GEtters and Setters ***********/
	public List<FicheDePaie> getListFicheDePaie() {
		return listFicheDePaie;
	}

	public void setListFicheDePaie(List<FicheDePaie> listFicheDePaie) {
		this.listFicheDePaie = listFicheDePaie;
	}

	public Integer getSelectedFicheDePaieID() {
		return selectedFicheDePaieID;
	}

	public void setSelectedFicheDePaieID(Integer selectedFicheDePaieID) {
		this.selectedFicheDePaieID = selectedFicheDePaieID;
	}

	public FicheDePaie getSelectedFicheDePaie() {
		return selectedFicheDePaie;
	}

	public void setSelectedFicheDePaie(FicheDePaie selectedFicheDePaie) {
		this.selectedFicheDePaie = selectedFicheDePaie;
	}

	public GlobalBean getGlobalbean() {
		return globalbean;
	}

	public void setGlobalbean(GlobalBean globalbean) {
		this.globalbean = globalbean;
	}

	/**
	 * @return the salaireBrut
	 */
	public Double getSalaireBrut() {
		return salaireBrut;
	}

	/**
	 * @param salaireBrut
	 *            the salaireBrut to set
	 */
	public void setSalaireBrut(Double salaireBrut) {
		this.salaireBrut = salaireBrut;
	}

	/**
	 * @return the salaireNet
	 */
	public Double getSalaireNet() {
		return salaireNet;
	}

	/**
	 * @param salaireNet
	 *            the salaireNet to set
	 */
	public void setSalaireNet(Double salaireNet) {
		this.salaireNet = salaireNet;
	}

	/**
	 * @return the impotSurRevenu
	 */
	public Double getImpotSurRevenu() {
		return impotSurRevenu;
	}

	/**
	 * @param impotSurRevenu
	 *            the impotSurRevenu to set
	 */
	public void setImpotSurRevenu(Double impotSurRevenu) {
		this.impotSurRevenu = impotSurRevenu;
	}

	/**
	 * @return the salaireImposable
	 */
	public Double getSalaireImposable() {
		return salaireImposable;
	}

	/**
	 * @param salaireImposable
	 *            the salaireImposable to set
	 */
	public void setSalaireImposable(Double salaireImposable) {
		this.salaireImposable = salaireImposable;
	}

	public List<Employee> getAllEmployees() {
		return allEmployees;
	}

	public void setAllEmployees(List<Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

}
