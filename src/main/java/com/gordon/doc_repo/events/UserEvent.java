package com.gordon.doc_repo.events;

import java.util.Map;

import com.gordon.doc_repo.entity.UserEntity;
import com.gordon.doc_repo.enumeration.EventType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

public class UserEvent {
	private UserEntity user;
	private EventType type;
	private Map<?,?> data;
}
