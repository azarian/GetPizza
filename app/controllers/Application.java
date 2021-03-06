package controllers;

import models.Account;
import play.data.Form;
import play.mvc.*;


import views.SignInFormDate;
import views.SignUpFormData;
import views.html.*;

import java.util.List;

public class Application extends Controller {


    @Security.Authenticated(Secured.class)
    public static Result index() {
        System.out.println("index: request().username() = " + request().username());
        return ok(loggedin.render( Account.getAccountByEmail(request().username()).get().name));

    }

    public static Result logout() {
        session().clear();
        return redirect("/login");
    }

    public static Result login() {
        return ok(login.render(Form.form(SignInFormDate.class)));
    }

    public static Result signUp() {
        return ok(signUp.render(Form.form(SignUpFormData.class)));
    }

    public static Result authenticate() {
        Form<SignInFormDate> loginForm = Form.form(SignInFormDate.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            //send the bad form
            System.out.println("Login Failed!");
            return badRequest(login.render(loginForm));
        } else {
            System.out.println("Login Succeed!");
            startSession(loginForm.get().email);
            return redirect("/");
        }
    }

    private static void startSession(String email) {
        session().clear();
        session("email", email);
    }


    public static Result createAccount(String account_name) {
        System.out.println("createAccount: account_name = " + account_name);
        Account account = new Account();
        account.name = account_name;
        account.save();
        return ok();
    }

    @Security.Authenticated(Secured.class)
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
            return badRequest(signUp.render(formData));
        } else {
            System.out.println("Everything is OK");
            Account account = new Account();
            account.name = formData.get().name;
            account.email = formData.get().email;
            account.password = formData.get().password;
            System.out.println("got " + formData.get().name);
            account.save();
            startSession(account.email);
            return redirect("/");
        }
    }

}
