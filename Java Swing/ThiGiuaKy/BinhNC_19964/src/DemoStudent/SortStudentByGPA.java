package DemoStudent;

import java.util.Comparator;

/**
 * SortStudentByGPA class
 * 
 * @author viettuts.vn
 */
public class SortStudentByGPA implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getGpa() > student2.getGpa()) {
            return 1;
        }
        return -1;
    }
}
