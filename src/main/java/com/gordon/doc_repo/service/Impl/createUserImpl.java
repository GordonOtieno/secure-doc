package com.gordon.doc_repo.service.Impl;

import java.util.Map;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.gordon.doc_repo.entity.ConfirmationEntity;
import com.gordon.doc_repo.entity.CredentialsEntity;
import com.gordon.doc_repo.entity.RoleEntity;
import com.gordon.doc_repo.entity.UserEntity;
import com.gordon.doc_repo.enumeration.Authority;
import com.gordon.doc_repo.enumeration.EventType;
import com.gordon.doc_repo.events.UserEvent;
import com.gordon.doc_repo.exception.ApiException;
import com.gordon.doc_repo.repository.ConfirmationRepository;
import com.gordon.doc_repo.repository.CredentialsRepository;
import com.gordon.doc_repo.repository.RoleReository;
import com.gordon.doc_repo.repository.UserRepository;
import com.gordon.doc_repo.service.UserService;
import com.gordon.doc_repo.utils.UserUtils;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackOn = Exception.class)
@AllArgsConstructor
@Slf4j
public class createUserImpl implements UserService {
	private final UserRepository userRepository;
	private final RoleReository roleReository;
	private final CredentialsRepository credentialsRepository;
	private final ConfirmationRepository confirmationRepository;
	private final ApplicationEventPublisher publisher;
	//private final BCryptPaswordEncoder encoder;
	
	@Override
	public void createUser(String firstName, String lastName, String email, String password) {
		var userEntity = userRepository.save(creteNewUser(firstName,lastName,email));
	    var credentialsEntity= new CredentialsEntity(userEntity, password);
	    credentialsRepository.save(credentialsEntity);
	    var confirmationEntity = new ConfirmationEntity(userEntity);
	    confirmationRepository.save(confirmationEntity);
	    publisher.publishEvent(new UserEvent(userEntity,EventType.REGISTRATION, Map.of("key",confirmationEntity.getKey())));
	    
	}
	
	@Override
	public RoleEntity getRoleName(String name) {
		var role = roleReository.findByNameIgnoreCase(name);
		return role.orElseThrow(() -> new ApiException("RoleNot Found"));
	}


	private UserEntity creteNewUser(String firstName, String lastName, String email) {
		var role = getRoleName(Authority.USER.name());
		return  UserUtils.createUserEntity(firstName, lastName, email,role);
	}
}
