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
public class Student {

    private @Id
    @GeneratedValue Long id;

    @Property("firstname")
    private String firstName;

    @Property("lastname")
    private String lastName;

    @Relationship(type = "ENROLLED_IN", direction = Relationship.Direction.OUTGOING)
    private List<Course> courses = new ArrayList<>();
}
