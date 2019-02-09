package daos;

import models.Amenities;
import play.Logger;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class AmenitiesDaoImpl implements AmenitiesDao {

    private final static Logger.ALogger LOGGER = Logger.of(daos.AmenitiesDaoImpl.class);

    final JPAApi jpaApi;

    @Inject
    public AmenitiesDaoImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    @Override
    public Amenities create(Amenities amenities) {
        if(null == amenities){
            throw new IllegalArgumentException("Amenities must be provided");
        }
        jpaApi.em().persist(amenities);
        return amenities;
    }

    @Override
    public Optional<Amenities> read(Integer id) {
        if(null == id){
            throw new IllegalArgumentException("id must be provided");
        }
       final Amenities amenities = jpaApi.em().find(Amenities.class,id);

        return amenities != null ? Optional.of(amenities) : Optional.empty();
    }

    @Override
    public Amenities update(Amenities amenities) {
        if(null == amenities){
            throw new IllegalArgumentException("Amenities must be provided");
        }
        if(null == amenities.getId()){
            throw new IllegalArgumentException("Home Id must be provided");
        }

        final Amenities existingAmenities = jpaApi.em().find(Amenities.class, amenities.getId());
        if(null == existingAmenities) {
            return null;
        }
        existingAmenities.setAirconditioner(amenities.setAirconditioner());
        existingAmenities.setHeater(amenities.getHeater());
        existingAmenities.setWIFI(amenities.getWIFI());
        existingAmenities.setPool(amenities.getPool());
        existingAmenities.setKitchen(amenities.getKitchen());

        jpaApi.em().persist(existingAmenities);

        return existingAmenities;

    }

    @Override
    public Amenities delete(Integer id) {

        if(null == id){
            throw new IllegalArgumentException("Id mst be provided");
        }
        final Amenities amenities = jpaApi.em().find(Amenities.class,id);

        if(null == amenities){
            throw new IllegalArgumentException("Amenities not found");
        }
        jpaApi.em().remove(amenities);
        return null;
    }

    @Override
    public Collection<Amenities> all() {
        TypedQuery<Amenities> query = jpaApi.em().createQuery("select A from Amenities A", Amenities.class);
        List<Amenities> amenities =query.getResultList();
        return amenities;
    }

    @Override
    public Collection<Amenities> createHomes(Collection<Amenities> amenitiesItems) {
        for(Amenities item: amenitiesItems){
            jpaApi.em().persist(item);
        }
        return amenitiesItems;
    }
}
