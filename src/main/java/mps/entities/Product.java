package mps.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Representation of a user that is allowed to log into the system.
 *
 */
@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = false)
	private String type;
	
	@Column(nullable = false, unique = false)
	private String data;
	
	@Column(nullable = false)
	private boolean enabled = true;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public String getTyp() {
		return type;
	}

	public void setStreet(String type) {
		this.type = type;
	}
	
	public String getDate() {
		return data;
	}

	public void setDate(String date) {
		this.data = data;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	@Override
	public String toString() {
		return "Produkt [id=" + id + ", Typ=" + type + ", Daten="
			    + data + ", enabled=" + enabled + "]";
	}
	
	
	//must not be used in collections before persisting
	@Override
	public int hashCode() {
		return id==null?0: (int)(id&0xffffffff);
	}
	
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof Product)) return false;
		return ((Product)other).id == id;
	}
}
