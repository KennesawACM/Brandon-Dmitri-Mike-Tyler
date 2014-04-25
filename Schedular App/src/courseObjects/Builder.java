package courseObjects;
//Created by Brandon Bell

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Builder {
	
	private List<Course> allClasses = testCourse.set();
	private List<Schedule> allSchedules = new ArrayList<Schedule>();
	
	long startTime; //Time Object Was Created 
	int numberOfClasses; //Number of classes wanted in Schedule
	
	
	public static void main(String[] args) {
		Builder build = new Builder(4);		
		build.show();
		
	}
	
	public Builder(int numberOfClasses) {
		this.numberOfClasses = numberOfClasses;
		startTime = System.currentTimeMillis();
		start();
	}

	private void start(){		
		List<Course> options = orderByTime(allClasses);
		
		for(int i = 0; i < options.size(); i++){
			Schedule newSchedule = getSchedule(options, i);
			if(newSchedule != null){
				allSchedules.add(newSchedule);
			}
		}
	}
	
	private Schedule getSchedule(List<Course> options, int startPoint){
		Schedule sch = new Schedule();
		sch.Courses.add(options.get(startPoint));
		for(int i = ++startPoint; i < options.size(); i++){
			if(numberOfClasses == sch.Courses.size()){
				break;
			}
			
			for(int s = 0; s < sch.Courses.size(); s++){
				if(numberOfClasses == sch.Courses.size()){
					break;
				}
				
				if(!sch.countain(options.get(i).getSubject()) && sch.Courses.size() != 0){
					if(!classOverlap(sch.Courses.get(sch.Courses.size()-1), options.get(i))){
						sch.Courses.add(options.get(i));
					}					
				}
			}
		}
		if(sch.Courses.size() != numberOfClasses){
			return null;
		}
		return sch;
	}
	
	public List<Schedule> getSchedules(){
		System.out.println("Total Options: " + allSchedules.size());
		System.out.println("Load Time (Milliseconds): " + (System.currentTimeMillis() - startTime));
		System.out.println();
		
		return allSchedules;
	}
	
	public void show() {
		System.out.println("Total Options: " + allSchedules.size());
		System.out.println("Load Time (Milliseconds): " + (System.currentTimeMillis() - startTime));
		System.out.println();
		
		for(int i = 0; i < allSchedules.size(); i++){
			System.out.println("- - - - - - - - -");
			for(int num = 0; num < numberOfClasses; num++){
				System.out.println(allSchedules.get(i).Courses.get(num).toString());
			}
		}
	}
	
	//Sorts by the compareTo method
	private static List<Course> orderByTime(List<Course> list) {
		Collections.sort(list);
		return list;
	}
	
	private static boolean classOverlap(Course input, Course input2){
		//day check 
		if(!input.getCourseDays().equals(input2.getCourseDays())){
			return false;
		}		
		
		
		int[][] time1 = Course.getTime(input.getCourseTime());
		int[][] time2 = Course.getTime(input2.getCourseTime());		
		Date start1 = new Date(2000, 1, 1, time1[0][0], time1[0][1]);
		Date end1 = new Date(2000, 1, 1, time1[1][0], time1[1][1]);
		Date start2 = new Date(2000, 1, 1, time2[0][0], time2[0][1]);
		Date end2 = new Date(2000, 1, 1, time2[1][0], time2[1][1]);
		
		return start1.before(end2) && start2.before(end1);
	}
	
	private static int[][] getTime(String input){
		int[][] time = new int[2][2];
		time[0][0] = Integer.parseInt(input.substring(0, input.indexOf(":"))); 
		time[0][1] = Integer.parseInt(input.substring(input.indexOf(":") + 1 , input.indexOf(":") + 3));
		String b = input.substring(input.lastIndexOf("-") + 2);
		time[1][0] = Integer.parseInt(b.substring(0, b.indexOf(":"))); 
		time[1][1] = Integer.parseInt(b.substring(b.indexOf(":")+1,b.indexOf(":")+3 ));
		return time;
	}
}

	