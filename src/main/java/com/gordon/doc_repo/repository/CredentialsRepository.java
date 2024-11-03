package com.gordon.doc_repo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gordon.doc_repo.entity.CredentialsEntity;

@Repository
public interface CredentialsRepository extends JpaRepository<CredentialsEntity, Long> {
    Optional<CredentialsEntity> getCredentialByUserEntityId(Long userId);
}
