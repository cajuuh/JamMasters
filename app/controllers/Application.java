package controllers;

import java.util.List;

import models.Usuario;
import models.repository.UsuarioRepository;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller
{

    static Form<Usuario> usuarioForm = Form.form(Usuario.class);
    private static UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();

    public Result index()
    {
        return ok(index.render("Your new application is ready."));
    }

    public Result newUsuario()
    {
        Form<Usuario> filledForm = usuarioForm.bindFromRequest();
        if(filledForm.hasErrors())
        {
            return badRequest();
        }
        else
        {
            Usuario usuario = filledForm.get();
            usuarioRepository.persist(usuario);
            usuarioRepository.flush();
            return redirect("http://www.google.com");
        }
    }
}
