package com.gordon.doc_repo.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(content = Include.NON_DEFAULT)
@Table(name = "users")
public class UserEntity extends Auditable {
	@Column(updatable = false, unique = true, nullable = false)
	private String userId;
	private String firstName;
	private String lastName;
	@Column(unique = true, nullable = false)
	private String email;
	private Integer loginAttemps;
	private LocalDateTime lastlogin;
	private String phone;
	private String bio;
	private String imageUrl;
	private boolean accountNonExpiry;
	private boolean accountNonLocked;
	private boolean enable;
	private boolean nfa;
	@JsonIgnore
	private String qrCodeSecret;
	@Column(columnDefinition = "text")
	private String qrCodeImageUrl;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private RoleEntity role;

}
