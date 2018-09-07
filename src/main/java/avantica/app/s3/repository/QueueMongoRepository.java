package avantica.app.s3.repository;

import avantica.app.s3.entities.Queue;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QueueMongoRepository extends MongoRepository<Queue, Long>
{

}
