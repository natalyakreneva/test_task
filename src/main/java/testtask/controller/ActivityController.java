package testtask.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import testtask.Activity;
import testtask.repository.ActivityService;


@RestController
public class ActivityController {
	 
	@Autowired
	private ActivityService activityService;
	
	@GetMapping("/activities")
	public ResponseEntity<List< Activity >> getAllActivity(){
		return ResponseEntity.ok().body(activityService.getAllActivity());
	}
	
	@GetMapping("/activities/{id}")
	public ResponseEntity< Activity> getActivitytById(@PathVariable int id){
		return ResponseEntity.ok().body(activityService.getActivityById(id));
	}
	
	@PostMapping("/activities")
	public ResponseEntity<Activity> createProduct(@RequestBody Activity activity){
		return ResponseEntity.ok().body(this.activityService.createActivity(activity));
	}
	
	@PutMapping("/activities/{id}")
	public ResponseEntity<Activity> updateActivity(@PathVariable int id, @RequestBody Activity activity){
		activity.setId(id);
		return ResponseEntity.ok().body(this.activityService.updateActivity(activity));
	}

	@DeleteMapping("/products/{id}")
	public HttpStatus deleteProduct(@PathVariable int id){
		this.activityService.deleteActivity(id);
		return HttpStatus.OK;
	}
}


}
