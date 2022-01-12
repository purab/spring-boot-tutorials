package in.purabtech.hibernatespring;

import java.util.Optional;

import in.purabtech.hibernatespring.entity.EmployeeEntity;
import in.purabtech.hibernatespring.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class HibernateSpringApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmployeeRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(HibernateSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Optional<EmployeeEntity> emp = repository.findById(2L);

        logger.info("Employee id 2 -> {}", emp.get());
    }
}
