package models;

import play.data.validation.Constraints;

import javax.persistence.Id;
import java.util.List;

/**
 * Created by nazaria on 3/20/2015.
 */
public class Menu {

    @Id
    @Constraints.Min(1)
    public Long id;

    public List<MenuSection> sections;
}
