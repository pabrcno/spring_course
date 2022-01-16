package com.github.pabrcno.be_project.domain.users;

public interface IUsersDao {
    User[] getAllUsers();
    void addUser(User user);
}
