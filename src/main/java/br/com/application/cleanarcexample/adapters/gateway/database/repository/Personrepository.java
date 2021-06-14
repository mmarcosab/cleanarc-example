package br.com.application.cleanarcexample.adapters.gateway.database.repository;

import br.com.application.cleanarcexample.adapters.gateway.database.entities.PersonData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Personrepository extends JpaRepository<PersonData, Integer> {
    boolean existsByName(String name);
}
