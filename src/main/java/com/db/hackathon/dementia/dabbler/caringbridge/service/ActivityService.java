package com.db.hackathon.dementia.dabbler.caringbridge.service;

import com.db.hackathon.dementia.dabbler.caringbridge.entity.Activity;
import com.db.hackathon.dementia.dabbler.caringbridge.repository.IActivityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class ActivityService {

    private final IActivityRepository activityRepository;

    @Autowired
    public ActivityService(IActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    public Activity saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity updateActivity(Activity activity) {
        if(null != activity.getId()) {
            return activityRepository.save(activity);
        }
        return null;
    }

    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }
}
