package CoreJava.DAO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import CoreJava.Models.Course;

public class CourseDAO { 
	//get the list of courses
    public List<Course> getAllCourses() throws IOException{
    	 List<String> lines = Files.readAllLines(Paths.get("courses.csv"));
         //System.out.println(lines);
         List<Course > course = new ArrayList<Course>();
         String splitBy = ","; 
         for(int i=0;i<lines.size();i++) {
         	
         	 String[] st = lines.get(i).split(splitBy);
         	// System.out.println(st[1]);
         	 Course  c =new Course(Integer.parseInt(st[0]),st[1],st[2]);
         	//System.out.println(c.toString());
         	 course.add(i, c);
         	// System.out.println(s.toString());
         }
 		return course;
    }
}
 