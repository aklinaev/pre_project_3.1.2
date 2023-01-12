package com.prep.p_maven.dao;

import com.prep.p_maven.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private final EntityManager manager;

    public UserDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<User> getAll() {
        return manager.createQuery("select u from User u", User.class)
                .getResultList();
    }


    @Override
    @Transactional
    public void addUser(User user) {
        manager.persist(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        User userToDel = manager.find(User.class, id);
        manager.remove(userToDel);
    }

    @Override
    public User getUser(long id) {
        return manager.find(User.class, id);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return manager.merge(user);
    }
}
