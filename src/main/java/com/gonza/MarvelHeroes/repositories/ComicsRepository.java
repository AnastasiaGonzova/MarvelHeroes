package com.gonza.MarvelHeroes.repositories;

import com.gonza.MarvelHeroes.data.Comics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicsRepository extends JpaRepository<Comics, Long> {
}
