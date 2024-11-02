package com.gordon.doc_repo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gordon.doc_repo.entity.RoleEntity;

public interface RoleReository extends JpaRepository<RoleEntity, Long> {
	Optional<RoleEntity> findByNameIgnoreCase(String name);
}
