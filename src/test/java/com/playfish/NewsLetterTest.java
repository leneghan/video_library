package com.playfish;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class NewsLetterTest {
	@Test
	public void testContent(){		
		List<Dvd> dvds = new ArrayList<Dvd>();
		dvds.add(new Dvd("title", "year", "director"));
		Newsletter newsletter = new Newsletter(dvds , new ArrayList<Member>());
		Assert.assertTrue(newsletter.getContent().indexOf("title")>0);
	}
}
