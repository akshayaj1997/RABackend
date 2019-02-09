package daos;

import models.Amenities;

import java.util.Collection;

public interface AmenitiesDao extends CrudDao<Amenities,Integer> {

    Collection<Amenities> createHomes(Collection<Amenities> homeItems);
}
