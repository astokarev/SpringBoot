package PP_3_1_1.SpringBoot.service;

import PP_3_1_1.SpringBoot.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> listUsers();

    User getUser(Long id);

    void editUser(Long id, User user);

    void deleteUser(Long id);
}