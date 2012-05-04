package com.playfish.model;

import java.util.List;

public class Newsletter {
	private final List<Dvd> dvds;
	private final List<Member> members;
	
	public Newsletter(List<Dvd> dvds, List<Member> members){
		this.dvds = dvds;
		this.members = members;
	}
	
	public String getContent(){
	    StringBuilder sb = new StringBuilder();
	    for (Dvd dvd : dvds) {
	        String dvdEntry = dvd.toString();
	        sb.append(dvdEntry);
	    }
		return sb.toString();
	}
}
