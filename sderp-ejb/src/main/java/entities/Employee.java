package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer category;

	private Integer children;

	private String departement;

	private Integer echelon;

	@Column(name="element_variable")
	private String elementVariable;

	private Byte family;

	@Column(name="first_name")
	private String firstName;

	@Column(name="job_title")
	private String jobTitle;

	@Column(name="last_name")
	private String lastName;

	@Column(name="num_cin")
	private Integer numCin;

	@Column(name="num_cnss")
	private String numCnss;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="manager_id")
	private Employee employee;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="employee", fetch=FetchType.EAGER)
	private List<Employee> employees;

	//bi-directional many-to-one association to FicheDePaie
	@OneToMany(mappedBy="employee", fetch=FetchType.EAGER)
	private List<FicheDePaie> ficheDePaies;

	//bi-directional many-to-one association to User
	@OneToOne(mappedBy="employee", fetch=FetchType.EAGER)
	private User user;

	public Employee() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategory() {
		return this.category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getChildren() {
		return this.children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public String getDepartement() {
		return this.departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public Integer getEchelon() {
		return this.echelon;
	}

	public void setEchelon(Integer echelon) {
		this.echelon = echelon;
	}

	public String getElementVariable() {
		return this.elementVariable;
	}

	public void setElementVariable(String elementVariable) {
		this.elementVariable = elementVariable;
	}

	public Byte getFamily() {
		return this.family;
	}

	public void setFamily(Byte family) {
		this.family = family;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getNumCin() {
		return this.numCin;
	}

	public void setNumCin(Integer numCin) {
		this.numCin = numCin;
	}

	public String getNumCnss() {
		return this.numCnss;
	}

	public void setNumCnss(String numCnss) {
		this.numCnss = numCnss;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setEmployee(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setEmployee(null);

		return employee;
	}

	public List<FicheDePaie> getFicheDePaies() {
		return this.ficheDePaies;
	}

	public void setFicheDePaies(List<FicheDePaie> ficheDePaies) {
		this.ficheDePaies = ficheDePaies;
	}

	public FicheDePaie addFicheDePay(FicheDePaie ficheDePay) {
		getFicheDePaies().add(ficheDePay);
		ficheDePay.setEmployee(this);

		return ficheDePay;
	}

	public FicheDePaie removeFicheDePay(FicheDePaie ficheDePay) {
		getFicheDePaies().remove(ficheDePay);
		ficheDePay.setEmployee(null);

		return ficheDePay;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	

}