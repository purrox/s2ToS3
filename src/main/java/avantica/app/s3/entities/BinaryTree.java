package avantica.app.s3.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
public class BinaryTree extends Transaction
{

    @OneToMany( cascade = CascadeType.MERGE )
    @OrderColumn
    @JoinColumn( name = "parent_id" )
    private List<BinaryTree> children = new LinkedList<>();

    @JsonIgnoreProperties
    @ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.MERGE )
    @JoinColumn( name = "parent_id", insertable = false, updatable = false )
    private BinaryTree parentId;

    @Transient
    private boolean isInserted = false;

    @JsonIgnoreProperties
    public boolean isInserted()
    {
        return isInserted;
    }

    public void setInserted( boolean inserted )
    {
        isInserted = inserted;
    }

    public List<BinaryTree> getChildren()
    {
        return children;
    }

    public void setChildren( List<BinaryTree> children )
    {
        this.children = children;
    }

    @JsonIgnoreProperties
    @JsonIgnore
    public boolean isLeaf()
    {

        if ( this.getChildren().isEmpty() )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @JsonIgnoreProperties
    @JsonIgnore
    public BinaryTree getYoungestChild()
    {

        if ( !this.getChildren().isEmpty() && this.getWeight() > this.getChildren().get( 0 ).getWeight() )
        {
            return this.getChildren().get( 0 );
        }
        else
        {
            return null;
        }
    }

    @JsonIgnoreProperties
    @JsonIgnore
    public BinaryTree getOldestChild()
    {

        if ( !this.getChildren().isEmpty() && this.getChildren().size() == 2 )
        {

            return this.getChildren().get( 1 );
        }
        else
        {

            if ( !this.getChildren().isEmpty() &&
                    this.getChildren().size() == 1
                    && this.getWeight() < this.getChildren().get( 0 ).getWeight() )
            {
                return this.getChildren().get( 0 );
            }
            else
            {
                return null;
            }
        }
    }
}

