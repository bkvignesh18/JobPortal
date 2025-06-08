package com.spring.JobApp.repository;

import com.spring.JobApp.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class JobPostRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addJob(JobPost jobPost) {
        String techStack = String.join(", ", jobPost.getPostTechStack());

        jdbcTemplate.update("INSERT INTO jobpost (id, description, experience, profile, tech_stack) VALUES (?, ?, ?, ?, ?)",
                jobPost.getPostId(),
                jobPost.getPostDesc(),
                jobPost.getReqExperience(),
                jobPost.getPostProfile(),
                techStack);
    }

    public List<JobPost> showAllJobs() {
        RowMapper<JobPost> jobPostMapper = (rs, rowNum) -> {
            JobPost jobPost = new JobPost();

            jobPost.setPostId(rs.getInt("id"));
            jobPost.setPostDesc(rs.getString("description"));
            jobPost.setReqExperience(rs.getString("experience"));
            jobPost.setPostProfile(rs.getString("profile"));

            String techStackStr = rs.getString("tech_stack");
            List<String> techStack = (techStackStr != null && !techStackStr.isEmpty())
                    ? Arrays.asList(techStackStr.split(", "))
                    : Collections.emptyList();

            jobPost.setPostTechStack(techStack);
            return jobPost;
        };

        return jdbcTemplate.query("SELECT * FROM jobpost", jobPostMapper);
    }
}
