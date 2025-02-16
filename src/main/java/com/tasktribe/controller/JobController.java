package com.tasktribe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tasktribe.exceptions.JobNotFoundException;
import com.tasktribe.entity.Job;
import com.tasktribe.service.JobService;

import jakarta.validation.Valid;



@RestController
public class JobController {

    @Autowired
    private JobService jobService;
    public Logger LOGGER=LoggerFactory.getLogger(JobController.class);

    @PostMapping("/create-job")
    public Job createJob(@Valid @RequestBody Job job) {
        LOGGER.info("Creating a new Job");
        return jobService.createJob(job);
    }

    @GetMapping("/jobs")
    public List<Job> getJobs() {
        return jobService.getJobs();
    }

    @GetMapping("/jobs/{Id}")
    public Job getJobById(@PathVariable Long Id) throws JobNotFoundException {
        return jobService.getJobById(Id);
    }
    @GetMapping("/jobs/title/{title}")
    public Job getJobById(@PathVariable String title) {
        return jobService.getJobByTitle(title);
    }
    @DeleteMapping("/jobs/{Id}")
    public String deleteJobById(@PathVariable Long Id) {
         jobService.deleteJobById(Id);
         return "Job: "+ Id +" Deleted Successfully";
    }
    @PutMapping("/jobs/{Id}")
    public Job updateJob(@PathVariable Long Id,@RequestBody Job job) throws JobNotFoundException {
         jobService.updateJob(Id,job);
         return jobService.getJobById(Id);
    }
    
}
