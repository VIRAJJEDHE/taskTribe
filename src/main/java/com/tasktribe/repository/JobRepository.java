package com.tasktribe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasktribe.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    Optional<Job> findByTitle(String title);

}
