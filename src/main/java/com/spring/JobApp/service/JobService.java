package com.spring.JobApp.service;

import com.spring.JobApp.model.JobPost;
import com.spring.JobApp.repository.JobPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobPostRepo repo;

    public void addJob(JobPost jobPost) {
        repo.addJob(jobPost);
    }

    public List<JobPost> showAllJobs() {
        return repo.showAllJobs();
    }
}
