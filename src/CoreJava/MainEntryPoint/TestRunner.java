package CoreJava.MainEntryPoint;

import java.io.IOException;

import CoreJava.DAO.AttendingDAO;
import CoreJava.DAO.CourseDAO;
import CoreJava.DAO.StudentDAO;

public class TestRunner {
    public static void main(String[] args) throws IOException {
    	StudentDAO s=new StudentDAO();
    	CourseDAO c=new CourseDAO();
    	AttendingDAO a=new AttendingDAO();
    	//System.out.println(s.getStudents());
    	s.getStudentByEmail(s.getStudents(), "joe@gmail.com");
    	//System.out.println(s.getStudentByEmail(s.getStudents(), "joe@gmail.com"));
    	//System.out.println(s.validateUser(s.getStudents(), "joe@gmail.com","qer"));
    	//System.out.println(s.validateUser(s.getStudents(), "joe@gmail.com","jc2142"));
    	//System.out.println(c.getAllCourses());
    	//System.out.println(a.getAttending());
    }
}
