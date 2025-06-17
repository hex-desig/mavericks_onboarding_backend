package com.mavericks.onboarding.entity;

	import jakarta.persistence.*;
	import java.sql.Timestamp;

	@Entity
	@Table(name = "users")
	public class Register {

	    @Id
	    @Column(name = "user_id")
	    private String userId;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "email")
	    private String email;

	    @Column(name = "password")
	    private String password;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "role")
	    private Role role;

	    @Column(name = "created_at")
	    private Timestamp createdAt;

	    @Column(name = "updated_at")
	    private Timestamp updatedAt;

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

		public Timestamp getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Timestamp createdAt) {
			this.createdAt = createdAt;
		}

		public Timestamp getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Timestamp updatedAt) {
			this.updatedAt = updatedAt;
		}

		public Register(String userId, String name, String email, String password, Role role, Timestamp createdAt,
				Timestamp updatedAt) {
			super();
			this.userId = userId;
			this.name = name;
			this.email = email;
			this.password = password;
			this.role = role;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
		}

		public Register() {
			super();
			// TODO Auto-generated constructor stub
		}

	    
	}

	enum Role {
	    FRESHER,
	    ADMIN
	}



