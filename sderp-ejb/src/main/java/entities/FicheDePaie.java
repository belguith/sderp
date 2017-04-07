package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the fiche_de_paie database table.
 * 
 */
@Entity
@Table(name = "fiche_de_paie")
@NamedQuery(name = "FicheDePaie.findAll", query = "SELECT f FROM FicheDePaie f")
public class FicheDePaie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_fiche")
	private Date dateFiche;

	@Column(name = "matricule_cnss")
	private String matriculeCnss;

	@Column(name = "prime_de_panier")
	private Double primeDePanier;

	@Column(name = "prime_de_presence")
	private Double primeDePresence;

	@Column(name = "prime_de_production")
	private Double primeDeProduction;

	@Column(name = "prime_de_transport")
	private Double primeDeTransport;

	@Column(name = "prime_speciale")
	private Double primeSpeciale;

	@Column(name = "retenue_cnss")
	private Double retenueCnss;

	@Column(name = "salaire_de_base")
	private Double salaireDeBase;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	public FicheDePaie() {
	}

	public FicheDePaie(Date dateFiche, String matriculeCnss, Double primeDePanier, Double primeDePresence,
			Double primeDeProduction, Double primeDeTransport, Double primeSpeciale, Double retenueCnss,
			Double salaireDeBase) {
		super();
		this.dateFiche = dateFiche;
		this.matriculeCnss = matriculeCnss;
		this.primeDePanier = primeDePanier;
		this.primeDePresence = primeDePresence;
		this.primeDeProduction = primeDeProduction;
		this.primeDeTransport = primeDeTransport;
		this.primeSpeciale = primeSpeciale;
		this.retenueCnss = retenueCnss;
		this.salaireDeBase = salaireDeBase;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateFiche() {
		return this.dateFiche;
	}

	public void setDateFiche(Date dateFiche) {
		this.dateFiche = dateFiche;
	}

	public String getMatriculeCnss() {
		return this.matriculeCnss;
	}

	public void setMatriculeCnss(String matriculeCnss) {
		this.matriculeCnss = matriculeCnss;
	}

	public Double getPrimeDePanier() {
		return this.primeDePanier;
	}

	public void setPrimeDePanier(Double primeDePanier) {
		this.primeDePanier = primeDePanier;
	}

	public Double getPrimeDePresence() {
		return this.primeDePresence;
	}

	public void setPrimeDePresence(Double primeDePresence) {
		this.primeDePresence = primeDePresence;
	}

	public Double getPrimeDeProduction() {
		return this.primeDeProduction;
	}

	public void setPrimeDeProduction(Double primeDeProduction) {
		this.primeDeProduction = primeDeProduction;
	}

	public Double getPrimeDeTransport() {
		return this.primeDeTransport;
	}

	public void setPrimeDeTransport(Double primeDeTransport) {
		this.primeDeTransport = primeDeTransport;
	}

	public Double getPrimeSpeciale() {
		return this.primeSpeciale;
	}

	public void setPrimeSpeciale(Double primeSpeciale) {
		this.primeSpeciale = primeSpeciale;
	}

	public Double getRetenueCnss() {
		return this.retenueCnss;
	}

	public void setRetenueCnss(Double retenueCnss) {
		this.retenueCnss = retenueCnss;
	}

	public Double getSalaireDeBase() {
		return this.salaireDeBase;
	}

	public void setSalaireDeBase(Double salaireDeBase) {
		this.salaireDeBase = salaireDeBase;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "FicheDePaie [dateFiche=" + dateFiche.toString() + ", matriculeCnss=" + matriculeCnss
				+ ", primeDePanier=" + primeDePanier + ", primeDePresence=" + primeDePresence + ", primeDeProduction="
				+ primeDeProduction + ", primeDeTransport=" + primeDeTransport + ", primeSpeciale=" + primeSpeciale
				+ ", retenueCnss=" + retenueCnss + ", salaireDeBase=" + salaireDeBase + ", employee=" + employee + "]";
	}

}