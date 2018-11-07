package CoreJava.DAO;

import CoreJava.Models.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO{
	// create the list for students
	public List<Student>  getStudents() throws IOException{
		List<String> lines = Files.readAllLines(Paths.get("students.csv"));
		//System.out.println(lines.size());
		List<Student> stu = new ArrayList<Student>();
		String splitBy = ","; 
		for(int i=0;i<lines.size();i++) {

			String[] st = lines.get(i).split(splitBy);
			Student s =new Student(st[0],st[1],st[2]);
			stu.add(i, s);
			// System.out.println(s.toString());
		}
		return stu;
 
	}
// find student by email
	public  Student getStudentByEmail(List<Student> studentList, String studentEmail){
		//System.out.println(studentList.get(0));
		Student st = new Student();
		//st=studentList.get(0);
		//System.out.println(st.getName());

		for(int i=0;i<studentList.size();i++) {  
			Student st1= studentList.get(i);
			//System.out.println(st1.getName());
			if(st1.getEmail().equals(studentEmail)) {
				//System.out.println("IN LOOP found");
				st=  st1;	
			}
			else st=st;
		}
		//System.out.println("in DAO "+st);
		return st; 
	}
	
// validate student
	public boolean validateUser(List<Student> studentList, String studentEmail, String studentPass){
		boolean temp = false;
		System.out.println("stdent size "+studentList.size());
		for(int i=0;i<studentList.size();i++) {
			//System.out.println();
			if((studentList.get(i).getEmail().equalsIgnoreCase(studentEmail))&&(studentList.get(i).getPass().equals(studentPass))) {
				//System.out.println(studentList.get(i).getEmail().equalsIgnoreCase(studentEmail));
				temp=  true;
				//System.out.println("IN LOOP "+temp);
			}
			//else temp= false;
		}
		return temp;

	}
}
