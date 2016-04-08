package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

//Java Bean

public class Parola {
	
	private String parola;
	private List<Character> lettere;
	
	public Parola(String parola){
		this.parola = parola;
		lettere = new ArrayList<Character>();
		this.dividiParola();
	}
	
	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public List<Character> getLettere() {
		return lettere;
	}

	public void setLettere(List<Character> lettere) {
		this.lettere = lettere;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parola other = (Parola) obj;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}

	public void dividiParola(){
		//Divide la parola in una lista di lettere
		for(int i=0; i<parola.length(); i++){
			lettere.add(parola.charAt(i));
		}
	}
	
	public int size(){
		return parola.length();
	}

}
