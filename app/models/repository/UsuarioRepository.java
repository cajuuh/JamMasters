package models.repository;

import models.Usuario;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Created by Pedro on 25/08/2015.
 */
public class UsuarioRepository extends GenericRepositoryImpl<Usuario>
{
    private static UsuarioRepository instance;

    private UsuarioRepository()
    {
        super(Usuario.class);
    }

    public static UsuarioRepository getInstance()
    {
        if (instance == null)
        {
            instance = new UsuarioRepository();
        }
        return instance;
    }
}
