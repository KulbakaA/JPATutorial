package com.getjavajob.service.impl;

import com.getjavajob.entity.person.User;
import com.getjavajob.repository.IDao;
import com.getjavajob.service.IService;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public List<User> fetchAll() {
        return this.iDao.fetchAll();
    }

    @Override
    public User getById(Long id) {
        return this.iDao.getById(id);
    }

    @Override
    @Transactional
    public void insert(User entity) {
        this.iDao.insert(entity);
    }

    private void setDate(User user) {
        user.setInsertTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
    }

    @Override
    @Transactional
    public void deleteAll() {

    }

    @Override
    @Transactional
    public void deleteById(Long id) {

    }

    @Override
    @Transactional
    public void update(User entity) {
        this.iDao.update(entity);
    }
}
