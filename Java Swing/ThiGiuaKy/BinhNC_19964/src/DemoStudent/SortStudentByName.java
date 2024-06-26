package DemoStudent;

import java.util.Comparator;

/**
 * SortStudentByName class
 *
 * @author viettuts.vn
 */
public class SortStudentByName implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student1.getName().compareTo(student2.getName());
    }
}
