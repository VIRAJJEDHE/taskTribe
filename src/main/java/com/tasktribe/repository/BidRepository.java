package com.tasktribe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasktribe.entity.Bid;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {

}
