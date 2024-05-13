package ru.geekbrains.homework_sem4.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.geekbrains.homework_sem4.model.User;
import ru.geekbrains.homework_sem4.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void saveUser(String userFirstName, String userLastName){/////////////////////////////////////////////
        userRepository.save(userFirstName, userLastName);
        // return userRepository.save(userFirstName, userLastName);
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    public User getOne(int id) {
        return userRepository.getOne(id);
    } 
}