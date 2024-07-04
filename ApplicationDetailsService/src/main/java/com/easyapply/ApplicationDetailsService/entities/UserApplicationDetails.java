package com.easyapply.ApplicationDetailsService.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
@Setter
@Table(schema = "application_details")
public class UserApplicationDetails {
    @NotNull
    private String userId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long UserApplicationId;
    @NotNull
    private long applicationId;
}
