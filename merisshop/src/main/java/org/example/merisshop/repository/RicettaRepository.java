package org.example.merisshop.repository;

import org.example.merisshop.model.Ricetta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RicettaRepository extends JpaRepository<Ricetta, Long> {
}
