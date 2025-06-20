package com.spring.JobApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPost {
    private int postId;
    private String postProfile;
    private String postDesc;
    private String reqExperience;
    private List<String> postTechStack;
}
