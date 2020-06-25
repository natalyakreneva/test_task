package testtask.repository;
import java.util.List;

import testtask.Activity;


public interface ActivityService {
	Activity createActivity(Activity activity);

    Activity updateActivity(Activity activity);

    List < Activity > getAllActivity();

    Activity getActivityById(int id);

    void deleteActivity(int id);
}