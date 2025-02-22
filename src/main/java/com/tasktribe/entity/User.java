package com.tasktribe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
    name="User_",
    uniqueConstraints = @UniqueConstraint(
        name = "email_unique",
        columnNames = "email"
    )
)
public class User {
    @Id
    @SequenceGenerator(
        name="user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy=GenerationType.SEQUENCE,
        generator = "user_sequence"
    )
    private Long userId;

    private String name;
    @Column(
        nullable=false
    )
    private String email;
    private String password;
}       
