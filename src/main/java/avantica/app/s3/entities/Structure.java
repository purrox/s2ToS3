package avantica.app.s3.entities;

import javax.persistence.*;

@Table
@Entity
public class Structure
{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private Long transactionId;

    @ManyToOne
    private TransactionType transactionType;

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getType()
    {
        return type;
    }

    public void setType( String type )
    {
        this.type = type;
    }

    public Long getTransactionId()
    {
        return transactionId;
    }

    public void setTransactionId( Long transactionId )
    {
        this.transactionId = transactionId;
    }

    public TransactionType getTransactionType()
    {
        return transactionType;
    }

    public void setTransactionType( TransactionType transactionType )
    {
        this.transactionType = transactionType;
    }

}
