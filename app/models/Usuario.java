package models;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pedro on 25/08/2015.
 */
@Entity
public class Usuario
{
    @Id
    @GeneratedValue
    private Long id;

    //nome do usuario
    @Column(unique = true)
    private String nome;

    //telefone do usuario
    @Column (unique = true)
    private String phone;

    @Column (unique = true)
    private String email;

    @ElementCollection
    private List<String> instrumentos;

    public Usuario()
    {
        this.instrumentos = new ArrayList<String>();
    }

    public Usuario(String nome, String phone, String email)
    {
        this();
        this.nome = nome;
        this.phone = phone;
        this.email = email;
    }


    public String getInstrumentos(String nomeDoInstrumento)
    {
        for (String instrumento : instrumentos)
        {
            if(instrumento.equals(nomeDoInstrumento))
            {
                return instrumento;
            }
        }
        return "insturmento nao encontrado";
    }

    public String getNome()
    {
        return nome;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return false;
        }
        if(!(obj instanceof  Usuario))
        {
            return false;
        }
        Usuario outroUsuario = (Usuario) obj;
        return Objects.equal(outroUsuario.getNome(), this.getNome());
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(this.nome);
    }

}
