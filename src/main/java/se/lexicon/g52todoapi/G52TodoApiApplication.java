package se.lexicon.g52todoapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.lexicon.g52todoapi.service.RoleService;

@SpringBootApplication
public class G52TodoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(G52TodoApiApplication.class, args);
    }


    @Bean
    public CommandLineRunner runner (RoleService roleService){
        return (args)-> {

            roleService.getAll().forEach(System.out::println);

        } ;
    }

}
