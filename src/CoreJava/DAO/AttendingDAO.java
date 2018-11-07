package CoreJava.DAO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import CoreJava.Models.Attending;
import CoreJava.Models.Course;

public class AttendingDAO {
// create the list of attending
    public List<Attending> getAttending() throws IOException{
    	List<String> lines = Files.readAllLines(Paths.get("attending.csv"));
    	 List<Attending > att = new ArrayList<>(); 
         String splitBy = ","; 
         for(int i=0;i<lines.size();i++) {
         	
         	 String[] st = lines.get(i).split(splitBy);
         	Attending  a =new Attending(Integer.parseInt(st[0]),st[1]);
         	 att.add(i, a);
         	 //System.out.println(a.toString());
         }
 		return att; 
    }

 // check if the student is register to the course or not
    public void registerStudentToCourse(List<Attending> attending, String studentEmail, int courseID) throws IOException{
    	boolean temp = false;
		for(int i=0;i<attending .size();i++) { 
//			System.out.println(i+"----------------");
//			System.out.println(attending .get(i).getStudentEmail()+" "+attending .get(i).getCourseID());
//			System.out.println(studentEmail +" "+courseID);
			if((attending .get(i).getStudentEmail().equals(studentEmail))&&(attending .get(i).getCourseID()==(courseID ))) {
				temp=  true;
				
				//System.out.println("IN LOOP "+temp);
				break; 
			}
			else temp= false;
		}
		if(temp==false) {
			Attending  a =new Attending(courseID ,studentEmail);
			 List<Attending > att = new ArrayList<>(); 
			 att.add(a);
			 saveAttending(att);
		}
		else System.out.println("Already attending this course!!!");
    } 
	
    // course list for particular student 
    public List<Course> getStudentCourses(List<Course> courseList, List<Attending> attending, String studentEmail){
    	 List<Course > c = new ArrayList<>(); 
    	 for(int j=0;j<attending .size();j++) {
          	if(attending.get(j).getStudentEmail().equals(studentEmail)) {
          		 for(int i=0;i<courseList.size();i++) {
          			 if(attending.get(j).getCourseID()==courseList.get(i).getID()) {
          			Course  c1 =new Course(courseList.get(i).getID(),courseList.get(i).getName(),courseList.get(i).getInstructor());
          		c.add(c1);
          			 }    
          		 }
          	}
         }
    	 
		return c;
    }

    // add new course for the student
    public void saveAttending(List<Attending> attending) throws IOException{
    	String fileName = "attending.csv";
    	PrintWriter pw = null;
//    	String temp=attending.get(0).getCourseID()+","+attending .get(0).getStudentEmail();
//    	 Files.write(Paths.get(fileName), temp.getBytes(), StandardOpenOption.APPEND);
    	pw = new PrintWriter(new FileWriter(fileName , true));
    	StringBuilder sb = new StringBuilder();


        sb.append(attending.get(0).getCourseID());
        sb.append(',');
        sb.append(attending .get(0).getStudentEmail());
        sb.append('\n');

        pw.write(sb.toString());
        pw.close();
        System.out.println("done adding new attending student!");

    }

}