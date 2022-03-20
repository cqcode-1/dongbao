package com.cq.dongbao.ums.mapper;

import com.cq.dongbao.ums.entity.UmsMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.lang.reflect.GenericDeclaration;
import java.util.Date;

@SpringBootTest
public class UserMemberTest {

    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Test
    public void insert(){
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername("WW18821424");
        umsMember.setPassword("123456");
        umsMemberMapper.insert(umsMember);

    }

    @Test
    public void update(){
        UmsMember umsMember = new UmsMember();
        umsMember.setId(70L);
        umsMember.setUsername("dddw");
        umsMemberMapper.updateById(umsMember);
        System.out.println(new Date());
    }
    @Test
    public void selectById(){

        UmsMember umsMember = umsMemberMapper.selectById1(70);

        System.out.println(umsMember);
    }

    @Test
    public void testEncrypt(){
        String password = "123456";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        System.out.println(encode);
        System.out.println(bCryptPasswordEncoder.matches(password, encode));
        encode = bCryptPasswordEncoder.encode(password);
        System.out.println(encode);
        System.out.println(bCryptPasswordEncoder.matches(password, encode));



    }
}
