package be.vdab.entities;

import java.io.Serializable;

public class Gemeente  implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	private String naam;
	private int postCode;
	
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
}
