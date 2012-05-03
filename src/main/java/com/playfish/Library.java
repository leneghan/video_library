package com.playfish;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Library {

	private Date lastNewsLetterDate;
	private List<Dvd> dvds = new ArrayList<Dvd>();

    public void submitDvd(String title, String realeaseYear, String director) {
        Dvd dvd = new Dvd(title, realeaseYear, director);
        getDvds().add(dvd);
    }

	public boolean sendNewsLetter() {
		lastNewsLetterDate = new Date();
		return true;
	}

    public List<Dvd> getDvds() {
        return dvds;
    }

	public List<Dvd> listNewTitles() {
		List<Dvd> newDvds = new ArrayList<Dvd>();
		for (Dvd dvd: dvds){
			if (dvd.isReleasedAfter(getLastNewsletterDate())){
				newDvds.add(dvd);
			}
		}
		return dvds;
	}
	
	protected void addDvd(Dvd dvd){
		dvd.setDateAdded(new Date());
		dvds.add(dvd);
	}

	public Date getLastNewsletterDate() {
		return lastNewsLetterDate;
	}
	public void setLastNewsLetterDate(Date lastNewsLetterDate){
		this.lastNewsLetterDate = lastNewsLetterDate;
	}
}
