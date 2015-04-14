package controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Course;
import models.GeneralCourse;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;


/**
 * Created by nazaria on 4/14/2015.
 */
public class CourseAPI extends Controller {

    @Security.Authenticated(Secured.class)
      public static Result createGeneralCourse(String name, String description) {
        GeneralCourse generalCourse = new GeneralCourse(name, description);
        generalCourse.save();
        System.out.println("created generalCourse with ID: " + generalCourse.id);
        return ok();
    }
    @Security.Authenticated(Secured.class)
    public static Result updateGeneralCourse(Long id,String name, String description) {
        GeneralCourse generalCourse = GeneralCourse.find.byId(id);
        generalCourse.name = name;
        generalCourse.description=description;
        generalCourse.save();
        System.out.println("update generic course. ");
        return ok();
    }


    @Security.Authenticated(Secured.class)
    public static Result getCourse(long id) {
        Course course = Course.find.byId(id);
        return ok(Json.toJson(course));
    }

    public static Result getCourses() {
        return  ok(Json.toJson(Course.find.all()));
    }
    @Security.Authenticated(Secured.class)
    public static Result deleteCourse(long id) {
        Course.find.byId(id).delete();
        return ok();
    }
}
