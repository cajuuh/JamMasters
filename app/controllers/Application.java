package controllers;

import models.User;
import models.repository.UserRepository;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import views.html.index;

import java.io.File;
import java.util.List;

import static play.libs.Json.toJson;

public class Application extends Controller
{
    private static Form<User> userForm = Form.form(User.class);

    private static UserRepository userRepository = UserRepository.getInstance();

    public Result index()
    {
        return ok(index.render("blabla"));
    }

    @Transactional
    public Result newUser()
    {
        Form<User> filledForm = userForm.bindFromRequest();

        if (filledForm.hasErrors()) {
            return badRequest(views.html.index.render("application"));
        }
        else
        {
            User newUser = filledForm.get();
            userRepository.persist(newUser);
            userRepository.flush();
            return ok(index.render("http://www.google.com"));
        }
    }

    @Transactional
    public Result upload(){
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart picture = body.getFile("picture");
        if (picture != null) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();
            File file = picture.getFile();
            return ok("File uploaded");
        } else {
            flash("error", "Missing file");
            return badRequest(views.html.index.render("application"));
        }
    }

    @Transactional
    public Result getUsuarios()
    {
        List<User> users = userRepository.findAll();
        return ok((toJson(users)));
    }
}


