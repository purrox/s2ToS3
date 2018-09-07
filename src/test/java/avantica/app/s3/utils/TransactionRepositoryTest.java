package avantica.app.s3.utils;

import avantica.app.s3.entities.Transaction;
import avantica.app.s3.repository.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.assertj.core.api.Assertions;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith( SpringRunner.class )
@SpringBootTest
public class TransactionRepositoryTest
{

    @Autowired
    TransactionRepository repository;

    Transaction transaction;

    @Before
    public void setUp()
    {
        transaction = new Transaction();
        transaction.setName( "TransactionTest" );
        transaction.setWeight( 3 );

        repository.save( transaction );
    }

    @Test
    public void validateNotNullId() {

        Transaction t1 = repository.save(transaction);

        assertNotNull( t1.getId() );

    }

    @Test
    public void findByName(){

        List<Transaction> t = repository.findByName("TransactionTest");

        Assertions.assertThat(t).extracting("name").contains("TransactionTest");

    }

}
