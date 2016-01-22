package be.vdab.entities;

import java.util.ArrayList;
import java.util.List;

public class Saus {
	private long nummer;
	private String naam;
	private List<String> ingredienten = new ArrayList<>();		
	
	public Saus(long nummer, String naam, Iterable<String> ingredienten) {
		super();
		this.nummer = nummer;
		this.naam = naam;
		for (String ingredient:ingredienten){
			this.ingredienten.add(ingredient);
		}
	}
	
	public long getNummer() {
		return nummer;
	}
	
	public String getNaam() {
		return naam;
	}	

	public List<String> getIngredienten() {
		return ingredienten;
	}

	public void addIngredienten(String ingredient) {
		this.ingredienten.add(ingredient);
	}	

}
