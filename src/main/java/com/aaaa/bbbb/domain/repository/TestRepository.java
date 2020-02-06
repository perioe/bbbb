package com.aaaa.bbbb.domain.repository;

import com.aaaa.bbbb.domain.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long>, TestCustomRepository {
  Optional<TestEntity> findById(Long id);
}
