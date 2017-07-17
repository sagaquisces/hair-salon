import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class StylistTest {
  String testDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

  String anotherTestDescription = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?";

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Joe", "Styles", "joe@styles.com", testDescription);
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getFirstName_stylistInstantiatesWithFirstName_Henry() {
    Stylist testStylist = new Stylist("Joe", "Styles", "joe@styles.com", testDescription);
    assertEquals("Joe", testStylist.getFirstName());
  }

  @Test
  public void getLastName_stylistInstantiatesWithLastName_Henry() {
    Stylist testStylist = new Stylist("Joe", "Styles", "joe@styles.com", testDescription);
    assertEquals("Styles", testStylist.getLastName());
  }

  @Test
  public void getEmail_stylistInstantiatesWithEmail_String() {
    Stylist testStylist = new Stylist("Joe", "Styles", "joe@styles.com", testDescription);
    assertEquals("joe@styles.com", testStylist.getEmail());
  }

  @Test
  public void equals_returnsTrueIfFirstNameLastNameEmailDescriptionAreSame_true() {
    Stylist aStylist = new Stylist("Joe", "Styles", "joe@styles.com", testDescription);
    Stylist anotherStylist = new Stylist("Joe", "Styles", "joe@styles.com", testDescription);
    assertTrue(aStylist.equals(anotherStylist));
  }

  @Test
  public void save_insertsObjectIntoDatabase_Stylist() {
    Stylist testStylist = new Stylist("Joe", "Styles", "joe@styles.com", testDescription);
    testStylist.save();
    assertTrue(Stylist.all().get(0).equals(testStylist));
  }

  @Test
  public void all_returnsAllInstancesOfStylist_true() {
    Stylist firstStylist = new Stylist("Joe", "Styles", "joe@styles.com", testDescription);
    firstStylist.save();
    Stylist secondStylist = new Stylist("Harry", "Horses", "harry@horses.com", anotherTestDescription);
    secondStylist.save();
    assertEquals(true, Stylist.all().get(0).equals(firstStylist));
    assertEquals(true, Stylist.all().get(1).equals(secondStylist));
  }

  @Test
  public void save_assignsIdToObject() {
    Stylist testStylist = new Stylist("Joe", "Styles", "joe@styles.com", testDescription);
    testStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(testStylist.getId(), savedStylist.getId());
  }

  @Test
  public void find_returnsStylistWithSameId_secondStylist() {
    Stylist firstStylist = new Stylist("Joe", "Styles", "joe@styles.com", testDescription);
    firstStylist.save();
    Stylist secondStylist = new Stylist("Harry", "Horses", "harry@horses.com", anotherTestDescription);
    secondStylist.save();
    assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
  }

  @Test
  public void getClients_retrievesAllClientsFromDatabase_clientsList() {
    Stylist testStylist = new Stylist("Joe", "Styles", "joe@styles.com", testDescription);
    testStylist.save();
    Client firstClient = new Client("Hegre", "Phineas", "h@p.com", testStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Michael", "Smith", "m@s.com", testStylist.getId());
    secondClient.save();
    Client[] clients = new Client[] { firstClient, secondClient };
    assertTrue(testStylist.getClients().containsAll(Arrays.asList(clients)));
  }

  @Test
  public void update_updatesStylistFirstName_true() {
    Stylist testStylist = new Stylist("Joe", "Styles", "joe@styles.com", testDescription);
    testStylist.save();
    testStylist.update("Frankie", "Styles", "joe@styles.com", testDescription);
    assertEquals("Frankie", Stylist.find(testStylist.getId()).getFirstName());
  }

  @Test
  public void delete_deletesStylist_true() {
    Stylist myStylist = new Stylist("Joe", "Styles", "joe@styles.com", testDescription);
    myStylist.save();
    int myStylistId = myStylist.getId();
    myStylist.delete(0);
    assertEquals(null, Stylist.find(myStylistId));
  }

  @Test
  public void delete_willGiveClientsToOtherStylist_2() {
    Stylist firstStylist = new Stylist("Joe", "Styles", "joe@styles.com", testDescription);
    firstStylist.save();
    Stylist secondStylist = new Stylist("Harry", "Horses", "harry@horses.com", anotherTestDescription);
    secondStylist.save();
    Client firstClient = new Client("Hegre", "Phineas", "h@p.com", firstStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Michael", "Smith", "m@s.com", firstStylist.getId());
    secondClient.save();
    firstStylist.delete(secondStylist.getId());
    assertEquals(2, secondStylist.getClients().size());
  }

}
