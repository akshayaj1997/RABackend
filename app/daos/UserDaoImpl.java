package daos;

import models.User;
import play.Logger;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
//import javax.inject.Singleton;
import javax.persistence.Id;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

//@Singleton
public class UserDaoImpl implements UserDao {
    private final static Logger.ALogger LOGGER = Logger.of(UserDaoImpl.class);

    final JPAApi jpaApi;

    @Inject
    public UserDaoImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    public User create(User user){
        //TO DO
        if (null == user){
            throw new IllegalArgumentException("user must be provided");
        }
        jpaApi.em().persist(user);
        return user;
    }

    public Optional<User> read(Integer id) {

        if(null == id){
            throw new IllegalArgumentException("id must be provided");
        }
        final User user = jpaApi.em().find(User.class,id);
        return user != null ? Optional.of(user) : Optional.empty();

    }

    public User update(User user){

        if(null == user){
            throw new IllegalArgumentException("user deos not exit");
        }

        if(null == user.getId()){
            throw new IllegalArgumentException("Id must be provided");
        }

        final User existingUser = jpaApi.em().find(User.class,user.getId());
        if(null == existingUser){
            throw new IllegalArgumentException("Invalid user");
        }
        existingUser.setUsername(user.getUsername());
        existingUser.setAccessToken(user.getAccessToken());
        existingUser.setPasswordHash(user.getPasswordHash());

        jpaApi.em().persist(existingUser);
       return existingUser;
    }
    public User delete(Integer Id) {

        if(null == Id) {
            throw new IllegalArgumentException("Home Id must be provided");
        }

        final User exisitinguser= jpaApi.em().find(User.class, Id);
        if(null == exisitinguser) {
            return null;
        }

        jpaApi.em().remove(exisitinguser);
        return exisitinguser;

    }
    public Collection<User> all() {

        TypedQuery<User> query = jpaApi.em().createQuery("SELECT h FROM Home h", User.class);
        List<User> users = query.getResultList();

        return users;
    }


    @Override
    public Collection<User> createUsers(Collection<User> userItems) {
        for(User item: userItems){
            jpaApi.em().persist(item);
        }
        return userItems;
    }
    @Override
    public User findUserByName(String name) {
        User user = null;
        try {
            TypedQuery<User> query = jpaApi.em().createQuery("SELECT u from User u WHERE  username = '" + name + "'", User.class);
            user = query.getSingleResult();
        }
        catch(NoResultException nre){

        }

        if(null == user){
            return null;
        }

        return user;
    }

    @Override
    public User findUserByAuthToken(String aToken) {
        User user = null;
        LOGGER.debug("Access token at find by level is:" + aToken);
        try {
            //LOGGER.debug("accessToken at find by level" + authToken);
            TypedQuery<User> query = jpaApi.em().createQuery("SELECT u from User u WHERE  u.accessToken = '" + aToken +"' ", User.class);
            LOGGER.debug("queried");
            user = query.getSingleResult();
            LOGGER.debug("fetched query result to user");
        }
        catch(NoResultException nre){
            throw new IllegalArgumentException("Sign in to complete the action");
        }
        return user;
    }
}
