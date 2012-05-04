package com.playfish;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Library {

	private Date lastNewsLetterDate;
	private List<Dvd> dvds = new ArrayList<Dvd>();
	private List<Member> members = new ArrayList<Member>();
	
    public void submitDvd(String title, String realeaseYear, String director) {
        Dvd dvd = new Dvd(title, realeaseYear, director);
        dvd.setDateAdded(new Date());
        getDvds().add(dvd);
    }
	
	public boolean sendNewsLetter(EmailClient emailClient) {
		List<Dvd> newDvds = listNewTitles();
		
		Newsletter newsletter = new Newsletter(newDvds, members);
		lastNewsLetterDate = new Date();
		return emailClient.emailMember(newsletter.getContent());
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
	
	public Date getLastNewsletterDate() {
		return lastNewsLetterDate;
	}
	public void setLastNewsLetterDate(Date lastNewsLetterDate){
		this.lastNewsLetterDate = lastNewsLetterDate;
	}
}
