package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the journal_entry database table.
 * 
 */
@Entity
@Table(name="journal_entry")
@NamedQuery(name="JournalEntry.findAll", query="SELECT j FROM JournalEntry j")
public class JournalEntry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Boolean active;

	private Double amount;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String name;

	private String ref;

	private String state;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="journalEntry", fetch=FetchType.EAGER)
	private List<Invoice> invoices;

	//bi-directional many-to-one association to InvoicePayment
	@OneToMany(mappedBy="journalEntry", fetch=FetchType.EAGER)
	private List<InvoicePayment> invoicePayments;

	//bi-directional many-to-one association to Journal
	@ManyToOne
	private Journal journal;

	//bi-directional many-to-one association to Partner
	@ManyToOne
	private Partner partner;

	//bi-directional many-to-one association to JournalItem
	@OneToMany(mappedBy="journalEntry", fetch=FetchType.EAGER)
	private List<JournalItem> journalItems;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="journalEntry", fetch=FetchType.EAGER)
	private List<Payment> payments;

	public JournalEntry() {
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

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRef() {
		return this.ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setJournalEntry(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setJournalEntry(null);

		return invoice;
	}

	public List<InvoicePayment> getInvoicePayments() {
		return this.invoicePayments;
	}

	public void setInvoicePayments(List<InvoicePayment> invoicePayments) {
		this.invoicePayments = invoicePayments;
	}

	public InvoicePayment addInvoicePayment(InvoicePayment invoicePayment) {
		getInvoicePayments().add(invoicePayment);
		invoicePayment.setJournalEntry(this);

		return invoicePayment;
	}

	public InvoicePayment removeInvoicePayment(InvoicePayment invoicePayment) {
		getInvoicePayments().remove(invoicePayment);
		invoicePayment.setJournalEntry(null);

		return invoicePayment;
	}

	public Journal getJournal() {
		return this.journal;
	}

	public void setJournal(Journal journal) {
		this.journal = journal;
	}

	public Partner getPartner() {
		return this.partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public List<JournalItem> getJournalItems() {
		return this.journalItems;
	}

	public void setJournalItems(List<JournalItem> journalItems) {
		this.journalItems = journalItems;
	}

	public JournalItem addJournalItem(JournalItem journalItem) {
		getJournalItems().add(journalItem);
		journalItem.setJournalEntry(this);

		return journalItem;
	}

	public JournalItem removeJournalItem(JournalItem journalItem) {
		getJournalItems().remove(journalItem);
		journalItem.setJournalEntry(null);

		return journalItem;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setJournalEntry(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setJournalEntry(null);

		return payment;
	}

}