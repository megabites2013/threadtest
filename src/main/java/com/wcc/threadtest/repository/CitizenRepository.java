package com.wcc.threadtest.repository;

import com.wcc.threadtest.model.Citizen;
import com.wcc.threadtest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {}
