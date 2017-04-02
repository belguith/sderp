package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inventory database table.
 * 
 */
@Entity
@NamedQuery(name="Inventory.findAll", query="SELECT i FROM Inventory i")
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Byte active;

	private Double incoming;

	@Column(name="max_qty")
	private Double maxQty;

	@Column(name="min_qty")
	private Double minQty;

	private Double quantity;

	private Double reserved;

	@Column(name="total_cost")
	private Double totalCost;

	@Column(name="unit_cost")
	private Double unitCost;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	public Inventory() {
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

	public Double getIncoming() {
		return this.incoming;
	}

	public void setIncoming(Double incoming) {
		this.incoming = incoming;
	}

	public Double getMaxQty() {
		return this.maxQty;
	}

	public void setMaxQty(Double maxQty) {
		this.maxQty = maxQty;
	}

	public Double getMinQty() {
		return this.minQty;
	}

	public void setMinQty(Double minQty) {
		this.minQty = minQty;
	}

	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getReserved() {
		return this.reserved;
	}

	public void setReserved(Double reserved) {
		this.reserved = reserved;
	}

	public Double getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Double getUnitCost() {
		return this.unitCost;
	}

	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}