package avantica.app.s3.repository;

import avantica.app.s3.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long>
{

    List<Transaction> findByName(String name);

}
