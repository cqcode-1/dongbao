package com.cq.dongbao.portal.web.controller;

import com.cq.dongbao.common.result.ResultWarpper;
import com.cq.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.cq.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.cq.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dongbao")
public class UserController {

    @GetMapping("/hello")
    public String hello(){

        return "hello";
    }

    @Autowired
    UmsMemberService umsMemberService;

    @PostMapping("/register")
    public ResultWarpper register(@RequestBody @Validated UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){

        umsMemberService.register(umsMemberRegisterParamDTO);
        return ResultWarpper.getSuccess().data("result").build();
    }

    @PostMapping("/login")
    public String login(@RequestBody UmsMemberLoginParamDTO umsMemberLoginParamDTO){
        return umsMemberService.login(umsMemberLoginParamDTO);
    }
}
