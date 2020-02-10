package com.aaaa.bbbb.application.service;

import com.aaaa.bbbb.application.response.TestResponse;
import com.aaaa.bbbb.domain.entity.TestEntity;
import com.aaaa.bbbb.domain.service.TestDomainService;
import com.aaaa.bbbb.infrastructure.SlackNotifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {
  @Autowired private TestDomainService testDomainService;

  @Autowired private SlackNotifier slackNotifier;

  @Transactional(readOnly = true)
  public TestResponse getTest(Long id) {
    TestEntity test = testDomainService.getTest(id);
    TestResponse testResponse = TestResponse.builder().testEntity(test).build();

    slackNotifier.notify(testResponse.getName());
    return testResponse;
  }
}
