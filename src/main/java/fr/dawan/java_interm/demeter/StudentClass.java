package fr.dawan.java_interm.demeter;

import java.util.List;

public class StudentClass {

	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	public int count() {
		int count = 0;
		 for(Student student : getStudents()) {
             count++;
    }		return count;
	}

}
