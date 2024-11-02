package com.gordon.doc_repo.enumeration;
import static com.gordon.doc_repo.constant.Constants.*;
public enum Authority {
	USER(USER_AUTHORITIES),
	ADMIN(ADMIN_AUTHORITIES),
	SUPERADMIN(SUPER_ADMIN_AUTHORITIES),
	MANAGER(MANAGER_AUTHORITIES);
	
	private final String value;
	
	Authority(String value){
		this.value=value;
	}
	
	public String getValue() {
		return this.value;
	}
	
 
}
