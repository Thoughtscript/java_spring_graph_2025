package thoughtscript.io.bootgraph.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thoughtscript.io.bootgraph.domain.CourseDTO;
import thoughtscript.io.bootgraph.domain.StudentDTO;
import thoughtscript.io.bootgraph.services.ExampleGraphService;

import java.util.List;

import static thoughtscript.io.bootgraph.configs.Constants.*;

@RestController
@RequestMapping("api/graph")
public class ExampleGraphRestController {

    @Autowired
    ExampleGraphService exampleGraphService;

    @GetMapping("/course")
    public List<CourseDTO> getCourse(@Param(COURSE_NAME) String courseName) {
        return exampleGraphService.findCourseByCourseName(courseName);
    }

    @GetMapping("/course/student")
    public List<CourseDTO> getCourseByStudent(@Param(FIRST_NAME) String firstName, @Param(LAST_NAME) String lastName) {
        return exampleGraphService.findCourseByStudent(firstName, lastName);
    }

    @GetMapping("/student")
    public List<StudentDTO> getStudent(@Param(FIRST_NAME) String firstName, @Param(LAST_NAME) String lastName) {
        return exampleGraphService.findStudentByName(firstName, lastName);
    }

    @GetMapping("/course/all")
    public List<CourseDTO> getAllCourses() {
        return exampleGraphService.findAllCourses();
    }

    @GetMapping("/student/all")
    public List<StudentDTO> getAllStudents() {
        return exampleGraphService.findAllStudents();
    }
}
