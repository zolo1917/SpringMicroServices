package com.microservices.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.microservices.demo.model.ZipCodeModel;

public interface ZipCodeRepository extends CrudRepository<ZipCodeModel, Long> {
}
