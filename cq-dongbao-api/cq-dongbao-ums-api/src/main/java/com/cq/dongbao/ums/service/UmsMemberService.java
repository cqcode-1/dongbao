package com.cq.dongbao.ums.service;

import com.cq.dongbao.ums.entity.UmsMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cq.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.cq.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author john
 * @since 2022-03-19
 */
public interface UmsMemberService extends IService<UmsMember> {

    void register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO);

    String login(UmsMemberLoginParamDTO umsMemberLoginParamDTO);
}
