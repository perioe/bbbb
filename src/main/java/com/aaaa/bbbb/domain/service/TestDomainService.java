package com.aaaa.bbbb.domain.service;

import com.aaaa.bbbb.domain.entity.TestEntity;
import com.aaaa.bbbb.domain.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestDomainService {
  @Autowired private TestRepository testRepository;

  public TestEntity getTest(Long id) {
    Optional<TestEntity> test = testRepository.findById(id);
    return Optional.ofNullable(test).orElse(test).get();
  }
}
