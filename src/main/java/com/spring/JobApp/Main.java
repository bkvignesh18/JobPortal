package com.spring.JobApp;

import com.spring.JobApp.model.JobPost;
import com.spring.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {

    @Autowired
    private JobService jobService;

    @RequestMapping({"/", "home"})
    public String home() {
        return "home";
    }

    @RequestMapping("addjob")
    public String addjob() {
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost, Model model) {
         model.addAttribute("jobPost", jobPost);
        jobService.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewAllJobs(Model model) {
        model.addAttribute("jobPosts", jobService.showAllJobs());
        return "viewalljobs";
    }
}
