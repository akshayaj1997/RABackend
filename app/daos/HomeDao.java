package daos;

import models.Home;

import java.util.Collection;

public interface HomeDao extends CrudDao<Home,Integer> {
    Collection<Home> createHomes(Collection<Home> homeItems);

}
