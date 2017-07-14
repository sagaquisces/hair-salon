import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class ClientTest {

  String testDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void client_instantiatesCorrectly_true() {
    Client testClient = new Client("Hegre", "Phineas", "h@p.com", 1);
    assertEquals(true, testClient instanceof Client);
  }

  @Test
  public void Client_instantiatesWithFirstName_String() {
    Client testClient = new Client("Hegre", "Phineas", "h@p.com", 1);
    assertEquals("Hegre", testClient.getFirstName());
  }

  @Test
  public void Client_instantiatesWithLastName_String() {
    Client testClient = new Client("Hegre", "Phineas", "h@p.com", 1);
    assertEquals("Phineas", testClient.getLastName());
  }

  @Test
  public void Client_instantiatesWithEmail_String() {
    Client testClient = new Client("Hegre", "Phineas", "h@p.com", 1);
    assertEquals("h@p.com", testClient.getEmail());
  }

  @Test
  public void Client_instantiatesWithStylistId_int() {
    Client testClient = new Client("Hegre", "Phineas", "h@p.com", 1);
    assertEquals(1, testClient.getStylistId());
  }

  @Test
  public void equals_returnsTrueIfFirstNameLastNameEmailAndStylistIdAreSame_true() {
    Client testClient = new Client("Hegre", "Phineas", "h@p.com", 1);
    Client anotherClient = new Client("Hegre", "Phineas", "h@p.com", 1);
    assertTrue(testClient.equals(anotherClient));
  }

  @Test
  public void save_returnsTrueIfDescriptionsAretheSame() {
    Client testClient = new Client("Hegre", "Phineas", "h@p.com", 1);
    testClient.save();
    assertTrue(Client.all().get(0).equals(testClient));
  }

  @Test
  public void all_returnsAllInstancesOfClient_true() {
    Client firstClient = new Client("Hegre", "Phineas", "h@p.com", 1);
    firstClient.save();
    Client secondClient = new Client("Michael", "Smith", "m@s.com", 1);
    secondClient.save();
    assertEquals(true, Client.all().get(0).equals(firstClient));
    assertEquals(true, Client.all().get(1).equals(secondClient));
  }

  @Test
  public void find_returnsClientsWithSameId_secondClient() {
    Client firstClient = new Client("Hegre", "Phineas", "h@p.com", 1);
    firstClient.save();
    Client secondClient = new Client("Michael", "Smith", "m@s.com", 1);
    secondClient.save();
    assertEquals(Client.find(secondClient.getId()), secondClient);
  }

  @Test
  public void save_savesStylistIdIntoDB_true() {
    Stylist testStylist = new Stylist("Joe", "Styles", "joe@styles.com", testDescription);
    testStylist.save();
    Client testClient = new Client("Hegre", "Phineas", "h@p.com", testStylist.getId());
    testClient.save();
    Client savedClient = Client.find(testClient.getId());
    assertEquals(savedClient.getStylistId(), testStylist.getId());
  }

}
