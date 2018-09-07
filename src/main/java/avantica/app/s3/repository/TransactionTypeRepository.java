package avantica.app.s3.repository;

import avantica.app.s3.entities.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer>
{

}
