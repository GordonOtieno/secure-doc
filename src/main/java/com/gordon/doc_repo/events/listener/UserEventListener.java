package com.gordon.doc_repo.events.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.gordon.doc_repo.events.UserEvent;
import com.gordon.doc_repo.service.EmailService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserEventListener {
	private final EmailService emailservice;

	@EventListener
	public void onUserEvent(UserEvent event) {
		switch (event.getType()) {
		case REGISTRATION -> emailservice.sendNewAccountEmail(event.getUser().getFirstName(),
				event.getUser().getEmail(), (String) event.getData().get("key"));
		case RESETPASSWORD -> emailservice.sendNewAccountEmail(event.getUser().getFirstName(),
				event.getUser().getEmail(), (String) event.getData().get("key"));
		default -> {
		}
		}
	}

}
