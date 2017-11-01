package com.getjavajob.service.impl;

import com.getjavajob.entity.person.User;
import com.getjavajob.repository.IDao;
import com.getjavajob.service.IService;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.List;

@Named("userServiceImpl")
public class UserService implements IService<User> {

    private IDao<User> iDao;

    @Inject
    public UserService(@Named(value = "userDaoImpl") IDao iDao) {
        this.iDao = iDao;
    }

    public List<User> fetchAll() {
        System.out.println("!!!!");
        return this.iDao.fetchAll();
    }

    @Override
    public User getById(Long id) {
        return this.iDao.getById(id);
    }

    public void insert(User entity) {
        System.out.println("entity = " + entity);
        setDate(entity);
        this.iDao.insert(entity);
    }

    private void setDate(User user) {
        user.setInsertTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
    }

    public void deleteAll() {

    }

    public void deleteById(Long id) {

    }

    public void update(User entity) {
        this.iDao.update(entity);
    }
}
