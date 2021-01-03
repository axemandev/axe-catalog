package com.guitars.axe.guitars.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuitarVariantPricesRepository extends CrudRepository<GuitarVariantPricesRepository, String> {
}
