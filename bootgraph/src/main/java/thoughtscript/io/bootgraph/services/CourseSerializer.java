package thoughtscript.io.bootgraph.services;

import org.springframework.stereotype.Component;
import thoughtscript.io.bootgraph.domain.Course;
import thoughtscript.io.bootgraph.domain.CourseDTO;
import thoughtscript.io.bootgraph.domain.Student;
import thoughtscript.io.bootgraph.domain.StudentDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseSerializer {

    public CourseDTO convertCourseToDto(Course course) {
        List<Student> source = course.getStudents();
        List<StudentDTO> target = new ArrayList<>();

        for (Student student : source) {
            target.add(
                    new StudentDTO( // Remove or obscure PII here...
                            student.getFirstName(),
                            student.getLastName(),
                            null // Only go one level deep
                    )
            );
        }

        return new CourseDTO(course.getCourseName(), target);
    }

    public List<CourseDTO> convertCourses(List<Course> courses) {
        List<CourseDTO> result = new ArrayList<>();

        for (Course course : courses) {
            result.add(convertCourseToDto(course));
        }

        return result;
    }
}
