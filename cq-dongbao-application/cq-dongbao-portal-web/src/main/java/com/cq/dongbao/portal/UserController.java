package com.cq.dongbao.portal;


import com.cq.dongbao.common.enums.StateCodeEnum;
import com.cq.dongbao.common.result.ResultWarpper;
import com.cq.dongbao.ums.entity.UmsMember;
import com.cq.dongbao.ums.entity.vo.UmsMemberLoginParamDTO;
import com.cq.dongbao.ums.entity.vo.UmsMemberRegisterParamDTO;
import com.cq.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dongbao")
public class UserController {

    @GetMapping("/hello")
    public String hello(){

        return "hello";
    }

    @Autowired
    UmsMemberService umsMemberMapper;

    @PostMapping("/register")
    public ResultWarpper register(@RequestBody UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){

        umsMemberMapper.register(umsMemberRegisterParamDTO);
        ResultWarpper success = ResultWarpper.getSuccess();
        success.setData("result");
        return success;
    }

    @PostMapping("/login")
    public String login(@RequestBody UmsMemberLoginParamDTO umsMemberLoginParamDTO){
        return umsMemberMapper.login(umsMemberLoginParamDTO);
    }
}
