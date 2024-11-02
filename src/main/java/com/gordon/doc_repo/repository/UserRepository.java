package com.gordon.doc_repo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gordon.doc_repo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByEmailIgnoreCase(String email);
	Optional<UserEntity> findByUserId(Long userId);

}
