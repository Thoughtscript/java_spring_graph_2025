package thoughtscript.io.bootgraph.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import thoughtscript.io.bootgraph.domain.Course;
import thoughtscript.io.bootgraph.domain.CourseDTO;
import thoughtscript.io.bootgraph.domain.Student;
import thoughtscript.io.bootgraph.domain.StudentDTO;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class CourseSerializerTest {

    @Autowired
    CourseSerializer courseSerializer;

    @Test
    void testA() {
        List<Course> s_c = new ArrayList<>();
        Student s = new Student("Class", "Clown", null);
        List<Student> c_s = new ArrayList<>();
        c_s.add(s);
        Course a = new Course("Art", c_s);
        s_c.add(a);
        s.setCourses(s_c);

        List<CourseDTO> s_c_dto = new ArrayList<>();
        StudentDTO s_dto = new StudentDTO("Class", "Clown", null);
        List<StudentDTO> c_s_dto = new ArrayList<>();
        c_s_dto.add(s_dto);
        CourseDTO a_dto = new CourseDTO("Art", c_s_dto);
        s_c_dto.add(a_dto);

        CourseDTO result = courseSerializer.convertCourseToDto(a);
        log.info("Expected: " + a_dto.toString() + " Result: " + result.toString());
        assertEquals(a_dto, result);
    }
}
