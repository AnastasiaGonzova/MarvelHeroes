package com.gonza.MarvelHeroes.repositories;

import com.gonza.MarvelHeroes.data.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
}
