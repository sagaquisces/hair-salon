import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

  public static void main(String[] args) {

    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl" );
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      model.put("stylists", Stylist.all());
      model.put("newStylist", false); // did not end up here via form
      model.put("deletedStylist", false);
      model.put("assignedStylist", false);
      model.put("template", "templates/stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String firstname = request.queryParams("firstname");
      String lastname = request.queryParams("lastname");
      String email = request.queryParams("email");
      String description = request.queryParams("description");
      Stylist newStylist = new Stylist(firstname,lastname,email,description);
      newStylist.save();
      model.put("stylists", Stylist.all());
      model.put("newStylist", newStylist);
      model.put("template", "templates/stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
      model.put("clientfirstname", false); // if routing here not via post
      model.put("clientlastname", false); // if routing here not via post
      model.put("stylist", stylist);
      model.put("clients", stylist.getClients());
      model.put("template", "templates/stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:id/update", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
      model.put("stylist", stylist);
      model.put("clients", stylist.getClients());
      model.put("template", "templates/update-stylist-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:id/delete", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
      model.put("stylist", stylist);
      model.put("stylists", Stylist.all());
      model.put("clients", stylist.getClients());
      model.put("template", "templates/delete-stylist-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:id/delete", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Stylist deletedStylist = Stylist.find(Integer.parseInt(request.params(":id")));
      Stylist assignedStylist = Stylist.find(Integer.parseInt(request.queryParams("assignedStylistId")));
      String deletedStylistName = deletedStylist.getFirstName();
      deletedStylist.delete(assignedStylist.getId());
      model.put("deletedStylistName", deletedStylistName);
      model.put("stylists", Stylist.all());
      model.put("template", "templates/stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params("id")));
      String firstname = request.queryParams("firstname");
      String lastname = request.queryParams("lastname");
      String email = request.queryParams("email");
      String description = request.queryParams("description");
      stylist.update(firstname, lastname, email, description);
      String url = String.format("/stylists/%d", stylist.getId());
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/clients", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.queryParams("stylistId")));
      String firstname = request.queryParams("firstname");
      String lastname = request.queryParams("lastname");
      String email = request.queryParams("email");
      Client newClient = new Client(firstname, lastname, email, stylist.getId());
      newClient.save();
      // model.put("stylist", stylist);
      // model.put("clientfirstname", firstname);
      // model.put("newClientLastName", lastname);
      String url = String.format("/stylists/%d", stylist.getId());
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

}
