package com.tasktribe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasktribe.entity.Bid;
import com.tasktribe.repository.BidRepository;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    BidRepository bidRepository;
    @Override
    public Bid createBid(Bid bid) {
        bidRepository.save(bid);
        return bid;
    }

}
