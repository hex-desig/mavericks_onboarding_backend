package com.mavericks.onboarding.dto;

import com.mavericks.onboarding.enums.Role;

public class LoginResponse {
	
			private String jwt;
		    private Role role;
		    private String userId;
			public String getJwt() {
				return jwt;
			}
			public void setJwt(String jwt) {
				this.jwt = jwt;
			}
			public Role getRole() {
				return role;
			}
			public void setRole(Role role) {
				this.role = role;
			}
			public String getUserId() {
				return userId;
			}
			public void setUserId(String string) {
				this.userId = string;
			}
			@Override
			public String toString() {
				return "AuthenticationResponse [jwt=" + jwt + ", userRole=" + role + ", userId=" + userId + "]";
			}
		}



