package com.playfish;

import java.util.List;

import com.google.gson.Gson;

public class Newsletter {
	private final List<Dvd> dvds;
	private final List<Member> members;
	
	public Newsletter(List<Dvd> dvds, List<Member> members){
		this.dvds = dvds;
		this.members = members;
	}
	
	public String getContent(){
		Gson gson = new Gson();
		return gson.toJson(dvds);
	}
}
