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
public class StudentSerializerTest {

    @Autowired
    StudentSerializer studentSerializer;

    @Test
    void testA() {
        List<Course> a_c = new ArrayList<>(List.of(new Course("Art", null)));
        Student a = new Student("Class", "Clown", a_c);
        List<Student> a_c_s = new ArrayList<>();
        a_c_s.add(a);
        a_c.get(0).setStudents(a_c_s);

        List<CourseDTO> a_c_dto = new ArrayList<>(List.of(new CourseDTO("Art", null)));
        StudentDTO a_dto = new StudentDTO("Class", "Clown", a_c_dto);
        List<StudentDTO> a_c_s_dto = new ArrayList<>();
        a_c_s_dto.add(a_dto);

        StudentDTO result = studentSerializer.convertStudentToDto(a);
        log.info("Expected: " + a_dto.toString() + " Result: " + result.toString());
        assertEquals(a_dto, result);
    }
}
