package com.leti.project.services.UsersService;

import com.leti.project.dao.daos.UserDao;
import com.leti.project.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsersServiceImpl implements UsersService {

    private UserDao userDao;


    public UserEntity getUserById(final Long id) {
        return userDao.getUserByID(id);
    }

    public void hi() {
        System.out.println("hi");
    }

}
