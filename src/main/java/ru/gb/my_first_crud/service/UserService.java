package ru.gb.my_first_crud.service;

import org.springframework.stereotype.Service;
import ru.gb.my_first_crud.mode.User;
import ru.gb.my_first_crud.repository.UserRepository;

import java.util.List;

@Service // соееняет межу собой репозиторий и контролер
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

    /* 
        2) В класс UserService добавить метод public void deleteById(int id)
        (подсказка: в нем вызывается метод userRepository.deleteById)
         - удаление пользователя через репозиторий. 
    */
    public void deleteById(int id){
        userRepository.deleteById(id);
    }
}
