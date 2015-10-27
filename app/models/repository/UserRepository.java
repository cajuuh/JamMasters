package models.repository;

import models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Pedro on 25/08/2015.
 */
@Repository
public class UserRepository extends GenericRepositoryImpl<User>
{
    @PersistenceContext
    private EntityManager manager;

    private static UserRepository instance;

    private UserRepository()
    {
        super(User.class);
    }

    public static UserRepository getInstance()
    {
        if (instance == null)
        {
            instance = new UserRepository();
        }
        return instance;
    }
}
