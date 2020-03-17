package com.aaaa.bbbb.infrastructure;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class SlackNotifier {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Autowired private RestTemplate restTemplate;

  @Value("${notify.slack}")
  private String webHookUrl;

  @Getter
  @Builder
  public static class SlackMessageAttachment {
    private String color;
    private String pretext;
    private String title;
    private String title_link;
    private String text;
    private String icon_emoji;
  }

  public boolean notify(String message) {
    try {
      SlackMessageAttachment attachment =
          SlackMessageAttachment.builder()
              .icon_emoji(":sunglasses:")
              .pretext("title!!")
              .text(message)
              .build();
      restTemplate.postForObject(webHookUrl, attachment, String.class);
      return true;
    } catch (Exception e) {
      log.error("Occur Exception: {}", e);
      return false;
    }
  }
}
