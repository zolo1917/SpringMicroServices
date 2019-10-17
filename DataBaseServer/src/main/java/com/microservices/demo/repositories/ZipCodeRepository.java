package com.microservices.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.demo.model.ZipCodeModel;

public interface ZipCodeRepository extends JpaRepository<ZipCodeModel, Long>{
}
