package com.playfish;

import java.util.ArrayList;
import java.util.Date;
import com.google.common.base.Optional;

public class Dvd {

    private String title;
	private String year;
	private String director;
	private Date dateAdded;
    private final ArrayList<Copy> copies = new ArrayList<Copy>();

    public Dvd(String title, String year, String director) {

        this.title = title;
        this.year = year;
        this.director = director;

        Copy copy = new Copy();
        copy.copyOf = this;
        copies.add(copy);
    }


	public boolean isReleasedAfter(Date lastNewsletterDate) {
		return dateAdded.after(lastNewsletterDate);
	}

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

    public boolean isAvailable() {
        return copies.get(copies.size() - 1).isAvailable();
    }

	public Copy borrow(Member member) {
        Optional<Copy> toBorrow = findAvailableCopy();

        if(toBorrow.isPresent()){
            toBorrow.get().borrow(member);
            return toBorrow.get();
        }
        throw new NoCopiesException("No Available copy found");
	}


    private Optional<Copy> findAvailableCopy() {
        for (final Copy candidateToBeAvailable : this.copies) {
            if (candidateToBeAvailable.isAvailable()) {
                return Optional.of(candidateToBeAvailable);
            }
        }
        return Optional.absent();
    }

    public Optional<Copy> findCopy(final Member member) {
        
        for (final Copy candidateToBeAvailable : this.copies) {
            if (candidateToBeAvailable.onLoanTo(member)) {
                return Optional.of(candidateToBeAvailable);
            }
        }
        return Optional.absent();
    }

    public void returnDvd(Member member) {
        Optional<Copy> copyOnLoan = findCopy(member);
        if(copyOnLoan.isPresent()){
            copyOnLoan.get().returnCopy();
        }
    }
    
    @Override
    public String toString() {
        return "Dvd [title=" + title + ", year=" + year + ", director="
                + director + "]";
    }
}
