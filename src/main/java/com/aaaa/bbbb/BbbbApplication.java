package com.aaaa.bbbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BbbbApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
//        SpringApplication.run(BbbbApplication.class, args);

        int type = 123;
        String name = "이순란";
        String unipass = "P123123";
        String phone = "010-3303-2222";
        String address = "33호";
        String message = "문앞에";
        String deal = "character toys";

        StringBuilder result = new StringBuilder();
        result.append("$(\"#label-radiocharm-region2\").click();");
        result.append("$(\"#ARC_SEQ\").val(");
        result.append(type);
        result.append(");");
        result.append("$(\"#ADRS_KR\").val(\"");
        result.append(name);
        result.append("\");fnHanEng($(\"#ADRS_KR\").val(), ADRS_EN);");
        result.append("$(\"#RRN_NO\").val(\"");
        result.append(unipass);
        result.append("\");javascript:hscode_check();");
        result.append("$(\"#MOB_NO\").val(\"");
        result.append(phone);
        result.append("\".replace(/-/gi,\"\"));");
        result.append("$(\"#ADDR_2\").val(\"");
        result.append(address);
        result.append("\");fnHanEng($(\"#ADDR_2\").val(), ADDR_2_EN);");
        result.append("$(\"#REQ_1\").val(\"");
        result.append(message);
        result.append("\");");
        result.append("$(\"#PRO_NM\").val(\"");
        result.append(deal);
        result.append("\");");
        result.append("$(\"#AUTO_RLS_YN\").prop(\"checked\", true);");
        result.append("$(\"#AUTO_REQ_YN\").prop(\"checked\", true);");
        result.append("$(\"#agree_ivc\").prop(\"checked\", true);");

        System.out.println(result.toString());
    }

}
