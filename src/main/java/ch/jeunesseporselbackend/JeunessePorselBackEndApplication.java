package ch.jeunesseporselbackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Jeunesse de porsel API", version = "1.0", description = "created by @paschek"))
public class JeunessePorselBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(JeunessePorselBackEndApplication.class, args);
    }

}
