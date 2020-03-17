package com.aaaa.bbbb.domain.service;

import com.aaaa.bbbb.infrastructure.SlackConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlackDomainService {

  @Autowired private SlackConfig slackConfig;

  public void sendMessage(String message) {
    slackConfig.notify(message);
  }
}
