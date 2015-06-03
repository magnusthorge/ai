package mps.komponenten.supplier.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Supplier {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = false)
	private String name;
	
	@Column(nullable = false, unique = false)
	private String adress;
	
	@Column(nullable = false)
	private boolean enabled = true;


	// Getters and Setters
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return name;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "Lieferant [id=" + id + ", Name=" + name + ", Adresse="
				+ adress + ", " +
				", enabled=" + enabled + "]";
	}
	
	//must not be used in collections before persisting
	@Override
	public int hashCode() {
		return id==null?0: (int)(id&0xffffffff);
	}
	
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof Supplier)) return false;
		return ((Supplier)other).id == id;
	}
}
