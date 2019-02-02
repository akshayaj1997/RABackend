package daos;

import models.User;

import java.util.Collection;

public interface UserDao extends CrudDao<User,Integer> {
    Collection<User> createUsers(Collection<User> userItems);
    User findUserByName(String username);
    User findUserByAuthToken(String authToken);
}
