package us.hyalen.initial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.hyalen.initial.entity.User;
import us.hyalen.initial.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        Optional<User> user = Optional.ofNullable(userRepository.findUserByUsername(username));

        return user.orElse(new User());
    }
}
