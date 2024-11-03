package com.gordon.doc_repo.utils;

import java.time.LocalDateTime;
import java.util.UUID;

import com.gordon.doc_repo.entity.RoleEntity;
import com.gordon.doc_repo.entity.UserEntity;

public class UserUtils {
	

	private static final String EMPTY = "";

	public static UserEntity createUserEntity(String firstName, String lastName, String email, RoleEntity role) {
		return UserEntity.builder()
				.userId(UUID.randomUUID().toString())
				.firstName(firstName)
				.lastName(lastName)
				.email(email)
				.lastlogin(LocalDateTime.now())
				.accountNonExpiry(true)
				.accountNonLocked(true)
				.enable(false)
				.qrCodeSecret(EMPTY)
				.phone(EMPTY)
				.bio(EMPTY)
				.imageUrl("https://iconscout.com/free-icon/profile-199")
				.role(role)
				.build();
	}

}
