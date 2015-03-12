package views;

import play.data.validation.ValidationError;

import java.util.List;

/**
 * Created by nazaria on 3/12/2015.
 */
public class AccountFormDate {

    public String name = "";

    public AccountFormDate() {
    }

    public AccountFormDate(String name) {
        this.name = name;
    }

    public List<ValidationError> validate() {
        return null;
    }
}
