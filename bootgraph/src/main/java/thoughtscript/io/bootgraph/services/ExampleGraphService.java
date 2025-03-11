package thoughtscript.io.bootgraph.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thoughtscript.io.bootgraph.domain.Course;
import thoughtscript.io.bootgraph.domain.CourseDTO;
import thoughtscript.io.bootgraph.domain.Student;
import thoughtscript.io.bootgraph.domain.StudentDTO;
import thoughtscript.io.bootgraph.repositories.CourseRepository;
import thoughtscript.io.bootgraph.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ExampleGraphService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;

    public List<CourseDTO> findCourseByCourseName(String courseName) {
        List<Course> recordSet = courseRepository.findCourseByName(courseName);
        log.info(recordSet.toString());

        List<CourseDTO> result = new ArrayList<>();

        recordSet.forEach(course -> {
              result.add(new CourseDTO(course.getCourseName(), null));
        });

        log.info(result.toString());
        return result;
    }

    public List<CourseDTO> findCourseByStudent(String studentFirstName, String studentLastName) {
        List<Course> recordSet = courseRepository.findCoursesByStudent(studentFirstName, studentLastName);
        log.info(recordSet.toString());

        List<CourseDTO> result = new ArrayList<>();

        recordSet.forEach(course -> {
            List<Student> source = course.getStudents();
            List<StudentDTO> target = new ArrayList<>();

            source.forEach(student -> {
                target.add(new StudentDTO(student.getFirstName(), student.getLastName(), null));
            });

            result.add(new CourseDTO(course.getCourseName(), target));
        });

        log.info(result.toString());
        return result;
    }

    public List<StudentDTO> findStudentByName(String firstName, String lastName) {
        List<Student> recordSet = studentRepository.findStudentByName(firstName, lastName);
        log.info(recordSet.toString());

        List<StudentDTO> result = new ArrayList<>();

        recordSet.forEach(student -> {
            result.add(new StudentDTO(student.getFirstName(), student.getLastName(), null));
        });

        log.info(result.toString());
        return result;
    }
}
