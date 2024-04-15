package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

@Slf4j
public class JavaSystemProperties {

    public static void main(String[] args) {
        final Properties properties = System.getProperties();
        for (Object key : properties.keySet()) {
            log.info("prop {}={}", key, System.getProperty(String.valueOf(key)));
        }

        final String url = System.getProperty("url");
        final String username = System.getProperty("username");
        final String password = System.getProperty("password");

        log.info("url={}", url);
        log.info("username={}", username);
        log.info("password={}", password);

        System.setProperty("hello_key", "hello_value");
        final String helloValue = System.getProperty("hello_key");
        log.info("helloValue={}", helloValue);
    }

}
