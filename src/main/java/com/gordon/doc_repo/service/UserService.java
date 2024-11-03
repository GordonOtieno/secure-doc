package com.gordon.doc_repo.service;

import com.gordon.doc_repo.entity.RoleEntity;
import com.gordon.doc_repo.enumeration.Authority;

public interface UserService {
   void createUser(String firstName, String lastName, String email, String password);
   RoleEntity getRoleName(String name);
}
