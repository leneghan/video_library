package com.playfish;

import java.util.ArrayList;
import java.util.List;


public class Library {
	
	private List<Dvd> dvds = new ArrayList<Dvd>();

	public boolean sendNewsLetter() {
		// TODO Auto-generated method stub
		return true;
	}

	public List<Dvd> listNewTitles() {
		dvds.add(new Dvd());
		return dvds;
	}
	
}
