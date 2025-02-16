package com.tasktribe.service;

import java.util.List;

import com.tasktribe.exceptions.JobNotFoundException;
import com.tasktribe.entity.Job;

public interface JobService {

    public Job createJob(Job job);

    public List<Job> getJobs();

    public Job getJobById(Long Id) throws JobNotFoundException;

    public void deleteJobById(Long id);

    public Job updateJob(Long id,Job job);

    public Job getJobByTitle(String title);

}
