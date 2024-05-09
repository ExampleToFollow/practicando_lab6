package com.example.practicando_lab6.Repository;

import com.example.practicando_lab6.Entity.Location;
import org.springframework.boot.context.config.ConfigDataLocationResolverContext;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer>  {
}
