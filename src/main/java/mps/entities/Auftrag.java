package mps.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Representation of a user that is allowed to log into the system.
 *
 */
@Entity
public class Auftrag {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = false)
	private Long invoiceNumber;
	
	@Column(nullable = false)
	private boolean enabled = true;


	// Getters and Setters
	public Long getId() {
		return id;
	}

	public Long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
//	@Override
//	public String toString() {
//		return "Auftrag [id=" + id + ", Rechnungsnummer=" + invoiceNumber + ", Bestelldatum="
//				+ orderDate.toString() + ", Kundennummer" + customerID + ", Produkte"+ products + 
//				", enabled=" + enabled + "]";
//	}
	
	//must not be used in collections before persisting
	@Override
	public int hashCode() {
		return id==null?0: (int)(id&0xffffffff);
	}
	
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof Auftrag)) return false;
		return ((Auftrag)other).id == id;
	}
}
