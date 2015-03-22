package controllers;

import models.Account;
import play.data.Form;
import play.mvc.*;


import views.SignUpFormData;
import views.html.*;

import java.util.List;

public class Application extends Controller {



    public static Result index2() {
        return ok(index2.render());
    }
    public static Result signUp() {
        return ok(signUp.render());
    }

    public static Result createAccount(String account_name) {
        System.out.println("createAccount: account_name = " + account_name);
        Account account = new Account();
        account.name = account_name;
        account.save();
        return ok();
    }

    public static Result getAllAccounts() {
        List<Account> accounts = Account.find.all();
        return ok(all_accounts.render(accounts));
    }


    public static Result postSignUp() {
        System.out.println("Enter Post Index");
        // Get the submitted form data from the request object, and run validation.
        Form<SignUpFormData> formData = Form.form(SignUpFormData.class).bindFromRequest();

        if (formData.hasErrors()) {
            // Don't call formData.get() when there are errors, pass 'null' to helpers instead.
            flash("error", "Please correct errors above.");
            return badRequest();
        }
        else {
            System.out.println("Everything is OK");
            Account account = new Account();
            account.name = formData.get().name;
            account.email= formData.get().email;
            account.password = formData.get().password;
            System.out.println("got " + formData.get().name);
            account.save();
            return ok(index2.render());
        }
    }

}
