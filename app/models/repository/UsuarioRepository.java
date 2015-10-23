package models.repository;

import models.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Pedro on 25/08/2015.
 */
@Repository
public class UsuarioRepository extends GenericRepositoryImpl<Usuario>
{

    @PersistenceContext
    private EntityManager manager;

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
