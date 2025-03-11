MATCH (n) DETACH DELETE n;
CREATE CONSTRAINT IF NOT EXISTS FOR (c:Course) REQUIRE (c.name) IS UNIQUE;
CREATE INDEX IF NOT EXISTS FOR (c:Course) ON (c.name);

CREATE (Algebra:Course {name:'Algebra'})
CREATE (English:Course {name:'English'})
CREATE (History:Course {name:'History'})
CREATE (Art:Course {name:'Art'})

CREATE (ClassClown:Student {firstname:'Class', lastname:'Clown'})
CREATE (Dunce:Student {firstname:'Class', lastname:'Dunce'})
CREATE (TeachersPet:Student {firstname:'Teachers', lastname:'Pet'})


CREATE
(Algebra)-[:HAS_STUDENT]->(Dunce),
(Algebra)-[:HAS_STUDENT]->(ClassClown),
(History)-[:HAS_STUDENT]->(TeachersPet),
(English)-[:HAS_STUDENT]->(ClassClown),
(Art)-[:HAS_STUDENT]->(ClassClown),

(ClassClown)-[:ENROLLED_IN]->(Algebra),
(ClassClown)-[:ENROLLED_IN]->(English),
(ClassClown)-[:ENROLLED_IN]->(Art),

(Dunce)-[:ENROLLED_IN]->(Algebra),

(TeachersPet)-[:ENROLLED_IN]->(History);