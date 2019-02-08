package daos;

import daos.HomeDao;
import models.Home;
import play.Logger;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
//import java.util.Optional;

public class HomeDaoImpl implements HomeDao {
    private final static Logger.ALogger LOGGER = Logger.of(daos.HomeDaoImpl.class);

    final JPAApi jpaApi;

    @Inject
    public HomeDaoImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    public Home create(Home home){

        if(null == home) {
            throw new IllegalArgumentException("Home must be provided");
        }


        jpaApi.em().persist(home);
        return home;
    }

    public Optional<Home> read(Integer Id) {

        if (null == Id) {
            throw new IllegalArgumentException("Id must be provided");
        }

        final Home home = jpaApi.em().find(Home.class, Id);

        return home != null ? Optional.of(home) : Optional.empty();

    }

    public Home update(Home home) {

        if(null == home) {
            throw new IllegalArgumentException("Home must be provided");
        }

        if(null == home.getId()){
            throw new IllegalArgumentException("Home Id must be provided");
        }

        final Home existingHome = jpaApi.em().find(Home.class, home.getId());
        if(null == existingHome) {
            return null;
        }
        existingHome.setLocation(home.getLocation());

        jpaApi.em().persist(existingHome);

        return existingHome;
    }

    public Home delete(Integer Id) {

        if(null == Id) {
            throw new IllegalArgumentException("Home Id must be provided");
        }

        final Home existingHome= jpaApi.em().find(Home.class, Id);
        if(null == existingHome) {
            return null;
        }

        jpaApi.em().remove(existingHome);
        return existingHome;

    }

    public Collection<Home> all() {

        TypedQuery<Home> query = jpaApi.em().createQuery("SELECT h FROM Home h", Home.class);
        List<Home> homes = query.getResultList();

        return homes;
    }


    @Override
    public Collection<Home> createHomes(Collection<Home> homeItems) {



        for(Home item: homeItems){
            jpaApi.em().persist(item);
        }


        return homeItems;
    }
}