package testtask.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import testtask.Activity;


public interface ActivityRepository extends MongoRepository<Activity, Integer> {
	
}


