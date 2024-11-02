package com.gordon.doc_repo.events.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.gordon.doc_repo.events.UserEvent;
import com.gordon.doc_repo.service.serviceImpl.EmailServiceImpl;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserEventListener {
	private final EmailServiceImpl emailservice;
	
	@EventListener
	public void onUserEvent(UserEvent userEvent) {
		switch (userEvent.getType()){
		case REGISTRATION -> emailservice.sendNewAccountEmail(userEvent.getUser().getFirstName(), userEvent.getUser().getEmail(), (String)userEvent.getData().get("key"));
		case RESETPASSWORD -> emailservice.sendNewAccountEmail(userEvent.getUser().getFirstName(), userEvent.getUser().getEmail(), (String)userEvent.getData().get("key"));
		default -> {}
		}	
	}

}

