package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.io.BaseEncoding;
import controllers.security.Authenticator;
import daos.UserDao;
import models.User;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.RandomStringGenerator;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserController extends Controller {


    private final static Logger.ALogger LOGGER = Logger.of(UserController.class);
    private final static int HASH_ITERATIONS = 100;

    private UserDao userDao;

    @Inject
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public Result registerUser() {

        final JsonNode json = request().body().asJson();
        final User user = Json.fromJson(json, User.class);

        if (null == user.getUsername() ||
                null == user.getEmail()) {
            return badRequest("Missing mandatory parameters");
        }

        final String password = json.get("passwordHash").asText();
        if (null == password) {
            return badRequest("Missing mandatory parameters");
        }

        if (null != userDao.findUserByName(user.getUsername())) {
            return badRequest("User taken");
        }

        final String salt = generateSalt();

        final String hash = generateHash(salt, password, HASH_ITERATIONS);

        user.setHashIterations(HASH_ITERATIONS);
        user.setSalt(salt);
        user.setPasswordHash(hash);
        user.setState(User.State.VERIFIED);
        user.setRole(User.Role.USER);

        userDao.create(user);

        final JsonNode result = Json.toJson(user);

        return ok(result);
    }

    @Transactional
    private String generateSalt() {

        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        LOGGER.debug("salt generated is" + generatedString);

        return generatedString;
    }

    @Transactional
    private String generateHash(String salt, String password, int iterations) {
        try {

            final String contat = salt + ":" + password;
            String Hash = null;

            // TODO Run in a loop x iterations
            // TODO User a better hash function


            final MessageDigest sha = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = sha.digest(contat.getBytes());
            //Hash = BaseEncoding.base16().lowerCase().encode(messageDigest);
            for (int i = 0; i < iterations; i++) {
                // Concatenate the hash bytes with the clearPassword bytes and rehash
                messageDigest = sha.digest(ArrayUtils.addAll(messageDigest, contat.getBytes()));
            }

            final String passwordHash = BaseEncoding.base16().lowerCase().encode(messageDigest);


            LOGGER.debug("Password hash {}", passwordHash);

            return passwordHash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
          }

    }

    @Transactional
    public Result signInUser() {

        final JsonNode json = request().body().asJson();

        final String username = json.get("username").asText();
        final String password = json.get("passwordHash").asText();
        if (null == password || null == username) {
            return badRequest("Missing mandatory parameters");
        }
        //LOGGER.debug("entered signin");
        final User existingUser = userDao.findUserByName(username);
        //LOGGER.debug("user details taken");

        if (null == existingUser) {
            return unauthorized("Wrong username");
        }

        final String salt = existingUser.getSalt();
        final int iterations = existingUser.getHashIterations();
        final String hash = generateHash(salt, password, iterations);

        if (!existingUser.getPasswordHash().equals(hash)) {
            return unauthorized("Wrong password");
        }

        if (existingUser.getState() != User.State.VERIFIED) {
            return unauthorized("Account not verified");
        }

        existingUser.setAccessToken(generateAccessToken());

        userDao.update(existingUser);

        final JsonNode result = Json.toJson(existingUser);

        return ok(result);
    }

    @Transactional
    private String generateAccessToken() {

        int length = 20;
        boolean useLetters = true;
        boolean useNumbers = true;

        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('a', 'z').build();
        String randomLetters = generator.generate(20);
        LOGGER.debug("salt generated is" + randomLetters);

        return randomLetters;

    }


    @Transactional
    @Authenticator
    public Result signOutUser() {

        final User user = (User) ctx().args.get("user");
        user.setAccessToken(null);
        userDao.update(user);

        return ok();
    }

    @Transactional
    @Authenticator
    //@IsAdmin
    public Result getCurrentUser() {

        final User user = (User) ctx().args.get("user");

        final JsonNode result = Json.toJson(user);

        return ok(result);
    }
}
