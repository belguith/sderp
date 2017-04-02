package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the journal database table.
 * 
 */
@Entity
@NamedQuery(name="Journal.findAll", query="SELECT j FROM Journal j")
public class Journal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Byte active;

	private String code;

	private String name;

	private String type;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="journal", fetch=FetchType.EAGER)
	private List<Invoice> invoices;

	//bi-directional many-to-one association to JournalEntry
	@OneToMany(mappedBy="journal", fetch=FetchType.EAGER)
	private List<JournalEntry> journalEntries;

	//bi-directional many-to-one association to JournalItem
	@OneToMany(mappedBy="journal", fetch=FetchType.EAGER)
	private List<JournalItem> journalItems;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="journal", fetch=FetchType.EAGER)
	private List<Payment> payments;

	public Journal() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Byte getActive() {
		return this.active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setJournal(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setJournal(null);

		return invoice;
	}

	public List<JournalEntry> getJournalEntries() {
		return this.journalEntries;
	}

	public void setJournalEntries(List<JournalEntry> journalEntries) {
		this.journalEntries = journalEntries;
	}

	public JournalEntry addJournalEntry(JournalEntry journalEntry) {
		getJournalEntries().add(journalEntry);
		journalEntry.setJournal(this);

		return journalEntry;
	}

	public JournalEntry removeJournalEntry(JournalEntry journalEntry) {
		getJournalEntries().remove(journalEntry);
		journalEntry.setJournal(null);

		return journalEntry;
	}

	public List<JournalItem> getJournalItems() {
		return this.journalItems;
	}

	public void setJournalItems(List<JournalItem> journalItems) {
		this.journalItems = journalItems;
	}

	public JournalItem addJournalItem(JournalItem journalItem) {
		getJournalItems().add(journalItem);
		journalItem.setJournal(this);

		return journalItem;
	}

	public JournalItem removeJournalItem(JournalItem journalItem) {
		getJournalItems().remove(journalItem);
		journalItem.setJournal(null);

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
		payment.setJournal(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setJournal(null);

		return payment;
	}

}