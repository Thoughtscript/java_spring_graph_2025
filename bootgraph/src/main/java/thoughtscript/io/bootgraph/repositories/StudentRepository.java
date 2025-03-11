package thoughtscript.io.bootgraph.repositories;

import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import thoughtscript.io.bootgraph.domain.Student;

import java.util.List;

@Repository
public interface StudentRepository extends Neo4jRepository<Student, Long> {

    @Query("MATCH (s:Student) - [r:ENROLLED_IN] -> (c:Course {name: courseName}) RETURN s, collect(r), collect(c)")
    List<Student> findStudentsEnrolledInCourse(@Param("courseName") String courseName);

    @Query("MATCH (s:Student {firstname: $studentFirstName, lastname: $studentLastName}) RETURN s")
    List<Student> findStudentByName(@Param("studentFirstName") String studentFirstName, @Param("studentLastName") String studentLastName);
}

