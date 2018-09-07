package avantica.app.s3.repository;

import avantica.app.s3.entities.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueRepository extends JpaRepository<Queue, Long>
{

}
