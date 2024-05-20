package com.easyapply.userservice.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(schema = "user_management")
public class UserSecrets {

	private String userName;

	private String passWord;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;

}
