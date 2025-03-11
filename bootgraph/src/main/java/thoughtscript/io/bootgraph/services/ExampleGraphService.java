package thoughtscript.io.bootgraph.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thoughtscript.io.bootgraph.configs.ConfigProperties;
import thoughtscript.io.bootgraph.domain.Course;
import thoughtscript.io.bootgraph.domain.CourseDTO;
import thoughtscript.io.bootgraph.domain.Student;
import thoughtscript.io.bootgraph.domain.StudentDTO;
import thoughtscript.io.bootgraph.repositories.CourseRepository;
import thoughtscript.io.bootgraph.repositories.StudentRepository;

import java.util.List;

@Slf4j
@Service
public class ExampleGraphService {

    @Autowired
    ConfigProperties configs;

    @Autowired
    CourseSerializer courseSerializer;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentSerializer studentSerializer;

    @Autowired
    StudentRepository studentRepository;

    public List<CourseDTO> findCourseByCourseName(String courseName) {
        List<Course> recordSet = courseRepository.findCourseByName(courseName);
        if (configs.isFullLogging()) log.info(recordSet.toString());

        List<CourseDTO> result = courseSerializer.convertCourses(recordSet);
        if (configs.isFullLogging()) log.info(result.toString());
        return result;
    }

    public List<CourseDTO> findCourseByStudent(String studentFirstName, String studentLastName) {
        List<Course> recordSet = courseRepository.findCoursesByStudent(studentFirstName, studentLastName);
        if (configs.isFullLogging()) log.info(recordSet.toString());

        List<CourseDTO> result = courseSerializer.convertCourses(recordSet);
        if (configs.isFullLogging()) log.info(result.toString());
        return result;
    }

    public List<CourseDTO> findAllCourses() {
        List<Course> recordSet = courseRepository.findAllCourses();
        if (configs.isFullLogging()) log.info(recordSet.toString());

        List<CourseDTO> result = courseSerializer.convertCourses(recordSet);
        if (configs.isFullLogging()) log.info(result.toString());
        return result;
    }

    public List<StudentDTO> findAllStudents() {
        List<Student> recordSet = studentRepository.findAllStudents();
        if (configs.isFullLogging()) log.info(recordSet.toString());

        List<StudentDTO> result = studentSerializer.convertStudents(recordSet);
        if (configs.isFullLogging()) log.info(result.toString());
        return result;
    }

    public List<StudentDTO> findStudentByName(String firstName, String lastName) {
        List<Student> recordSet = studentRepository.findStudentByName(firstName, lastName);
        if (configs.isFullLogging()) log.info(recordSet.toString());

        List<StudentDTO> result = studentSerializer.convertStudents(recordSet);
        if (configs.isFullLogging()) log.info(result.toString());
        return result;
    }
}
