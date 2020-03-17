package com.aaaa.bbbb.application.service;

import com.aaaa.bbbb.domain.service.SlackDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlackService {

  @Autowired private SlackDomainService slackDomainService;

  public void sendMessage(String message) {
    slackDomainService.sendMessage(message);
  }

  public void deleteMessage() {

  }
}
