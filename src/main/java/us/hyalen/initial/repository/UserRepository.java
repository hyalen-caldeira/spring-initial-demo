package us.hyalen.initial.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.hyalen.initial.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT usr FROM User usr WHERE usr.username = :username")
    User findUserByUsername(String username);
}
