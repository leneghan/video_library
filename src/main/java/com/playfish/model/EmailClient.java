package com.playfish.model;

public interface EmailClient {
	boolean emailMember(String email, String content);
}
