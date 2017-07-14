import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Client {
  private String firstname;
  private String lastname;
  private String email;
  private int stylistId;
  private int id;

  public Client(String firstname, String lastname, String email, int stylistId) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.stylistId = stylistId;
  }

  public String getFirstName() {
      return firstname;
  }

  public String getLastName() {
      return lastname;
  }

  public String getEmail() {
      return email;
  }

  public int getStylistId() {
      return stylistId;
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object otherClient){
    if (!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getFirstName().equals(newClient.getFirstName()) &&
             this.getLastName().equals(newClient.getLastName()) &&
             this.getEmail().equals(newClient.getEmail()) &&
             this.getStylistId() == newClient.getStylistId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (firstname, lastname, email, stylistid) VALUES (:firstname, :lastname, :email, :stylistId)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("firstname", this.firstname)
        .addParameter("lastname", this.lastname)
        .addParameter("email", this.email)
        .addParameter("stylistId", this.stylistId)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Client> all() {
    String sql = "SELECT * FROM clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where id=:id";
      Client client = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
      return client;
    }
  }

  

}
