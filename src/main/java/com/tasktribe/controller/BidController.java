package com.tasktribe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tasktribe.entity.Bid;
import com.tasktribe.service.BidService;

import jakarta.validation.Valid;

@RestController
public class BidController {

    @Autowired
    private BidService bidService;
    public Logger LOGGER=LoggerFactory.getLogger(BidController.class);

    @PostMapping("/create-bid")
    public Bid createBid(@Valid @RequestBody Bid bid) {
        LOGGER.info("Creating a new Bid");
        return bidService.createBid(bid);
    }
}
