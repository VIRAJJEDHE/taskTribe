package com.tasktribe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tasktribe.entity.Review;
import com.tasktribe.service.ReviewService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;
    public Logger LOGGER=LoggerFactory.getLogger(ReviewController.class);

    @PostMapping("/create-review")
    public Review postMethodName(@RequestBody Review review) {
        LOGGER.info("Creating a new Review");
        return reviewService.createReview(review);
    }
    
}
