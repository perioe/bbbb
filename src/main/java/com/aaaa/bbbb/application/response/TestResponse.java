package com.aaaa.bbbb.application.response;

import com.aaaa.bbbb.domain.entity.TestEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestResponse {
  private Long id;

  private String name;

  private Long testName;

  private String state;

  @Builder
  public TestResponse(TestEntity testEntity) {
    setId(testEntity.getId());
    setName(testEntity.getName());
    setTestName(testEntity.getTest_name());
    setState(testEntity.getState());
  }
}
