package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Id;

/**
 * Created by nazaria on 3/20/2015.
 */
public class MenuItem extends Model {

    @Id
    @Constraints.Min(1)
    public Long id;



}
