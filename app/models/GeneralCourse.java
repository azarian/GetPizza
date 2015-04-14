package models;

import play.db.ebean.Model;

import javax.persistence.Lob;

/**
 * Created by nazaria on 3/20/2015.
 */
public class GeneralCourse extends Course{
    public String name;
    public String description;
    @Lob
    public byte[] image;

    public GeneralCourse() {
    }

    public GeneralCourse(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static Model.Finder<Long,GeneralCourse> find = new Model.Finder<>(
            Long.class, GeneralCourse.class
    );
}
