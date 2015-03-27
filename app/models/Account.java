package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Optional;

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

    public Account(Long id, String name, String email, String password, Menu menu) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.menu = menu;
    }

    public static Finder<Long,Account> find = new Finder<>(
            Long.class, Account.class
    );

    public static boolean validate(String email, String password) {
        System.out.println("validate: email" + email + " password: " + password);
        Account account = Account.find.query().where().eq("email", email).findUnique();
        System.out.println("validate:account = " + account);
        return account != null && account.password.equals(password);
    }
    public static Optional<Account> getAccountByEmail(String email)  {
        Account account = Account.find.query().where().eq("email", email).findUnique();
        System.out.println("account = " + account);
        return account != null ? Optional.of( account) : Optional.empty();
    }


}
