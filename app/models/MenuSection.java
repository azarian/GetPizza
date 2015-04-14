package models;

import play.db.ebean.Model;

import java.util.List;

/**
 * Created by nazaria on 3/20/2015.
 */
public class MenuSection extends Model {

    List<MenuItem> items;
}
