package com.github.pabrcno.be_project.infrastructure.users;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.github.pabrcno.be_project.domain.core.FirstApplicationException;
import com.github.pabrcno.be_project.domain.users.IUsersDao;
import com.github.pabrcno.be_project.domain.users.User;

import org.springframework.stereotype.Repository;

@Repository("fakeUsersDao")
public class FakeUsersDao implements IUsersDao {
    
    private static List<User> users = new ArrayList<User>();

    @Override
    public User[] getAllUsers() {
        return users.toArray(new User[users.size()]);
    }

    @Override
    public void addUser(User user) {
                if (user == null) {
                throw new FirstApplicationException("User is null");
            }
    
            if (user.getUsername() == null || user.getUsername().isEmpty()) {
                throw new FirstApplicationException("User name is null");
            }
    
            if (user.getPassword() == null || user.getPassword().isEmpty()) {
                throw new FirstApplicationException("User password is null");
            }
            if( users.stream().filter(u -> u.getUsername().equals(user.getUsername())).count() > 0 ){
                throw new FirstApplicationException("User already exists");
            }
                users.add(user);
        }

    @Override
    public User getUserByName(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
    }

    @Override
    public User getUserById(UUID id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }   
}
    

