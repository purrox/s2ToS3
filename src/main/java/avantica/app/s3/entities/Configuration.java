package avantica.app.s3.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Configuration
{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    private String dataBaseType;

    @OneToMany
    private List<Structure> structures = new ArrayList<>();

    public String getDataBaseType()
    {
        return dataBaseType;
    }

    public void setDataBaseType( String dataBaseType )
    {
        this.dataBaseType = dataBaseType;
    }

    public List<Structure> getStructures()
    {
        return structures;
    }

    public void setStructures( List<Structure> structures )
    {
        this.structures = structures;
    }


    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

}
