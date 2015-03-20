package controllers;

import models.Account;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.AccountFormDate;
import views.html.*;

import java.util.List;

public class Application extends Controller {

    public static Result index() {
        AccountFormDate accountFormDate = new AccountFormDate();
        Form<AccountFormDate> form = Form.form(AccountFormDate.class).fill(accountFormDate);
        return ok(index.render(form,""));
    }

    public static Result index2() {
        return ok(index2.render());
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

    public static Result postIndex() {
        System.out.println("Enter Post Index");
        // Get the submitted form data from the request object, and run validation.
        Form<AccountFormDate> formData = Form.form(AccountFormDate.class).bindFromRequest();

        if (formData.hasErrors()) {
            // Don't call formData.get() when there are errors, pass 'null' to helpers instead.
            flash("error", "Please correct errors above.");
            return badRequest(index.render(formData,""));
        }
        else {
            System.out.println("Everything is OK");
            Account account = new Account();
            account.name = formData.get().name;
            account.save();
            return ok();
        }
    }

}
