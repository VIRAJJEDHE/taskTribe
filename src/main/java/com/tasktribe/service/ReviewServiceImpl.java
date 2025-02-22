package com.tasktribe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasktribe.entity.Review;
import com.tasktribe.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    public Review createReview(Review review) {
        reviewRepository.save(review);
        return review;
    }

}
