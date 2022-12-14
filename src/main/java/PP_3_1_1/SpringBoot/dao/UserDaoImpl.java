package PP_3_1_1.SpringBoot.dao;

import PP_3_1_1.SpringBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User user) {

        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return  query.getResultList();
    }

    @Override
    public User getUser(Long id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public void editUser(Long id, User user) {

        User edit = entityManager.find(User.class, id);
        edit.setName(user.getName());
        edit.setSecond_name(user.getSecond_name());
        edit.setAge(user.getAge());
        edit.setEmail(user.getEmail());
    }

    @Override
    public void deleteUser(Long id) {

        entityManager.remove(entityManager.find(User.class, id));
    }
}