package avantica.app.s3.services;

import avantica.app.s3.entities.BinaryTree;
import avantica.app.s3.entities.Structure;
import avantica.app.s3.entities.Transaction;

import java.util.List;

public interface TransactionServices
{

    public Structure save( Transaction s );

    public List<String> print( Transaction s );

    public void delete( int weight );

    public Transaction getTransaction(Long id);

    public BinaryTree getBinaryTree(Long id );

    }
