package com.fullmicro.microservices.usecase.daoservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullmicro.microservices.usecase.model.Jpauser;

@Repository
public interface UserRepository extends JpaRepository<Jpauser, Integer> {

}
