package controllers;

import models.Usuario;
import models.repository.UsuarioRepository;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Content;
import views.html.index;

import java.util.List;

import static play.libs.Json.toJson;

public class Application extends Controller
{

    static Form<Usuario> usuarioForm = Form.form(Usuario.class);
    private static UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();

    public Result index()
    {
        return ok(index.render());
    }

    @Transactional
    public Result newUsuario()
    {
        Form<Usuario> filledForm = usuarioForm.bindFromRequest();
        if(filledForm.hasErrors())
        {
            return badRequest(views.html.index.render());
        }
        else
        {
            Usuario usuario = filledForm.get();
            usuarioRepository.persist(usuario);
            usuarioRepository.flush();
            return ok(index.render());
        }
    }

    public Result getUsuarios()
    {
        List<Usuario> users =  usuarioRepository.findAll();
        return ok((Content) users);
    }
}


