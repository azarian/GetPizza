package views;

import models.Account;
import play.data.validation.ValidationError;

import java.util.List;
import java.util.Optional;

/**
 * Created by nazaria on 3/22/2015.
 */
public class SignUpFormData {

    public String name = "";
    public String email = "";
    public String password = "";

    public SignUpFormData() {
    }

    public SignUpFormData(String name, String email, String password ) {
        this.name = name;
        this.email = email;
        this.password  = password ;
    }

    public String validate() {
        Optional<Account> account = Account.getAccountByEmail(email);
        if (account.isPresent()){
            return "An account with email " + email + " already exist!";
        }
        return null;
    }
}
