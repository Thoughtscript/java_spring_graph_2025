package thoughtscript.io.bootgraph.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node("Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @Property("firstname")
    private String firstName;

    @Property("lastname")
    private String lastName;

    @Relationship(type = "ENROLLED_IN", direction = Relationship.Direction.OUTGOING)
    private List<Course> courses = new ArrayList<>();
}
