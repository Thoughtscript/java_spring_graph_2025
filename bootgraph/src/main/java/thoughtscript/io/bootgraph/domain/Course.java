package thoughtscript.io.bootgraph.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

@Node("Course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @Property("name")
    private String courseName;

    @Relationship(type = "HAS_STUDENT", direction = Relationship.Direction.OUTGOING)
    private List<Student> students = new ArrayList<>();
}
