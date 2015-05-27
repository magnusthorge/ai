package mps.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Representation of a user that is allowed to log into the system.
 *
 */
@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = true, unique = false)
	private String name;
	
	@Column(nullable = false, unique = false)
	private String lastname;

	@Column(nullable = true, unique = false)
	private String konto;

	@Column(nullable = true, unique = false)
	private String adress;
	
	@Column(nullable = true, unique = false)
	private String digitalContact;

	@Column(nullable = true)
	private boolean enabled = true;


	// Getters and Setters
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String customername) {
		this.name = customername;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String customerLastname) {
		this.lastname = customerLastname;
	}


	public String getKonto() {
		return konto;
	}

	public String getAdress() {
		return adress;
	}
	public void setAdress(String newAdress) {
		this.adress = newAdress;
	}
	public String getDigitalContact() {
		return digitalContact;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	@Override
	public String toString() {
		return "Kunde [id=" + id + ", Vorname=" + name + ", Nachname="
				+ lastname + ", enabled=" + enabled
			 + "]";
	}
	
	
	//must not be used in collections before persisting
	@Override
	public int hashCode() {
		return id==null?0: (int)(id&0xffffffff);
	}
	
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof Customer)) return false;
		return ((Customer)other).id == id;
	}
}
