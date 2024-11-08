package com.gordon.doc_repo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.AlternativeJdkIdGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gordon.doc_repo.domain.RequestContext;
import com.gordon.doc_repo.exception.ApiException;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"createdAt","updatedAt"}, allowGetters = true)
public abstract class Auditable {
	@Id
	@SequenceGenerator(name = "primary_key_seq", sequenceName = "primary_key_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_key_seq")
	@Column(name="id", updatable = false)
	private Long Id;
	private String referenceId = new AlternativeJdkIdGenerator().generateId().toString();
	@NotNull
	private Long createdBy;
	@NotNull
    private Long updatedBy;
	@NotNull
	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	@CreatedDate
	@Column(name = "updated_at", nullable = false, updatable = true)
	private LocalDateTime updatedAt;
	
	@PrePersist
	public void beforePersist() {
		Long  userId = 0L; //RequestContext.getUserId();
		//if(userId == null) { throw new ApiException("Cannot persist an entity without a valid user ID");}
		setCreatedAt(LocalDateTime.now());
		setCreatedBy(userId);
		setUpdatedBy(userId);
		setUpdatedAt(LocalDateTime.now());
	}
	
	@PreUpdate
	public void beforeUpdate() {
		Long  userId = 0L; //RequestContext.getUserId();
		//if(userId == null) { throw new ApiException("Cannot persist an entity without a valid user ID");}
		setUpdatedAt(LocalDateTime.now());
		setUpdatedBy(userId);
	}
}

//https://youtu.be/a49JO1WjJSs?t=5770


