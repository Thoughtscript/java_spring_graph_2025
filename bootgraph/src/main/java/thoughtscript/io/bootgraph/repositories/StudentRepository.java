package thoughtscript.io.bootgraph.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;
import thoughtscript.io.bootgraph.domain.Student;

import java.util.List;

@Repository
public interface StudentRepository extends Neo4jRepository<Student, String> {

    @Query("MATCH (s:Student) - [r:ENROLLED_IN] -> (c:Course {name: courseName}) RETURN s, collect(r), collect(c)")
    List<Student> findStudentsEnrolledInCourse(String courseName);

    @Query("MATCH (s:Student {firstname: $studentFirstName, lastname: $studentLastName}) - [r:ENROLLED_IN] -> (c:Course) RETURN s, collect(r), collect(c)")
    List<Student> findStudentByName(String studentFirstName, String studentLastName);

    @Query("MATCH (s:Student) - [r:ENROLLED_IN] -> (c:Course) RETURN s, collect(r), collect(c)")
    List<Student> findAllStudents();
}

