package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
	
	String parola;
	
	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public List<String> getListaParole() {
		return listaParole;
	}

	public void setListaParole(List<String> listaParole) {
		this.listaParole = listaParole;
	}

	List<String> listaParole;
		
	public Parole() {
		//TODO
		this.listaParole = new ArrayList<>();
	}
	
	public void addParola(String p) {
	
		if((p.matches(".*[a-zA-Z].*")) && (!p.matches(".*[0-9].*"))) {
			listaParole.add(p);
		}
		//TODO
		
	}
	
	@Override
	public String toString() {
		String res = "";
		for(String s : this.listaParole) {
			res += s + "\n";
		}
		return res;
	}

	public List<String> getElenco() {
		//TODO
		Collections.sort(listaParole);
		return listaParole;
	}
	
	public void reset() {
		listaParole.removeAll(listaParole);
		// TODO
	}
	
	public void cancellaParola(String p) {
		
		if (listaParole.contains(p))
			listaParole.remove(p);
		}
		
	}


