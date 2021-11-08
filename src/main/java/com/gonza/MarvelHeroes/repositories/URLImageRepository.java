package com.gonza.MarvelHeroes.repositories;

import com.gonza.MarvelHeroes.extra.URLImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLImageRepository extends JpaRepository<URLImage, Long> {
}
