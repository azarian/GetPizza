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

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static play.test.Helpers.*;

public class AccountTest {


    private static FakeApplication fakeApplication;
    private static  DdlGenerator ddl;
    private static EbeanServer server;

    @BeforeClass
    public static void beforeClass() throws Exception {
        fakeApplication = fakeApplication(inMemoryDatabase());
        start(fakeApplication);
        server = Ebean.getServer("default");

        ServerConfig config = new ServerConfig();

        ddl = new DdlGenerator();
        ddl.setup((SpiEbeanServer) server,new H2Platform(),config);

    }

    @AfterClass
    public static void afterClass() throws Exception {
        stop(fakeApplication);
    }
    @Before
    public void resetDb() throws IOException {

        // drop
        String dropScript = ddl.generateDropDdl();
        ddl.runScript(false, dropScript);

        // create
        String createScript = ddl.generateCreateDdl();
        ddl.runScript(false, createScript);

        // insert data
        Account account = new Account(1L,"TestAccount1");
        Ebean.save(account);


    }

    @Test
    public void findById() {
        Account account = Account.find.byId(1L);
        assertThat(account.id, equalTo(1L));
    }

    @Test
    public void findAll() {
       /* List budgets = Budget.find.all();
        assertThat(budgets).isNotNull();
        assertThat(budgets.size()).isEqualTo(2);*/
    }

    @Test
    public void insert() {

       /* Long lastId = getLastId();

        Budget budget = new Budget();
        budget.name = "test budget";
        budget.createDate = new Date();
        budget.save();

        Budget savedBudget = Budget.find.byId(lastId + 1);
        assertThat(savedBudget.id).isNotNull();
        assertThat(savedBudget.createDate).isNotNull();
        assertThat(savedBudget.name).isNotNull();
        assertThat(savedBudget.name).isEqualTo("test budget");*/
    }

    @Test
    public void delete() {
       /* Long lastId = getLastId();

        int oldCount = Budget.find.all().size();

        Budget existingBudget = Ebean.find(Budget.class, lastId);
        Ebean.delete(existingBudget);

        int currentCount = Budget.find.all().size();

        assertThat(currentCount).isEqualTo(oldCount - 1);*/
    }

    @Test
    public void updateSimple() {

       /* Long lastId = getLastId();

        Budget existingBudget = Ebean.find(Budget.class, lastId);

        String newName = existingBudget.name + "foo";
        existingBudget.setName(newName);

        Ebean.update(existingBudget);

        Budget updatedBudget = Ebean.find(Budget.class, lastId);
        assertThat(updatedBudget.id).isEqualTo(lastId);
        assertThat(updatedBudget.name).isEqualTo(newName);*/
    }


    @Test
    public void updateViaSql() {

       /* Long lastId = getLastId();

        Budget existingBudget = Budget.find.byId(lastId);
        String existingName = existingBudget.name;

        String newName = existingName + "foo";

        Ebean.createSqlUpdate("update budget set name = :newName where id = :id")
                .setParameter("newName", newName)
                .setParameter("id", lastId)
                .execute();

        Budget updatedBudget = Budget.find.byId(lastId);
        assertThat(updatedBudget.id).isEqualTo(lastId);
        assertThat(updatedBudget.name).isEqualTo(newName);*/
    }

    private Long getLastId() {
       /* return (Long) Budget.find.orderBy("id desc").findIds().get(0);*/
        return null;
    }
}
