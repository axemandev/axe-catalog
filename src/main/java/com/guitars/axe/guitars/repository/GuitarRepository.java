package com.guitars.axe.guitars.repository;

import com.guitars.axe.guitars.entity.Guitar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuitarRepository extends CrudRepository<Guitar, String> {
}
