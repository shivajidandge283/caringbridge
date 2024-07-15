package com.db.hackathon.dementia.dabbler.caringbridge.controller;

import com.db.hackathon.dementia.dabbler.caringbridge.entity.Activity;
import com.db.hackathon.dementia.dabbler.caringbridge.service.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/activities")
    public List<Activity> activities() {
        return activityService.findAll();
    }

    @PostMapping("/activities")
    public Activity saveActivity(@RequestBody Activity activity) {
        return activityService.saveActivity(activity);
    }

    @PutMapping("/activities")
    public Activity updateActivity(@RequestBody Activity activity) {
        log.info("Activity is {} ", activity);
        return activityService.updateActivity(activity);
    }

    @DeleteMapping("/activities/{id}")
    public void deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
    }
}
