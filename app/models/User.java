package models;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pedro on 25/08/2015.
 */
@Entity
@Table(name = "TB_USER")
public class User
{
    @Id
    @GeneratedValue
    private Long id;

    //user name
    private String name;

    //user phone
    private String phone;

    //user email
    private String email;

    @OneToMany(targetEntity=User.class, mappedBy="id", fetch=FetchType.EAGER)
    private List<String> instruments;

    public User()
    {
        this.instruments = new ArrayList<String>();
    }

    public User(String name, String phone, String email)
    {
        this();
        this.name = name;
        this.phone = phone;
        this.email = email;
    }


    public String getinstruments(String nameDoInstrumento)
    {
        for (String instrumento : instruments)
        {
            if(instrumento.equals(nameDoInstrumento))
            {
                return instrumento;
            }
        }
        return "insturmento nao encontrado";
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setname(String name)
    {
        this.name = name;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setInstruments(List<String> instruments)
    {
        this.instruments = instruments;
    }

    public Long getId()
    {
        return id;
    }

    public String getname()
    {
        return name;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }

    public List<String> getInstruments()
    {
        return instruments;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return false;
        }
        if(!(obj instanceof User))
        {
            return false;
        }
        User otherUser = (User) obj;
        return Objects.equal(otherUser.getname(), this.getname());
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(this.name);
    }

}
