package avantica.app.s3.repository;

import avantica.app.s3.entities.BinaryTree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinaryTreeJpaRepository extends JpaRepository<BinaryTree, Long>
{

}
