package avantica.app.s3.repository;

import avantica.app.s3.entities.Structure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StructureRepository extends JpaRepository<Structure, Long>
{

}
