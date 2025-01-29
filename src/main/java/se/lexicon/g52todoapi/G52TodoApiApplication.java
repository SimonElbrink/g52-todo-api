package se.lexicon.g52todoapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import se.lexicon.g52todoapi.domain.dto.RoleDTOView;
import se.lexicon.g52todoapi.service.RoleService;

import java.util.List;

@SpringBootApplication
public class G52TodoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(G52TodoApiApplication.class, args);
    }


    @Profile("dev")
    @Bean
    public CommandLineRunner runner (RoleService roleService){
        return (args)-> {

            List<RoleDTOView> all = roleService.getAll();
//↖️Add breakpoint 🔴
            // Add Breakpoint then run Debugger to see how the program executes your code.
            // (Be aware of long routes. If you decide to go into Java/Spring Source code.
            //  Remember to "Step out" if you get to deep.)

            all.forEach(System.out::println);

        } ;
    }

}
