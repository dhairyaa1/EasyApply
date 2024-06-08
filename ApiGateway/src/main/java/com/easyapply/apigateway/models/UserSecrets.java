package com.easyapply.apigateway.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


@Getter
@Setter
public class UserSecrets {

	private String username;

	private String password;

}
