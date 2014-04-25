package courseObjects;

public class Course implements Comparable<Course>{

	// instance data fields:
	private boolean waitListAvailable; // establishes if a wait list is available
	private int courseCode; // 4 digit number following the courseName
	private int section; // the class section
	private int crn; // 5 digit course number
	private double creditHours; // the number of hours the course yields
	private boolean fullTerm; // establishes if the course duration is full-term or part-term
	private int capacity; // the max amount of students allowed to register for  the course
	private int seatsAvailable; // the number of seats available
	private int waitListCapacity; // the max number of students allowed on the wait-list for this course
	private int waitListCount; // the number of students actually on the wait-list
	private int waitListAvailability; // amount of wait-list slots available
	private boolean onMainCampus; // establishes if the this particular class is on the main campus
	private String building; // the building location of class
	private int room; // the classroom number
	private String courseDays; // the days that the class meets
	private String courseTime; // (military time) when class starts and ends for the day
	private String fullTermEndDate; // last day of class
	private String partTermEndDate; // last day of class for part-term classes
	private String instructor; // Complete name of instructor static data fields:
	private static int numberOfClasses; // total number of classes registered by the student
	private static int totalHours; // total number of credit/hours registered by the student
	private static String startDate; // 1st day for all classes
	
	//addedd by Brandon
		private String subject; // 2 or 4 alphabetic characters used to name the course (ie. MATH, CS, ENGL)

	//changed by Brandon
		private String courseName; // name of the class (ie. CS2301)
	
	// default constructor:
	public Course() {

	}
	
	// testCourse.java constructor:
		public Course(String subject, int courseCode, int crn, double creditHours,
				String building, int room, String courseTime, String instructor) {
			this.subject = subject;
			this.courseCode = courseCode;
			this.crn = crn;
			this.creditHours = creditHours;
			this.building = building;
			this.room = room;
			this.courseTime = courseTime;
			this.instructor = instructor;
			
		}

	// constructor with all data fields:
	public Course(String subject, int courseCode, int section, int crn,
			int creditHours, int capacity, int waitListCapacity,
			int waitListCount, String building, int room, String courseDays,
			String courseTime, String fullTermEndDate, String partTermEndDate,
			String instructor) {
		this.subject = subject;
		this.courseCode = courseCode;
		this.section = section;
		this.crn = crn;
		this.creditHours = creditHours;
		this.capacity = capacity;
		this.waitListCapacity = waitListCapacity;
		this.waitListCount = waitListCount;
		this.building = building;
		this.room = room;
		this.courseDays = courseDays;
		this.courseTime = courseTime;
		this.fullTermEndDate = fullTermEndDate;
		this.partTermEndDate = partTermEndDate;
		this.instructor = instructor;
	}
	//added by Brandon
	public int compareTo(Course input) {
		int[][] time1 = getTime(courseTime);
		int[][] time2 = getTime(input.getCourseTime());
		if(time1[0][0] < time2[0][0] && time1[0][1] < time2[0][1] || time1[0][0] < time2[0][0] && time1[0][1] == time2[0][1]){
			return -1;
		}else if(time1[0][0] == time2[0][0] && time1[0][1] == time2[0][1]){
			return 0;
		}else{
			return 1;
		}
	}

	public boolean equals(Course input){
		return subject.equals(input.getSubject());
	}

	public static int[][] getTime(String input){
		int[][] time = new int[2][2];
		time[0][0] = Integer.parseInt(input.substring(0, input.indexOf(":"))); 
		time[0][1] = Integer.parseInt(input.substring(input.indexOf(":") + 1 , input.indexOf(":") + 3));
		String b = input.substring(input.lastIndexOf("-") + 2);
		time[1][0] = Integer.parseInt(b.substring(0, b.indexOf(":"))); 
		time[1][1] = Integer.parseInt(b.substring(b.indexOf(":")+1,b.indexOf(":")+3 ));
		return time;
	}

	public String toString() {
		return "CRN: " + crn + " TIME " + courseTime + " DAY " + courseDays;
	}
	//end of add

	// getter & setter methods
	private boolean open; // establishes if the course is open or closed

	//added by Brandon
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	//end of added code by Brandon
	
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isWaitListAvailable() {
		return waitListAvailable;
	}

	public void setWaitListAvailable(boolean waitListAvailable) {
		this.waitListAvailable = waitListAvailable;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public int getCrn() {
		return crn;
	}

	public void setCrn(int crn) {
		this.crn = crn;
	}

	public double getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	public boolean isFullTerm() {
		return fullTerm;
	}

	public void setFullTerm(boolean fullTerm) {
		this.fullTerm = fullTerm;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public int getWaitListCapacity() {
		return waitListCapacity;
	}

	public void setWaitListCapacity(int waitListCapacity) {
		this.waitListCapacity = waitListCapacity;
	}

	public int getWaitListCount() {
		return waitListCount;
	}

	public void setWaitListCount(int waitListCount) {
		this.waitListCount = waitListCount;
	}

	public int getWaitListAvailability() {
		return waitListAvailability;
	}

	public void setWaitListAvailability(int waitListAvailability) {
		this.waitListAvailability = waitListAvailability;
	}

	public boolean isOnMainCampus() {
		return onMainCampus;
	}

	public void setOnMainCampus(boolean onMainCampus) {
		this.onMainCampus = onMainCampus;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public String getCourseDays() {
		return courseDays;

	}

	public void setCourseDays(String courseDays) {
		this.courseDays = courseDays;
	}

	public String getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}

	public String getFullTermEndDate() {
		return fullTermEndDate;
	}

	public void setFullTermEndDate(String fullTermEndDate) {
		this.fullTermEndDate = fullTermEndDate;
	}

	public String getPartTermEndDate() {
		return partTermEndDate;
	}

	public void setPartTermEndDate(String partTermEndDate) {
		this.partTermEndDate = partTermEndDate;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public static int getNumberOfClasses() {
		return numberOfClasses;
	}

	public static void setNumberOfClasses(int numberOfClasses) {
		Course.numberOfClasses = numberOfClasses;
	}

	public static int getTotalHours() {
		return totalHours;
	}

	public static void setTotalHours(int totalHours) {
		Course.totalHours = totalHours;
	}

	public static String getStartDate() {
		return startDate;
	}

	public static void setStartDate(String startDate) {
		Course.startDate = startDate;
	}

}
