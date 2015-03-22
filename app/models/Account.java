package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by nazaria on 2/28/2015.
 */
@Entity
public class Account extends Model {

    @Id
    @Constraints.Min(1)
    public Long id;

    @Constraints.Required
    public String name;
    @Constraints.Required
    public String email;
    @Constraints.Required
    public String password;


    public Menu menu;


    public Account() {
    }

    public static Finder<Long,Account> find = new Finder<>(
            Long.class, Account.class
    );

}
