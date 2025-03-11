package thoughtscript.io.bootgraph.configs;

import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

//@EnableNeo4jRepositories - this must be commented out
@Configuration
public class DataConfig {

    @Bean
    org.neo4j.cypherdsl.core.renderer.Configuration cypherDsl() {
	    return org.neo4j.cypherdsl.core.renderer.Configuration
            .newConfig()
            .withDialect(Dialect.NEO4J_5)
            .build();
    }
}
