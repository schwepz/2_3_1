
package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void removeUserById(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
}