package avantica.app.s3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class IgnoreHibernatePropertiesInJackson{ }

