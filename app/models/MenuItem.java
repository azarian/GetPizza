package models;

import play.data.validation.Constraints;

import javax.persistence.Id;

/**
 * Created by nazaria on 3/20/2015.
 */
public class MenuItem {

    @Id
    @Constraints.Min(1)
    public Long id;



}
