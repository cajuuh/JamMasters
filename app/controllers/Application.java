package controllers;

import models.Usuario;
import models.repository.UsuarioRepository;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.List;

import static play.libs.Json.toJson;

public class Application extends Controller
{
    private static Form<Usuario> usuarioForm = Form.form(Usuario.class);

    private static UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();

    public Result index()
    {
        return ok(index.render("blabla"));
    }

    @Transactional
    public Result newUsuario()
    {
        Form<Usuario> filledForm = usuarioForm.bindFromRequest();
        if(filledForm.hasErrors())
        {
            return badRequest(views.html.index.render("application"));
        }
        else
        {
            Usuario novoUsuario = filledForm.get();
            usuarioRepository.persist(novoUsuario);
            usuarioRepository.flush();
            return ok(index.render("http://www.google.com"));
        }
    }

    @Transactional
    public Result getUsuarios()
    {
        List<Usuario> users = usuarioRepository.findAll();
        return ok((toJson(users)));
    }
}


