package us.hyalen.initial.service;

import org.springframework.stereotype.Service;
import us.hyalen.initial.entity.Location;
import us.hyalen.initial.entity.User;

public interface UserService {
    User getUserByUsername(String username);
}
