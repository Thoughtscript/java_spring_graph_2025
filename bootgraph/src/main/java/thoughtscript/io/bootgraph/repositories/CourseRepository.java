package thoughtscript.io.bootgraph.repositories;

import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import thoughtscript.io.bootgraph.domain.Course;

import java.util.List;

@Repository
public interface CourseRepository extends Neo4jRepository<Course, String> {
    @Query("MATCH (c:Course) - [r:HAS_STUDENT] -> (s:Student {firstname: $studentFirstName, lastname: $studentLastName}) RETURN c, collect(r), collect(s)")
    List<Course> findCoursesByStudent(String studentFirstName, String studentLastName);

    @Query("MATCH (c:Course {name: $courseName}) RETURN c")
    List<Course> findCourseByName(String courseName);

    // Match (c:Course {name: "Art"}) - [r:HAS_STUDENT] -> (s:Student) RETURN c, collect(r), collect(s);
}
