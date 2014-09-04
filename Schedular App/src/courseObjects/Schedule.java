package schedularApp;

/**
 * This class create Schedule object, 
 * calculate total break in minutes per schedule, 
 * and total days per schedule.     
 * 
 * Created by Dmitri Konradi and Brandon Bell
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Schedule {
	
	// added by Brandon Bell ----------------------------------------
	List<Course> Courses = new ArrayList<Course>();
	// end added by Brandon Bell ------------------------------------
	
	// initial data fields
	private int totalDays; // total number of days per schedule
	private int totalBreakInMinutes = 0; // total break in minutes per schedule
	private int professorRating; // info from rate my professor - might be more than one parameter
	Course[][] weekSchedule; // 2 dimensional array representing 1 week schedule ['week days']['number of classes']
	int numberOfClasses; // number of classes wanted in Schedule
	

	
	// constructor
	public Schedule() {
		super();
		create();
		sortEachRow(weekSchedule);
		calculate();
		
	}

	// create 2 dimensional array with 'Courses'
	private void create() {
		weekSchedule = new Course[6][this.numberOfClasses];
		
		// set Courses into the 'weekSchedule' array
		for(int i = 0; i < numberOfClasses; i++) {
			
			String courseDays = this.getCourses().get(i).getCourseDays();
			if (courseDays == "M") {
				weekSchedule[0][i] = this.getCourses().get(i);
			} else if (courseDays == "T") {
				weekSchedule[1][i] = this.getCourses().get(i);
			} else if (courseDays == "W") {
				weekSchedule[2][i] = this.getCourses().get(i);
			} else if (courseDays == "R") {
				weekSchedule[3][i] = this.getCourses().get(i);
			} else if (courseDays == "F") {
				weekSchedule[4][i] = this.getCourses().get(i);
			} else if (courseDays == "S") {
				weekSchedule[5][i] = this.getCourses().get(i);
			} else if(courseDays == "MW") {
				weekSchedule[0][i] = this.getCourses().get(i);
				weekSchedule[2][i] = this.getCourses().get(i);
			} else if (courseDays == "TR") {
				weekSchedule[1][i] = this.getCourses().get(i);
				weekSchedule[3][i] = this.getCourses().get(i);
			} else if (courseDays == "MWF") {
				weekSchedule[0][i] = this.getCourses().get(i);
				weekSchedule[2][i] = this.getCourses().get(i);
				weekSchedule[4][i] = this.getCourses().get(i);
			} 
			
		} // end of FOR loop
		
	} // end create
	
	
	// sort each row of 2D array weekSchedule by 'courseTime'
	private static void sortEachRow(Course[][] weekSchedule) {
		for(int i = 0; i < weekSchedule.length  ; i++) {
			Arrays.sort(weekSchedule[i]); // sorting by whole row objects(Course), need to be sorting by the time of Couses 
		}
		
	}

	// or 
	
//	private void sortByTime() {
//		
//		Arrays.sort(weekSchedule, new Comparator<Course[]>() {
//
//			@Override
//			public int compare(Course[] o1, Course[] o2) {
//				String courseTime1 = o1[0].getCourseTime();
//		        String courseTime2 = o2[0].getCourseTime();
//				return courseTime1.compareTo(courseTime2);
//			}
//
//		});
//		
//	} 
	
	// end sort
	

	
	// calculate total number of days per schedule, and total break in minutes per schedule
	private void calculate() {
		/* represent time by two dimensional array, 
		 * [0][0] - hours start time, 
		 * [0][1] - minutes start time,
		 * [1][0] - hours end time, 
		 * [1][1] - minutes end time,
		 */
		int[][] timeArray1 = new int[2][2]; // time for previous course
		int[][] timeArray2 = new int[2][2]; // time for next course
		
		// find out break in minutes total time
		for(int i = 0; i < 6; i++) { // this 'loop' represents 6 days per week, Monday - Saturday
			
			int dailyBreakInMinutes = 0; // daily break in minutes
			int numberOfClassesPerDay = 0; // it shows how many classes are in particular day of the week 
			// can be done in form of one dimensional array - so we can always get this info for any particular day of week
			// initial parameter shoul be moved to the top of the code, plus in this case we should create getters
			// int[] numberOfClassesPerDay = new int[6];
			// numberOfClassesPerDay[i] = 0;
			
			// find out how many classes are per particular day of week
			for(int j = 0; j < this.numberOfClasses; j++) {
				if(weekSchedule[j][i] != null) {
					numberOfClassesPerDay = numberOfClassesPerDay + 1;
				}
			} // end of 'j' FOR loop
			
			// counter for totalDays - how many day this schedule has
			if(numberOfClassesPerDay > 0) {
				totalDays = totalDays + 1;
			}
			
			// check if numberOfClassesPerDay > 1 then calculate daily break in minutes
			if(numberOfClassesPerDay > 1) {
				// calculate total break in minutes per particular day of week
				int breakHours = 0; // hours difference
				int breakMinutes = 0; // minutes difference
				
				for(int k = 0; k < (numberOfClassesPerDay - 1); k++) {

					String courseTime1 = weekSchedule[i][k].getCourseTime(); // get out previous class time as String ("10:00 - 11:15")
					String courseTime2 = weekSchedule[i][k + 1].getCourseTime(); // get out next class time as String
					timeArray1 = Course.getTime(courseTime1); // represent time as 2 dimension array
					timeArray2 = Course.getTime(courseTime2); // represent time as 2 dimension array
					
					breakHours = timeArray2[0][0] - timeArray1[1][0]; // hours difference
					breakMinutes = timeArray2[0][1] - timeArray1[1][1]; // minutes difference
					
					// check first if the breakHours is >= 0 calculate the break time
					if(breakHours >= 0) {
						// check if the breakMinutes is negative then subtract 1 from breakHours
						if(breakMinutes < 0) {
							breakHours = breakHours - 1; // subtract 1 from hours
							breakMinutes = 60 + breakMinutes; // calculate minutes
						}
					
						dailyBreakInMinutes = (breakHours * 60) + breakMinutes; // calculate total brake in minutes for particular day of week
						
					}
					
				} // end of 'k' FOR loop
			} 
			
			totalBreakInMinutes = totalBreakInMinutes + dailyBreakInMinutes; // calculate total brake in minutes for one particular schedule
 
		} // end of 'i' FOR loop
		
		
	} // end 'calculate'
	
	
	// getters and setters
	/**
	 * @return the courses
	 */
	public List<Course> getCourses() {
		return Courses;
	}


	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<Course> courses) {
		Courses = courses;
	}


	/**
	 * @return the totalDays
	 */
	public int getTotalDays() {
		return totalDays;
	}


	/**
	 * @param totalDays the totalDays to set
	 */
	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}


	/**
	 * @return the totalBreakInMinutes
	 */
	public int getTotalBreakInMinutes() {
		return totalBreakInMinutes;
	}


	/**
	 * @param totalBreakInMinutes the totalBreakInMinutes to set
	 */
	public void setTotalBreakInMinutes(int totalBreakInMinutes) {
		this.totalBreakInMinutes = totalBreakInMinutes;
	}


	/**
	 * @return the professorRating
	 */
	public int getProfessorRating() {
		return professorRating;
	}

	/**
	 * @param professorRating the professorRating to set
	 */
	public void setProfessorRating(int professorRating) {
		this.professorRating = professorRating;
	}

	/**
	 * @return the numberOfClasses
	 */
	public int getNumberOfClasses() {
		return numberOfClasses;
	}

	/**
	 * @param numberOfClasses the numberOfClasses to set
	 */
	public void setNumberOfClasses(int numberOfClasses) {
		this.numberOfClasses = numberOfClasses;
	}

	// added by Brandon Bell ----------------------------------------
	public boolean countain(String subject){
		for(int i = 0; i < Courses.size(); i++){
			if(Courses.get(i).getSubject().equals(subject)){
				return true;
			}
		}
		return false;
	}
	// end added by Brandon Bell ------------------------------------


	
}


