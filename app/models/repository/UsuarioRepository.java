package models.repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.sun.corba.se.impl.activation.RepositoryImpl;
import models.Usuario;
import sun.reflect.generics.repository.GenericDeclRepository;

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
        if(instance == null)
        {
            instance = new UsuarioRepository();
        }
        return instance;
    }

    public Usuario findByName(String nome)
    {
        String hql = "FROM Usuario a WHERE a.nome = :nome";
        TypedQuery<Usuario> query = super.getEm().createQuery(hql, Usuario.class);
        query.setParameter("nome", nome);
        try
        {
            return query.getSingleResult();
        }
        catch (NoResultException exception)
        {
            return null;
        }
    }
}
