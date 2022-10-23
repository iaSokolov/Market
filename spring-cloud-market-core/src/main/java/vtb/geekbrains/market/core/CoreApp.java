package vtb.geekbrains.market.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CoreApp {
    public static void main(String[] args) {

        SpringApplication.run(CoreApp.class, args);
    }
}