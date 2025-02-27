package com.tasktribe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasktribe.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
