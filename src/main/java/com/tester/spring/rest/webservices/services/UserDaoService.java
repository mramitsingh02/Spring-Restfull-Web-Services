package com.tester.spring.rest.webservices.services;

import com.tester.spring.rest.webservices.pojo.User;
import org.springframework.context.annotation.ComponentScan;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@ComponentScan("userDaoService")
public class UserDaoService {


    private static AtomicInteger idGenerator;

    private static Map<Integer, User> userMap = new HashMap<>();


    public UserDaoService() {
    }

    static {

        saveUser(new User(1, "Amit", new Date()));
        saveUser(new User(2, "Sanu", new Date()));
        saveUser(new User(3, "Tannu", new Date()));
        saveUser(new User(4, "Juleey", new Date()));
        idGenerator = new AtomicInteger(userMap.size());
    }


    public static User getUserById(Integer id) {
        return userMap.get(id);
    }


    public static List<User> getUsers() {
        return userMap.values().stream().collect(Collectors.toList());
    }


    public static int saveUser(User user) {
        if (Objects.isNull(user)) {
            return -1;
        }
        if (Objects.isNull(user.getId())) {
            user.setId(idGenerator.incrementAndGet());
        }

        userMap.put(user.getId(), user);
        return user.getId();
    }

    public User detetUser(Integer userId) {
        return userMap.remove(userId);
    }
}