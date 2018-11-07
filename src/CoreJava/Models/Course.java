package CoreJava.Models;

public class Course {
	private		int	courseID;
	private		String	courseName;
	private		String	InstructorName;

    @Override
	public String toString() {
		return "Course [courseID=" + courseID + ", courseName=" + courseName + ", InstructorName=" + InstructorName
				+ "]";
	}

	public void setID(int ID){
this.courseID =ID ;
    }

    public int getID(){
		return courseID;

    }

    public void setName(String name){
this.courseName=name;
    }

    public String getName(){
		return courseName;

    }

    public void setInstructor(String instructor){
this.courseName=instructor ;
    }

    public Course(int courseID, String courseName, String instructorName) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		InstructorName = instructorName;
	}

	public String getInstructor(){
		return InstructorName;

    }

}
