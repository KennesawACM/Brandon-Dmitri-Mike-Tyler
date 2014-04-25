package courseObjects;

/*Created by Brandon Bell
* ----> New Version Being Made By Dimitri with more Methods and variables
*/
import java.util.ArrayList;
import java.util.List;


public class Schedule {
	List<Course> Courses = new ArrayList<Course>();

	public boolean countain(String subject){
		for(int i = 0; i < Courses.size(); i++){
			if(Courses.get(i).getSubject().equals(subject)){
				return true;
			}
		}
		return false;
	}
}
