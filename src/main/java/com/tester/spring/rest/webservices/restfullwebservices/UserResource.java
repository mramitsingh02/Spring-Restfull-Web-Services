package com.tester.spring.rest.webservices.restfullwebservices;


import com.tester.spring.rest.webservices.exception.UserNotFoundException;
import com.tester.spring.rest.webservices.pojo.User;
import com.tester.spring.rest.webservices.services.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired(required = true)
    private UserDaoService userDaoService;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.getUsers();
    }

    @GetMapping(path = "/users/{userId}")
    public Resource<User> retrieveUsers(@PathVariable Integer userId) {

        User user = userDaoService.getUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("Id-" + userId);
        }

        Resource<User> resource = new Resource<User>(user);

        ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }


    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        int userId = userDaoService.saveUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userId).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = "/users/{userId}")
    public void deletedUser(@PathVariable Integer userId) {
        User user = userDaoService.detetUser(userId);
        if (user == null)
            throw new UserNotFoundException("User Id - " + userId);
    }

    @Configuration
    @EnableSwagger2
    public static class SwaggerConfig {
        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2);
        }


    }
}
