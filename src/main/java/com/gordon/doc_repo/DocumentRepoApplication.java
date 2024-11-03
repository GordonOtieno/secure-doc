package com.gordon.doc_repo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

import com.gordon.doc_repo.domain.RequestContext;
import com.gordon.doc_repo.entity.RoleEntity;
import com.gordon.doc_repo.enumeration.Authority;
import com.gordon.doc_repo.repository.RoleReository;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class DocumentRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentRepoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner CommandLineRunner (RoleReository roleReository) {
		return args-> {
			RequestContext.setUserId(0L);
			var userRole = new RoleEntity();
			userRole.setName(Authority.USER.name());
			userRole.setAuthorities(Authority.USER);
			roleReository.save(userRole);
			
			var adminRole = new RoleEntity();
			adminRole.setName(Authority.ADMIN.name());
			adminRole.setAuthorities(Authority.ADMIN);
			roleReository.save(adminRole);
			RequestContext.start();
		};
	}
}

//https://youtu.be/a49JO1WjJSs?t=15658
//https://youtu.be/Awuk7HJJRQ0?list=PLWPirh4EWFpENnR0p1JvhJkyTK1M0sOLR