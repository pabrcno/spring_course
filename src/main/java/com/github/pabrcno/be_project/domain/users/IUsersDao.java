package com.github.pabrcno.be_project.domain.users;

import java.util.UUID;

public interface IUsersDao {
    User[] getAllUsers();
    void addUser(User user);
    User getUserByName(String username);
    User getUserById(UUID id);
}
