package testtask.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import testtask.Activity;
import testtask.exception.ResourceNotFoundException;
import testtask.repository.ActivityRepository;
import testtask.repository.ActivityService;



@SpringBootApplication
@Service
@Transactional
public class ActivityServiceImplementation implements ActivityService {

	@Autowired
    private ActivityRepository activityRepository;
	
	@Override
	public Activity createActivity(Activity activity) {
		return activityRepository.save(activity);
	}
	
	@Override
	public Activity updateActivity(Activity activity) {
		Optional < Activity > activityDB = this.activityRepository.findById(activity.getId());

        if (activityDB.isPresent()) {
            Activity activityUpdate = activityDB.get();
            activityUpdate.setId(activity.getId());
            activityUpdate.setTitle(activity.getTitle());
            activityUpdate.setSummary(activity.getSummary());
            activityUpdate.setDescription(activity.getDescription());
            activityUpdate.setStartDate(activity.getStartDate());
            activityUpdate.setEndDate(activity.getEndDate());
            activityUpdate.setInfo(activity.getInfo());
            activityRepository.save(activityUpdate);
            return activityUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + activity.getId());
        }
		
	}

	@Override
	public List<Activity> getAllActivity() {
		 return this.activityRepository.findAll();
	}

	@Override
	public Activity getActivityById(int activityId) {
	
		Optional < Activity > activityDB = this.activityRepository.findById(activityId);

        if (activityDB.isPresent()) {
            return activityDB.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + activityId);
        }
	}

	@Override
	public void deleteActivity(int activityId) {
		Optional < Activity > activityDB = this.activityRepository.findById(activityId);

		 if (activityDB.isPresent())  {
	            this.activityRepository.delete(activityDB.get());
	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + activityId);
	        }
	}

}