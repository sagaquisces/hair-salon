import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class ClientTest {

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

}
