package com.tasktribe.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "bid")
public class Bid {

    @Id
    @SequenceGenerator(
        name="bid_sequence",
        sequenceName = "bid_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy=GenerationType.SEQUENCE,
        generator = "bid_sequence"
    )
    private Long bidId;
    private Double bidAmount;
    private Integer bidStatus;
    @ManyToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER,
        optional=false
    )
    @JoinColumn(
        name="job_id",
        referencedColumnName="jobId"
    )
    private Job job;
    // @ManyToOne
    // @JoinColumn(
    //     name="bidder_id",
    //     referencedColumnName="userId"
    // )
    // private User bidder;

}
