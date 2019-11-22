package com.example.demo;

import lombok.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@RestController
@RequiredArgsConstructor
class HelloWorldController {

    @NonNull
    private HelloWorldRepository repository;

    @PostMapping(value = "/hello-world/{name}", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Long helloWorld(@PathVariable String name) {
        HelloWorld save = repository.save(new HelloWorld(name));
        return save.getId();
    }

    @GetMapping(name = "/hello-world")
    public List<String> getGreetings() {
        return repository.findAll().stream().map(HelloWorld::getName).collect(Collectors.toList());
    }
}

interface HelloWorldRepository extends JpaRepository<HelloWorld, Long> {
}

@Entity(name = "HelloWorld")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
class HelloWorld {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private String name;
}
