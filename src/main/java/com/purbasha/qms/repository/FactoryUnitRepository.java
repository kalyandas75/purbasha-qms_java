package com.purbasha.qms.repository;

import com.purbasha.qms.domain.FactoryUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactoryUnitRepository extends JpaRepository<FactoryUnit, Long> {
}
