package com.github.pabrcno.be_project.app.users;

import com.github.pabrcno.be_project.domain.users.IUsersDao;
import com.github.pabrcno.be_project.domain.users.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/v1/users")
@RestController
public class UsersController {
    
    private final IUsersDao usersDao;

    @Autowired
    public UsersController(IUsersDao usersDao) {
        this.usersDao = usersDao;
    }
    @GetMapping()
    public User[] getAllUsers() {
        return usersDao.getAllUsers();
    }
    @PostMapping
    public void addUser(@RequestBody User user ) {
        usersDao.addUser(user);
    }

}
