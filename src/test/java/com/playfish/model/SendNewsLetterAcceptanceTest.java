package com.playfish.model;

import java.util.Date;

import org.easymock.EasyMock;
import org.junit.Test;

import com.playfish.model.*;

public class SendNewsLetterAcceptanceTest {
    
    @Test
    public void testSendNewsLetter_WhenHasNewTitle_Send(){
        EmailClient emailClient = EasyMock.createMock(EmailClient.class);
        Member member = new Member("a@gmail.com");
        EasyMock.expect(emailClient.emailMember((String)EasyMock.anyObject(), (String)EasyMock.anyObject())).andReturn(true).atLeastOnce();
        EasyMock.replay(emailClient);
        
        Library library = new Library();
        Date oldNewsletterDate = new Date(1336127334);
        library.setLastNewsLetterDate(oldNewsletterDate);
        
        library.addMember(member);
        library.submitDvd("testTitle", "testYear", "testDirector");
        
        library.sendNewsLetter(emailClient);
        
        EasyMock.verify(emailClient);
    }
}
