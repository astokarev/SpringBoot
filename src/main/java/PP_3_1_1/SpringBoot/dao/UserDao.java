package PP_3_1_1.SpringBoot.dao;

import PP_3_1_1.SpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> listUsers();

    User getUser(Long id);

    void editUser(Long id, User user);

    void deleteUser(Long id);
}