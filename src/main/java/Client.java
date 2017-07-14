public class Client {
  private String firstname;
  private String lastname;
  private String email;
  private int stylistId;

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

}
