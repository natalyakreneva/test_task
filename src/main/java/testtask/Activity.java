package testtask;
import org.springframework.data.annotation.Id;
import java.util.Date;
import java.util.Objects;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.lang.NonNull;
import org.springframework.data.*;

@Document(collection = "activityDB")
public class Activity {
	//id
	//title mandatory max 100 
	//summary mandatory max 25
	//description mandatory max 200
	// start date time  mandatory ISO Date Time 
	// end date time mandatory ISO Date Time
	// info
	@Id public int id;
	
	@Indexed(unique = true)
	@Field(value = "TITTLE")
	@NonNull
	private String title;
	
	@Field(value = "SUMMARY")
	@NonNull
	private String summary;
	
	@Field(value = "DESCRIPTION")
	@NonNull
	private String description;
	
	@Field(value = "INFO")
	private String info;
	
	 @Field(value = "Start_Date")
	 @NonNull
	 private Date startDate;
	 
	 @Field(value = "End_Date")
	 @NonNull
	 private Date endDate;
	 
	 public Activity() {
	}
	 public Activity(int id, String title, String summary, String description, Date startDate, Date endDate, String info ) {
		 this.id=id;
		 this.title=title;
		 this.summary=summary;
		 this.description=description;
		 this.startDate=startDate;
		 this.endDate=endDate;
		 this.info=info;
	 };
	 
	 public int getId() {
	        return id;
	    }
	 public void setId(int id) {
	        this.id = id;
	    }
		
	public void setTitle (String title) {
		this.title=title;
	}
	
	public String getTitle () {
		return title;
	}
	
	public String getSummary () {
		return summary;
	}
	
	public void setSummary (String summary) {
		this.summary=summary;
	}
	
	
	
	public void setDescription (String description) {
		this.description=description;
	}
	
	public String getDescription () {
		return description;
	}
	
	public String getInfo () {
		return description;
	}
	
	public void setInfo (String info) {
		this.info=info;
	}
	
	public Date getStartDate() {
        return startDate;
    }
 
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }
 
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    @Override
    public String toString() {
        return "id:" + this.id
        	   +" title " + this.title
        	   +" summary " + this.summary
        	   +" description " +this.description
        	   +" start date " +this.startDate
        	   +" end date " + this.endDate
        	   +" info "+ this.info;
        	    }

    @Override
    public boolean equals(Object o) {

      if (this == o)
        return true;
      if (!(o instanceof Activity))
        return false;
      Activity activity = (Activity) o;
      return Objects.equals(this.id, activity.id) && Objects.equals(this.title,activity.title)
    		 && Objects.equals(this.summary,activity.summary)
    		 && Objects.equals(this.description, activity.description)
      		 && Objects.equals(this.startDate,activity.startDate)
      		 && Objects.equals(this.endDate,activity.endDate)
      		 && Objects.equals(this.info,activity.info);
    }

  }
