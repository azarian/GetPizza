package views;

import models.Account;
import play.data.validation.Constraints;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nazaria on 3/25/2015.
 */
public class SignInFormDate {

    @Constraints.Required
    public String email = "";
    @Constraints.Required
    public String password = "";


    public String validate() {
        if (!Account.validate(email,password)){
            return "Invalid user or uassword";
        }
        return null;
    }
}

