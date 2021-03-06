package com.playfish.model;

import java.util.*;

public class Library {

    private Date lastNewsLetterDate;
    private List<Dvd> dvds = new ArrayList<Dvd>();
    private List<Member> members = new ArrayList<Member>();
    private EmailClient emailClient;

    public Library(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    public void submitDvd(String title, String realeaseYear, String director) {
        Dvd dvd = new Dvd(title, realeaseYear, director);
        dvd.setDateAdded(new Date());
        getDvds().add(dvd);
    }

    public Newsletter sendNewsLetter() {
        List<Dvd> newDvds = listNewTitles();

        Newsletter newsletter = new Newsletter(newDvds, members);
        lastNewsLetterDate = new Date();

        for (Member member : members) {
            emailClient.emailMember(member.getEmail(), newsletter.getContent());
        }
        return newsletter;
    }

    public List<Dvd> getDvds() {
        return dvds;
    }

    public List<Dvd> listNewTitles() {
        List<Dvd> newDvds = new ArrayList<Dvd>();
        for (Dvd dvd : dvds) {
            if (dvd.isReleasedAfter(getLastNewsletterDate())) {
                newDvds.add(dvd);
            }
        }
        return dvds;
    }

    public Date getLastNewsletterDate() {
        return lastNewsLetterDate;
    }

    public void setLastNewsLetterDate(Date lastNewsLetterDate) {
        this.lastNewsLetterDate = lastNewsLetterDate;
    }

    public void addMember(Member newMember) {
        members.add(newMember);
    }
}
