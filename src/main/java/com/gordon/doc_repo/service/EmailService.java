package com.gordon.doc_repo.service;


public interface EmailService {
    void sendNewAccountEmail(String name, String to, String token);
	void sendPasswordResetMail(String name, String to, String token);

}
