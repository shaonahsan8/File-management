package CoreJava.Models;

public class Student {
	private		String	email;
	private		String	name;
	private		String	pass;


  
	public void setEmail(String email){

    }
	@Override
	public String toString() {
		return "Student [email=" + email + ", name=" + name + ", pass=" + pass + "]\n";
	}
    public Student(String email, String name, String pass) {
		this.email = email;
		this.name = name;
		this.pass = pass;
	}

	public Student() {
	}

	public String getEmail(){ 
		return email;

    }

    public void setName(String name){
this.name=name;
    }

    public String getName(){
		return name;

    }

    public void setPass(String pass){
this.pass =pass;
    }

    public String getPass(){
		return pass;

    }
}
