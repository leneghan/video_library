package com.playfish.model;

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


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((director == null) ? 0 : director.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
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
        Dvd other = (Dvd) obj;
        if (director == null) {
            if (other.director != null)
                return false;
        } else if (!director.equals(other.director))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (year == null) {
            if (other.year != null)
                return false;
        } else if (!year.equals(other.year))
            return false;
        return true;
    }
}
