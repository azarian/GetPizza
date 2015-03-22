package views;

import play.data.validation.ValidationError;

import java.util.List;

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

    public List<ValidationError> validate() {
        return null;
    }
}
