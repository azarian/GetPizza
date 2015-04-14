package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Id;

/**
 * Created by nazaria on 3/20/2015.
 */
public class Course extends Model {
    @Id
    @Constraints.Min(1)
    public Long id;

    public static Model.Finder<Long,Course> find = new Model.Finder<>(
            Long.class, Course.class
    );
}
