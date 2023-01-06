package com.hspedu.springboot.mybatisplus.mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hspedu.springboot.mybatisplus.bean.Monster;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * BaseMapper<Monster> 默认提供了很多CRUD 可以直接使用  方法不够用时可以取开发新的方法 再MonsterMapper.xml配置
 */
//@Mapper
public interface MonsterMapper extends BaseMapper<Monster> {
    //自定义方法

    int insertSelective(Monster monster);

    int deleteByEmail(@Param("email") String email);
}
