package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the journal_item database table.
 * 
 */
@Entity
@Table(name="journal_item")
@NamedQuery(name="JournalItem.findAll", query="SELECT j FROM JournalItem j")
public class JournalItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Boolean active;

	@Column(name="cost_of_goods_sold")
	private Double costOfGoodsSold;

	private Double credit;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private Double debit;

	private String name;

	private Double quantity;

	private String ref;

	@Column(name="residual_amount")
	private Double residualAmount;

	@Column(name="tax_amount")
	private Double taxAmount;

	//bi-directional many-to-one association to Account
	@ManyToOne
	private Account account;

	//bi-directional many-to-one association to Journal
	@ManyToOne
	private Journal journal;

	//bi-directional many-to-one association to JournalEntry
	@ManyToOne
	@JoinColumn(name="entry_id")
	private JournalEntry journalEntry;

	//bi-directional many-to-one association to Partner
	@ManyToOne
	private Partner partner;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to ProductUom
	@ManyToOne
	@JoinColumn(name="uom_id")
	private ProductUom productUom;

	//bi-directional many-to-one association to Tax
	@ManyToOne
	private Tax tax;

	public JournalItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Double getCostOfGoodsSold() {
		return this.costOfGoodsSold;
	}

	public void setCostOfGoodsSold(Double costOfGoodsSold) {
		this.costOfGoodsSold = costOfGoodsSold;
	}

	public Double getCredit() {
		return this.credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getDebit() {
		return this.debit;
	}

	public void setDebit(Double debit) {
		this.debit = debit;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getRef() {
		return this.ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Double getResidualAmount() {
		return this.residualAmount;
	}

	public void setResidualAmount(Double residualAmount) {
		this.residualAmount = residualAmount;
	}

	public Double getTaxAmount() {
		return this.taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Journal getJournal() {
		return this.journal;
	}

	public void setJournal(Journal journal) {
		this.journal = journal;
	}

	public JournalEntry getJournalEntry() {
		return this.journalEntry;
	}

	public void setJournalEntry(JournalEntry journalEntry) {
		this.journalEntry = journalEntry;
	}

	public Partner getPartner() {
		return this.partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductUom getProductUom() {
		return this.productUom;
	}

	public void setProductUom(ProductUom productUom) {
		this.productUom = productUom;
	}

	public Tax getTax() {
		return this.tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

}