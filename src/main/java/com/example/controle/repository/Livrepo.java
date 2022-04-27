
package com.example.controle.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.controle.entity.Livre;


public interface Livrepo
        extends JpaRepository<Livre, Long> {

    @Query(value = "SELECT * FROM livre ORDER BY date_sortie DESC", nativeQuery = true)
    public default List<Livre> findAllByOrderByDateAsc() {
        return null;
    }

}