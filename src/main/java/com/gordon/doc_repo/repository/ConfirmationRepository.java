package com.gordon.doc_repo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gordon.doc_repo.entity.ConfirmationEntity;
import com.gordon.doc_repo.entity.UserEntity;

@Repository
public interface ConfirmationRepository extends JpaRepository<ConfirmationEntity, Long> {
   Optional< ConfirmationEntity> findByKey(String key);
   Optional< ConfirmationEntity> findByUserEntity(UserEntity entity);
}
