package fr.dawan.java_interm.demeter;

import java.util.List;

public class Grade {

	public List<StudentClass> getClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	public int count() {
		int count = 0;
		for(StudentClass studentClass : getClasses()) {
			count+= studentClass.count();
            for(Student student : studentClass.getStudents()) {
                     count++;
            }
    }
		return count;
	}

}
