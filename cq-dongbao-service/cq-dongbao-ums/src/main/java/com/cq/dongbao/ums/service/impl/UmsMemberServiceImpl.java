package com.cq.dongbao.ums.service.impl;

import com.cq.dongbao.ums.entity.vo.UmsMemberLoginParamDTO;
import com.cq.dongbao.ums.entity.vo.UmsMemberRegisterParamDTO;
import com.cq.dongbao.ums.service.UmsMemberService;
import com.cq.dongbao.ums.entity.UmsMember;
import com.cq.dongbao.ums.mapper.UmsMemberMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author john
 * @since 2022-03-19
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService {

    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Override
    public void register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        UmsMember umsMember = new UmsMember();
        BeanUtils.copyProperties(umsMemberRegisterParamDTO, umsMember);

        BCryptPasswordEncoder bCryptPasswordEncoding = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoding.encode(umsMember.getPassword());
        umsMember.setPassword(password);
        umsMemberMapper.insert(umsMember);
    }

    @Override
    public String login(UmsMemberLoginParamDTO umsMemberLoginParamDTO){
        UmsMember umsMember = umsMemberMapper.queryByUsername(umsMemberLoginParamDTO.getUsername());

        if(umsMember!= null && umsMember.getUsername() != null){
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            boolean matches = bCryptPasswordEncoder.matches(umsMemberLoginParamDTO.getPassword(), umsMember.getPassword());
            return matches? "登录成功" : "密码错误";
        }else{
            return "用户名不存在";
        }
    }
}
