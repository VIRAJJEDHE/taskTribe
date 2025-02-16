package com.tasktribe.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasktribe.exceptions.JobNotFoundException;
import com.tasktribe.entity.Job;
import com.tasktribe.repository.JobRepository;

@Service
public class JobserviceImpl implements JobService{

    @Autowired
    private JobRepository jobRepository;
    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }
    @Override
    public List<Job> getJobs() {
        return jobRepository.findAll();
    }
    @Override
    public Job getJobById(Long Id) throws JobNotFoundException {
        Optional<Job> job=jobRepository.findById(Id);
        if(job.isPresent()) {
            return job.get();
        }
        else {
            throw new JobNotFoundException();
        }
    }
    @Override
    public Job getJobByTitle(String title) {
        return jobRepository.findByTitle(title).get();
    }
    @Override
    public void deleteJobById(Long id) {
        jobRepository.deleteById(id);
    }
    @Override
    public Job updateJob(Long id,Job job) {
        Job dbJob=jobRepository.findById(id).get();
        if(Objects.nonNull(job.getTitle())&&!" ".equals(job.getTitle())){
            dbJob.setTitle(job.getTitle());
        }
        if(Objects.nonNull(job.getDescription())&&!" ".equals(job.getDescription())){
            dbJob.setDescription(job.getDescription());
        }
        return jobRepository.save(dbJob);
    }
}
