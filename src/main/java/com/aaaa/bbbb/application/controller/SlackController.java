package com.aaaa.bbbb.application.controller;

import com.aaaa.bbbb.application.response.TestResponse;
import com.aaaa.bbbb.application.service.TestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping(value = "/slack")
public class SlackController {

  @Autowired private TestService testService;

  @PostMapping(value = "/send")
  @ApiOperation(value = "send message")
  public TestResponse send(@Valid Long id) {
    return testService.getTest(id);
  }
}
