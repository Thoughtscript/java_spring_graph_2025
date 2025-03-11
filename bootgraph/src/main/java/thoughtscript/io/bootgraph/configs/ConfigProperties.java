package thoughtscript.io.bootgraph.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties
public class ConfigProperties {

    @Value("${customized.full-logging.enable}")
    private boolean fullLogging;
}
