package com.prep.p_maven.service;

import com.prep.p_maven.dao.UserDao;
import com.prep.p_maven.dao.UserDaoImpl;
import com.prep.p_maven.model.User;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public Object getAll() {
        return  userDao.getAll();
    }

    public User getUser(long id) {
        return  userDao.getUser(id);
    }

    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }
}
