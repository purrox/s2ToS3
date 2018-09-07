package avantica.app.s3.repository;

import avantica.app.s3.entities.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, Integer>
{

}
