package org.shane.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParamotorRepository extends JpaRepository<Paramotor, Long> {
	
}
