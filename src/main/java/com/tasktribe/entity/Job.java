package com.tasktribe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
    @SequenceGenerator(
        name = "job_seq", 
        sequenceName = "job_seq", 
        allocationSize = 1)
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "job_seq")
    private Long jobId;
    @NotBlank(message = "Title is mandatory")
    private String title;
    private String description;
    
}
