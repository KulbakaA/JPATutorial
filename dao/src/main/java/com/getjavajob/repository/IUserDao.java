package com.getjavajob.repository;

import java.util.List;

public interface IUserDao {

    String findByEmail();
    List<String> getAllEmails();

}
