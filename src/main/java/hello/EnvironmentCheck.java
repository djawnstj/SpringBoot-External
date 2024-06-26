package hello;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EnvironmentCheck {

    private final Environment env;

    public EnvironmentCheck(final Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void init() {
        final String url = env.getProperty("url");
        final String username = env.getProperty("username");
        final String password = env.getProperty("password");

        log.info("env url={}", url);
        log.info("env username={}", username);
        log.info("env password={}", password);
    }
}
