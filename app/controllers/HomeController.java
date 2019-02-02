package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import daos.HomeDao;
import models.Home;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.*;

public class HomeController extends Controller {

    private final static Logger.ALogger LOGGER = Logger.of(controllers.HomeController.class);

    final HomeDao homeDao;

    @Inject
    public HomeController(HomeDao homeDao) {
        this.homeDao = homeDao;
    }


    @Transactional
    public Result createHome() {

        final JsonNode json = request().body().asJson();
        final Home home = Json.fromJson(json, Home.class);

        LOGGER.debug("Home title = " + home.getName());
        LOGGER.error("This is an error");

        if (null == home.getName()) {
            return badRequest("Title must be provided");
        }

        final Home newHome = homeDao.create(home);

        final JsonNode result = Json.toJson(newHome);

        return ok(result);

    }

    @Transactional
    public Result getHomeById(Integer id) {

        if (null == id) {
            return badRequest("Id must be provided");
        }

        final Optional<Home> home = homeDao.read(id);
        if (home.isPresent()) {
            final JsonNode result = Json.toJson(home.get());
            return ok(result);
        } else {
            return notFound();
        }
    }

    @Transactional
    public Result updateHomeById(Integer id) {
        LOGGER.debug("entered update home by id");

        if (null == id) {
            return badRequest("Id must be provided");
        }

        final JsonNode json = request().body().asJson();
        final Home newHome = Json.fromJson(json, Home.class);

        newHome.setId(id);

        final Home updatedHome = homeDao.update(newHome);

        final JsonNode result = Json.toJson(updatedHome);
        return ok(result);
    }

    @Transactional
    public Result deleteHomeById(Integer id) {

        if (null == id) {
            return badRequest("Id must be provided");
        }

        final Home home = homeDao.delete(id);

        final JsonNode result = Json.toJson(home);
        return ok(result);
    }

    @Transactional
    public Result getAllHomes() {

        Collection<Home> homes = homeDao.all();

        final JsonNode result = Json.toJson(homes);
        return ok(result);
    }
}
