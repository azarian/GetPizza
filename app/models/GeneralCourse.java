package models;

import javax.persistence.Lob;

/**
 * Created by nazaria on 3/20/2015.
 */
public class GeneralCourse extends Course{
    public String name;
    public String description;
    @Lob
    public byte[] image;
}
