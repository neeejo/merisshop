package org.example.merisshop.repository;

import org.example.merisshop.model.Negozio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface NegozioRepository extends JpaRepository<Negozio,Long> {
}
