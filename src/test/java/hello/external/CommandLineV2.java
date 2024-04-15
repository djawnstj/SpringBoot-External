package hello.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.List;

@Slf4j
public class CommandLineV2 {

    public static void main(String[] args) {
        for (String arg : args) {
            log.info("arg {}", arg);
        }

        System.out.println("\n---------------------------------------------\n");

        final ApplicationArguments appArgs = new DefaultApplicationArguments(args);
        log.info("SourceArgs = {}", List.of(appArgs.getSourceArgs()));
        log.info("NonOptionsArgs = {}", appArgs.getNonOptionArgs());
        log.info("OptionsNames = {}", appArgs.getOptionNames());
        System.out.println("\n---------------------------------------------\n");

        for (final String optionName : appArgs.getOptionNames()) {
            log.info("option arg {}={}", optionName, appArgs.getOptionValues(optionName));
        }
        System.out.println("\n---------------------------------------------\n");

        final List<String> url = appArgs.getOptionValues("url");
        final List<String> username = appArgs.getOptionValues("username");
        final List<String> password = appArgs.getOptionValues("password");
        final List<String> mode = appArgs.getOptionValues("mode");

        log.info("url={}", url);
        log.info("username={}", username);
        log.info("password={}", password);
        log.info("mode={}", mode);
    }
}
