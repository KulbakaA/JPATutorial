package com.getjavajob.repository.impl;

import com.getjavajob.entity.person.User;
import com.getjavajob.repository.IUserDao;

import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("userDaoImpl")
public class UserDao extends AbstractDao<User> implements IUserDao, Serializable, Cloneable {

    @Override
    public String findByEmail() {
        return null;
    }

    @Override
    public List<String> getAllEmails() {
        return null;
    }
}
