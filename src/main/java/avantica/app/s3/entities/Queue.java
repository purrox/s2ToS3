package avantica.app.s3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Queue extends Transaction
{

    @OneToMany(cascade = CascadeType.MERGE )
    @OrderColumn
    @JoinColumn(name = "predecessor")
    private List<Queue> queue = new LinkedList<>();

    @JsonIgnoreProperties
    @ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.MERGE )
    @JoinColumn( name = "predecessor", insertable = false, updatable = false )
    private Queue predecessor;


    public List<Queue> getQueue()
    {
        return queue;
    }

    public void setQueue( List<Queue> queue )
    {
        this.queue = queue;
    }


}
