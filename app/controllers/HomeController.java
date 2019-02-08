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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        //LOGGER.error("This is an error");

        if (null == home.getName()) {
            return badRequest("Title must be provided");
        }
        LOGGER.debug("entering create home");
        final Home newHome = homeDao.create(home);
        LOGGER.debug("created home");

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
            final Home homee = Json.fromJson(result, Home.class);

            String fromDate1 = homee.getFromDate().toString();
            String toDate1 = homee.getToDate().toString();
            //formatting date in Java using SimpleDateFormat
            DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm");

            String dateObj1;
            String dateObj2;

            try {
                dateObj1 = DATE_FORMAT.format(formatter.parse(fromDate1));
                LOGGER.debug("date  "+dateObj1);
                dateObj2 = DATE_FORMAT.format(formatter.parse(toDate1));
                //home.setFromDate(dateObj1);
                //make use of the date
                LOGGER.debug("from date is " + dateObj1);
                //home.setToDate(dateObj2);
                LOGGER.debug("to date is " + dateObj2);

            } catch (ParseException e) {
                e.printStackTrace();
            }
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
