package com.guitars.axe.guitars.repository;

import com.guitars.axe.guitars.entity.GuitarVariant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuitarVariantsRepository extends CrudRepository<GuitarVariant, String> {
}
