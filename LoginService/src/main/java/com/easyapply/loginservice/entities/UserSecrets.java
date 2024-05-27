package com.easyapply.loginservice.entities;


import com.easyapply.loginservice.models.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(schema = "user_management")
public class UserSecrets {


	@Column(unique = true)
	private String username;

	private String password;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userid;

	private UserRole userRole;

}
