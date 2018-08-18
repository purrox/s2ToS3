package avantica.app.s3.repository;

import avantica.app.s3.entities.BinaryTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BinaryTreeMongoRepository extends MongoRepository<BinaryTree, Long>
{

}
