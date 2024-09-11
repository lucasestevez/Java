package List.usingArrayList;

import java.util.ArrayList;
import java.util.Comparator;
import static java.util.Arrays.*;

/*
Exercise 1: ArrayList Manipulation:
 - Create a class called Student with the attributes id (int), name (String) e grade (double).
 - Create an ArrayList<Student>.
 - Add 5 Students objects to the ArrayList.
 - Scroll through the list and display the names of students with a grade above 7.0.
 - Sort the ArrayList for grade using a Comparator.
*/

public class ArrayListManipulation {

    public static void main(String[] args) {

        ArrayList<Student> studentList = new ArrayList<Student>
                (asList(new Student(431254, "Maria", 8.9),
                        new Student(908723, "Tiago", 6.5),
                        new Student(843532, "Lucas", 10),
                        new Student(876214, "Júlia", 7.8),
                        new Student(154216, "Luísa", 9.5)));

        System.out.println("Students Name with grade above 7.0:\n");
        studentList.stream()
                .filter(t -> t.getGrade() > 7.0)
                .forEach(student -> System.out.println(student.getName()));

        System.out.println("Sorted ArrayList by Grade\n");
        studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getGrade))
                .forEach(System.out::println);
    }
}
