package avantica.app.s3.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "binary_tree")
public class BinaryTree
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnoreProperties
    private Long id;
    private String name;

    @OneToMany(cascade=CascadeType.MERGE)
    @OrderColumn
    @JoinColumn(name = "parent_id")
    private List<BinaryTree> children = new ArrayList<>();

    @JsonIgnoreProperties
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name = "parent_id",insertable=false,updatable=false)
    private BinaryTree parentId;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public List<BinaryTree> getChildren()
    {
        return children;
    }

    public void setChildren( List<BinaryTree> children )
    {
        this.children = children;
    }

    public boolean isLeaf(){

        if(this.getChildren().isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}

