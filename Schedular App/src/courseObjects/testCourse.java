package courseObjects;

public class testCourse {
	public static void main(String[] args) {
		
		// sample cs courses
		Cs2301 cs2301A = new Cs2301("CS", 2301, 82449, 4.0,"Clendenin Building", 2007, "2:00 - 3:15", "Hisham M. Haddad");
		cs2301A.setCourseDays("MW");
		
		Cs2301 cs2301B = new Cs2301("CS", 2301, 82519, 4.0,"Clendenin Building", 2005, "2:00 - 3:15", "Yong Shi");
		cs2301B.setCourseDays("TTH");
		
		Cs2301 cs2301C = new Cs2301("CS", 2301, 83505, 4.0,"Clendenin Building", 2009, "3:30 - 4:45", "TBA");
		cs2301C.setCourseDays("WF");
		
		Cs2301 cs2301D = new Cs2301("CS", 2301, 82551, 4.0,"Clendenin Building", 2007, "5:00 - 6:15", "Victor A. Clincy");
		cs2301D.setCourseDays("TTH");
		
		//sample eng courses
		Engl1101 engl1101A = new Engl1101("ENGL", 1101, 81039, 4.0,"English Building", 132, "8:00 - 9:15", "Andrew S Plattner");
		engl1101A.setCourseDays("MW");
		
		Engl1101 engl1101B = new Engl1101("ENGL", 1101, 81040, 4.0,"English Building", 134, "8:00 - 9:15", "TBA");
		engl1101B.setCourseDays("MW");
		
		Engl1101 engl1101C = new Engl1101("ENGL", 1101, 81050, 4.0,"English Building", 132, "9:30 - 10:45", "Kendall Klym");
		engl1101C.setCourseDays("WW");
		
		Engl1101 engl1101D = new Engl1101("ENGL", 1101, 81071, 4.0,"English Building", 132, "11:00 - 12:15", "Jeffrey M. Cebulski");
		engl1101D.setCourseDays("MW");
		
		// sample math courses
		Math1190 math1190A = new Math1190("MATH", 1190, 83226, 4.0,"Mathematics & Statistics", 108, "9:30 - 10:40", "Taylor E Sink");
		math1190A.setCourseDays("MWF");
		
		Math1190 math1190B = new Math1190("MATH", 1190, 83227, 4.0,"Mathematics & Statistics", 108, "11:00 - 12:10", "Taylor E Sink");
		math1190B.setCourseDays("MWF");
		
		Math1190 math1190C = new Math1190("MATH", 1190, 83234, 4.0,"Mathematics & Statistics", 1003, "11:00 - 12:40", "Nelda H Hadaway");
		math1190C.setCourseDays("TTH");
		
		Math1190 math1190D = new Math1190("MATH", 1190, 83238, 4.0,"Mathematics & Statistics", 132, "2:00 - 3:40", "Symon Kipyagwai Kimitei");
		math1190D.setCourseDays("TTH");
		
		
		//sample bio courses:
		Biol1107 biol1101A = new Biol1107("BIOL", 1107, 83155, 4.0,"Science", 109, "8:00 - 8:50", "Joy Lynn Brookshire");
		biol1101A.setCourseDays("MWF");
		
		Biol1107 biol1101B = new Biol1107("BIOL", 1107, 83156, 4.0,"Science", 109, "2:00 - 3:40", "Jennifer J Davis");
		biol1101B.setCourseDays("TTH");
		
		
		// the next 2 biology objects are not located in the catalog, I created them so i could have 4 examples (only 2 courses are available)
		Biol1107 biol1101C = new Biol1107("BIOL", 1107, 83159, 4.0,"Science", 352, "6:00 - 8:00", "Joy Lynn Brookshire");
		biol1101C.setCourseDays("TTH");
		
		Biol1107 biol1101D = new Biol1107("BIOL", 1107, 83160, 4.0,"Science", 132, "6:00 - 8:00", "Joy Lynn Brookshire");
		biol1101D.setCourseDays("MWF");
		
		
	}

}
