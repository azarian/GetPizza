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


    public List<ValidationError> validate() {
        if (!Account.validate(email,password)){
            ArrayList<ValidationError> validationErrors = new ArrayList<>();
            validationErrors.add(new ValidationError("Invalid user or uassword",""));
            return validationErrors;
        }
        return null;
    }
}

