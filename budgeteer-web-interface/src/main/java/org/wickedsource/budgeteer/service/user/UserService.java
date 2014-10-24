package org.wickedsource.budgeteer.service.user;

import org.springframework.stereotype.Service;
import org.wickedsource.budgeteer.web.pages.user.login.InvalidLoginCredentialsException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    /**
     * Returns a list of all users that currently have access to the given project.
     *
     * @param projectId ID of the project whose users to load.
     * @return list of all users with access to the given project.
     */
    public List<User> getUsersInProject(long projectId) {
        List<User> users = new ArrayList<User>();
        for (int i = 1; i <= 5; i++) {
            User user = new User();
            user.setId(i);
            user.setName("User " + i);
            users.add(user);
        }
        return users;
    }

    /**
     * Returns a list of all users that currently DO NOT have access to the given project.
     *
     * @param projectId ID of the project
     * @return list of all users that currently DO NOT have access to the given project.
     */
    public List<User> getUsersNotInProject(long projectId) {
        return getUsersInProject(projectId);
    }

    /**
     * Removes the the access of the given user to the given project.
     *
     * @param projectId ID of the project for which to remove access
     * @param userId    ID of the user whose access to remove.
     */
    public void removeUserFromProject(long projectId, long userId) {

    }

    /**
     * Deletes the given project and all its data from the database.
     *
     * @param projectId ID of the project to delete.
     */
    public void deleteProject(long projectId) {

    }

    /**
     * Adds the given user to the given project so that this user now has access to it.
     *
     * @param projectId ID of the project.
     * @param id        ID of the user.
     */
    public void addUserToProject(long projectId, long id) {

    }

    /**
     * Checks a users login credentials.
     *
     * @param username username of the user to login
     * @param password plain text password of the user to login
     * @return a User object of the logged in user on successful login.
     * @throws InvalidLoginCredentialsException in case of invalid credentials
     */
    public User login(String username, String password) throws InvalidLoginCredentialsException {
        User user = new User();
        user.setName("username");
        user.setId(1l);
        return user;
    }

    /**
     * Registers a new user to the Budgeteer application.
     *
     * @param username the users name
     * @param password the users password
     */
    public void registerUser(String username, String password) {

    }
}