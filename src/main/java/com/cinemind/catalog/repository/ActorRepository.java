package com.cinemind.catalog.repository;

import com.cinemind.catalog.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    java.util.List<Actor> findByNameContainingIgnoreCase(String name);
}