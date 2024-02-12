package com.samsquad.fakitureapi.service.event;

import com.samsquad.fakitureapi.repository.UserRepository;
import com.samsquad.fakitureapi.repository.model.User;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByUserNumber(Integer userNumber) throws ChangeSetPersister.NotFoundException {
        return userRepository.findById(userNumber).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserByUserNumber(Integer userNumber) {
        userRepository.deleteById(userNumber);
    }

    public User updateUser(Integer userNumber, String userName) throws ChangeSetPersister.NotFoundException {
        User user = userRepository.findById(userNumber).orElseThrow(ChangeSetPersister.NotFoundException::new);
        user.setUserName(userName);
        return userRepository.save(user);
    }
}
