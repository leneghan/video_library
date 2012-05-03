package com.playfish;

import java.util.ArrayList;
import java.util.List;


public class Library {

    public void submitDvd() {


    }
	
	private List<Dvd> dvds = new ArrayList<Dvd>();

	public boolean sendNewsLetter() {
		return true;
	}

	public List<Dvd> listNewTitles() {
		dvds.add(new Dvd("","",""));
		return dvds;
	}
}
