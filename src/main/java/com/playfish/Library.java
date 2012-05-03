package com.playfish;

import java.util.ArrayList;
import java.util.List;


public class Library {

    private List<Dvd> dvds = new ArrayList<Dvd>();

    public void submitDvd(String title, String realeaseYear, String director) {
        Dvd dvd = new Dvd(title, realeaseYear, director);
        getDvds().add(dvd);
    }

	public boolean sendNewsLetter() {
		return true;
	}

	public List<Dvd> listNewTitles() {
		getDvds().add(new Dvd("", "", ""));
		return getDvds();
	}

    public List<Dvd> getDvds() {
        return dvds;
    }
}
