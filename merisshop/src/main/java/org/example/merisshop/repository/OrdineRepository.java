package org.example.merisshop.repository;

import org.example.merisshop.model.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface OrdineRepository extends JpaRepository<Ordine,Long> {

}
