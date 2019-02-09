package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import daos.AmenitiesDao;
import daos.HomeDao;
import models.Amenities;
import models.Home;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Optional;

public class AmenitiesController extends Controller {
    private final static Logger.ALogger LOGGER = Logger.of(controllers.AmenitiesController.class);
    final AmenitiesDao amenitiesDao;

    @Inject
    public AmenitiesController(AmenitiesDao amenitiesDao) {
        this.amenitiesDao = amenitiesDao;
    }


    @Transactional
    public Result createAmenities() {

        final JsonNode json = request().body().asJson();
        final Amenities amenities = Json.fromJson(json, Amenities.class);

        if (null == amenities.getId()) {
            return badRequest("Id must be provided");
        }
        //LOGGER.debug("entering create home");
        final Amenities newAmenities = amenitiesDao.create(amenities);
        //LOGGER.debug("created home");

        final JsonNode result = Json.toJson(newAmenities);

        return ok(result);


    }

    @Transactional
    public Result getAmenititesById(Integer id) {

        if (null == id) {
            return badRequest("Id must be provided");
        }

        final Optional<Amenities> amenities = amenitiesDao.read(id);
        if (amenities.isPresent()) {
            final JsonNode result = Json.toJson(amenities.get());
            return ok(result);
        } else {
            return notFound();
        }


    }

    @Transactional
    public Result updateAmenitiesById(Integer id) {
        LOGGER.debug("entered update home by id");

        if (null == id) {
            return badRequest("Id must be provided");
        }

        final JsonNode json = request().body().asJson();
        final Amenities newAmenities = Json.fromJson(json, Amenities.class);

        newAmenities.setId(id);

        final Amenities updatedAmenities = amenitiesDao.update(newAmenities);

        final JsonNode result = Json.toJson(updatedAmenities);
        return ok(result);

    }

    @Transactional
    public Result deleteHomeById(Integer id) {

        if (null == id) {
            return badRequest("Id must be provided");
        }

        final Amenities amenities = amenitiesDao.delete(id);

        final JsonNode result = Json.toJson(amenities);
        return ok(result);
    }

    @Transactional
    public Result getAllAmenities() {

        Collection<Amenities> amenities = amenitiesDao.all();

        final JsonNode result = Json.toJson(amenities);
        return ok(result);
    }
}
