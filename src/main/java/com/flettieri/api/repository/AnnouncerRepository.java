package com.flettieri.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flettieri.api.model.Announcer;

@Repository
public interface AnnouncerRepository extends JpaRepository<Announcer, Long> {

}
