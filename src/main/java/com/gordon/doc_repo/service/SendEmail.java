package com.gordon.doc_repo.service;


public interface SendEmail {
	public void sendNewAccountEmail(String name, String to, String token);
	void sendPasswordResetMail(String name, String to, String token);

}
