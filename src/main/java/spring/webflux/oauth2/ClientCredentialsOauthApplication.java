package spring.webflux.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ClientCredentialsOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientCredentialsOauthApplication.class, args);
    }

}
