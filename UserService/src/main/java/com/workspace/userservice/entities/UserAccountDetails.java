package com.workspace.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "user_management")
@Getter
@Setter
public class UserAccountDetails {
    private  String userName;
    private  String email;
    private String mobile;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;


    private int isAdmin;

    private int addressId;
}
