import java.util.ArrayList;
import java.util.List;

//package courseObjects;

public class testCourse {
	//changed name by Brandon
	public static List<Course> set() {

		//added by Brandon
		List<Course> allClasses = new ArrayList<Course>();
		//end of add
		
		// sample cs courses
		Course cs2301A = new Course("CS", 2301, 82449, 4.0,"Clendenin Building", 2007, "2:00 - 3:15", "Hisham M. Haddad");
		cs2301A.setCourseDays("MW");
		
		Course cs2301B = new Course("CS", 2301, 82519, 4.0,"Clendenin Building", 2005, "2:00 - 3:15", "Yong Shi");
		cs2301B.setCourseDays("TR");
		
		Course cs2301C = new Course("CS", 2301, 83505, 4.0,"Clendenin Building", 2009, "3:30 - 4:45", "TBA");
		cs2301C.setCourseDays("WF");
		
		Course cs2301D = new Course("CS", 2301, 82551, 4.0,"Clendenin Building", 2007, "5:00 - 6:15", "Victor A. Clincy");
		cs2301D.setCourseDays("TR");
		
		//sample eng courses
		Course engl1101A = new Course("ENGL", 1101, 81039, 4.0,"English Building", 132, "8:00 - 9:15", "Andrew S Plattner");
		engl1101A.setCourseDays("MW");
		
		Course engl1101B = new Course("ENGL", 1101, 81040, 4.0,"English Building", 134, "8:00 - 9:15", "TBA");
		engl1101B.setCourseDays("MW");
		
		Course engl1101C = new Course("ENGL", 1101, 81050, 4.0,"English Building", 132, "9:30 - 10:45", "Kendall Klym");
		engl1101C.setCourseDays("WW");
		
		Course engl1101D = new Course("ENGL", 1101, 81071, 4.0,"English Building", 132, "11:00 - 12:15", "Jeffrey M. Cebulski");
		engl1101D.setCourseDays("MW");
		
		// sample math courses
		Course math1190A = new Course("MATH", 1190, 83226, 4.0,"Mathematics & Statistics", 108, "9:30 - 10:40", "Taylor E Sink");
		math1190A.setCourseDays("MWF");
		
		Course math1190B = new Course("MATH", 1190, 83227, 4.0,"Mathematics & Statistics", 108, "11:00 - 12:10", "Taylor E Sink");
		math1190B.setCourseDays("MWF");
		
		Course math1190C = new Course("MATH", 1190, 83234, 4.0,"Mathematics & Statistics", 1003, "11:00 - 12:40", "Nelda H Hadaway");
		math1190C.setCourseDays("TR");
		
		Course math1190D = new Course("MATH", 1190, 83238, 4.0,"Mathematics & Statistics", 132, "2:00 - 3:40", "Symon Kipyagwai Kimitei");
		math1190D.setCourseDays("TR");
		
		
		//sample bio courses:
		Course biol1101A = new Course("BIOL", 1107, 83155, 4.0,"Science", 109, "8:00 - 8:50", "Joy Lynn Brookshire");
		biol1101A.setCourseDays("MWF");
		
		Course biol1101B = new Course("BIOL", 1107, 83156, 4.0,"Science", 109, "2:00 - 3:40", "Jennifer J Davis");
		biol1101B.setCourseDays("TR");
		
		
		// the next 2 biology objects are not located in the catalog, I created them so i could have 4 examples (only 2 courses are available)
		Course biol1101C = new Course("BIOL", 1107, 83159, 4.0,"Science", 352, "6:00 - 8:00", "Joy Lynn Brookshire");
		biol1101C.setCourseDays("TR");
		
		Course biol1101D = new Course("BIOL", 1107, 83160, 4.0,"Science", 132, "6:00 - 8:00", "Joy Lynn Brookshire");
		biol1101D.setCourseDays("MWF");
		
		//added by Brandon
		allClasses.add(cs2301A);
		allClasses.add(cs2301B);
		allClasses.add(cs2301C);
		allClasses.add(cs2301D);
		allClasses.add(engl1101A);
		allClasses.add(engl1101B);
		allClasses.add(engl1101C);
		allClasses.add(engl1101D);
		allClasses.add(math1190A);
		allClasses.add(math1190B);
		allClasses.add(math1190C);
		allClasses.add(math1190D);
		allClasses.add(biol1101A);
		allClasses.add(biol1101B);
		allClasses.add(biol1101C);
		allClasses.add(biol1101D);
		
		return allClasses;
		//end added code
	}

}
