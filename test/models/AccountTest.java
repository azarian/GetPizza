package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.H2Platform;
import com.avaje.ebeaninternal.api.SpiEbeanServer;
import com.avaje.ebeaninternal.server.ddl.DdlGenerator;

import org.junit.*;
import play.test.FakeApplication;
import play.test.Helpers;
import play.test.WithApplication;

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static play.test.Helpers.*;

public class AccountTest extends WithApplication {


    private static FakeApplication fakeApplication;
    private static  DdlGenerator ddl;
    private static EbeanServer server;





    @Test
    public void findById() {
        Account account = new Account(1L,"TestAccount1");
        account.save();
        Account account2 = Account.find.byId(1L);
        assertThat(account2.id, equalTo(1L));
    }

    @Test
    public void findAll() {

    }

    @Test
    public void insert() {

    }

    @Test
    public void delete() {

    }

    @Test
    public void updateSimple() {
    }


    @Test
    public void updateViaSql() {


    }

    private Long getLastId() {
        return null;
    }
}
