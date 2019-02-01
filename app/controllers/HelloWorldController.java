package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.Controller;
import play.mvc.Result;

public class HelloWorldController extends Controller {

    public Result helloWorld() {

        return ok("ok");
    }

    public Result helloNidhi(){

        return ok("HelloNidhi");
    }

    public Result hello(String name){

        return ok("Hello" + name + "!");
    }

    public Result hellos(String name,Integer count){

        final StringBuffer sb = new StringBuffer();
        sb.append("Hello");

        for(int i=0; i < count; i++){

            sb.append(" " + name + " ");
        }

        sb.append("!");

        return ok(sb.toString());
    }


 public Result greetings() {

     final JsonNode jsonNode = request().body().asJson();
     final String firstName = jsonNode.get("firstName").asText();
     final String lastName = jsonNode.get("lastName").asText();

     final Person person = play.libs.Json.fromJson(jsonNode, Person.class);

     return ok("Greetings " + person.firstName + " " + person.lastName);

    }




    static class Person {

        String firstName;

        String lastName;


        public Person() {

        }

        public String getFirstName() {

            return firstName;
        }

        public void setFirstName(String firstName) {

            this.firstName = firstName;
        }

        public String getLastName() {

            return lastName;
        }

        public void setLastName(String lastName) {

            this.lastName = lastName;
        }

        public Person(String firstName, String lastName) {

            this.firstName = firstName;
            this.lastName = lastName;
        }


        }
    }

