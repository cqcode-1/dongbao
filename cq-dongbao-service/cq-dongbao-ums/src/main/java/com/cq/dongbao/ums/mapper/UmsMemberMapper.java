package com.cq.dongbao.ums.mapper;

import com.cq.dongbao.ums.entity.UmsMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author john
 * @since 2022-03-19
 */
@Repository
public interface UmsMemberMapper extends BaseMapper<UmsMember> {

    UmsMember selectById1(Integer id);

    UmsMember queryByUsername(String username);
}
