package com.workspace.userservice.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;


@Getter
@Setter
@Entity
public class UserAccountDetails {
    private  String userName;
    private  String email;
    private String mobile;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    private int isAdmin;

    private int addressId;
}
