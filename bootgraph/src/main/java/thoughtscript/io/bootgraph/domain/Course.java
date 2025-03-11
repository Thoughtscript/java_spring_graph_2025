package thoughtscript.io.bootgraph.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

@Node
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private @Id
    @GeneratedValue Long id;

    @Property("courseName")
    private String courseName;

    @Relationship(type = "HAS_STUDENT", direction = Relationship.Direction.OUTGOING)
    private List<Student> students = new ArrayList<>();
}
