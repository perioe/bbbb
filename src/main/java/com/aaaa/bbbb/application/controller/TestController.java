package com.aaaa.bbbb.application.controller;

import com.aaaa.bbbb.application.response.TestResponse;
import com.aaaa.bbbb.application.service.TestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping(value = "/test")
public class TestController {

  @Autowired private TestService testService;

  @GetMapping(value = "/test1")
  @ApiOperation(value = "just select")
  public TestResponse getTest(
          @RequestHeader(value = "X-Test", required = false) String head,
          @RequestParam @NotNull @Min(1) Long id) {
    return testService.getTest(id);
  }
}
