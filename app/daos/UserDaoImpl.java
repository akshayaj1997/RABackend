package daos;

import models.User;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

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
}
