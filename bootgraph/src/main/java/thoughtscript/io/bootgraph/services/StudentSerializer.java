package thoughtscript.io.bootgraph.services;

import org.springframework.stereotype.Component;
import thoughtscript.io.bootgraph.domain.Course;
import thoughtscript.io.bootgraph.domain.CourseDTO;
import thoughtscript.io.bootgraph.domain.Student;
import thoughtscript.io.bootgraph.domain.StudentDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentSerializer {

    public StudentDTO convertStudentToDto(Student student) {
        List<Course> source = student.getCourses();
        List<CourseDTO> target = new ArrayList<>();

        for (Course course : source) {
            target.add(
                    new CourseDTO( // Return only what's necessary...
                            course.getCourseName(),
                            null // Only go one level deep
                    )
            );
        }

        return new StudentDTO(student.getFirstName(), student.getLastName(), target);
    }

    public List<StudentDTO> convertStudents(List<Student> students) {
        List<StudentDTO> result = new ArrayList<>();

        for (Student student : students) {
            result.add(convertStudentToDto(student));
        }

        return result;
    }
}
