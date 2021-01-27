package fr.dawan.java_interm.demeter;

import java.util.List;

public class School {
	 private List<Grade> _grades;
     
     public School(List<Grade> _grades) {
             super();
             this._grades = _grades;
     }
     
     //cette méthode ne respecte pas la loi de déméter
     public int countStudents() {
            int count = 0;
            for(Grade grade : _grades) {
            	 count += grade.count();
            	
                    
             }
             return count;
    }
}

