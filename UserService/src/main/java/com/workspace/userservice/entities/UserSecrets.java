package com.workspace.userservice.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class UserSecrets {

	private String userName;

	private String passWord;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;

}
