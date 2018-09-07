package avantica.app.s3.services;

import avantica.app.s3.entities.BinaryTree;
import avantica.app.s3.entities.Structure;
import avantica.app.s3.entities.Transaction;
import avantica.app.s3.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionServiceImpl implements TransactionServices
{

    @Autowired
    private BinaryTreeJpaRepository binaryTreeJpaRepository;

    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    private BinaryTreeMongoRepository binaryTreeMongoRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public Structure save( Transaction s )
    {
        return new Structure();
    }

    public List<String> print( Transaction s )
    {
        return new ArrayList<>();
    }

    public void delete( int weight )
    {

    }

    public Transaction getTransaction(Long id){


        Transaction transaction = transactionRepository.getOne( id );

        return transaction;
    }


    public BinaryTree getBinaryTree(Long id ){

        return binaryTreeJpaRepository.getOne( id );
    }
}
