package controllers;

/**
 * Created by nazaria on 3/25/2015.
 */
import play.mvc.*;
import play.mvc.Http.*;

import models.*;

import java.util.Optional;

public class Secured extends Security.Authenticator {
    @Override
    public String getUsername(Context ctx) {

        Optional<Account> account = Account.getAccountByEmail(ctx.session().get("email"));
        if (account.isPresent()){
            return account.get().email;
        }
        return null;
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect("/login");
    }
}