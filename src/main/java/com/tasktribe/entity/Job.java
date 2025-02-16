package com.tasktribe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Title is mandatory")
    private String title;
    private String description;
    
}
