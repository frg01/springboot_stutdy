package com.hspedu.springboot.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hspedu.springboot.mybatisplus.bean.Monster;
import com.hspedu.springboot.mybatisplus.mapper.MonsterMapper;
import com.hspedu.springboot.mybatisplus.service.MonsterService;
import org.springframework.stereotype.Service;

/**
 * @author: guorui fu
 * @versiion: 1.0
 *开发service实现类 需要继承ServiceImpl
 * ServiceImpl实现了IService接口
 * 继承的ServiceImpl实现了MonsterService的父类IService 所以MonsterServiceImpl也实现了IService
 * 实现的MonsterService有定义的方法也可以在这里实现接口方法
 */
@Service
public class MonsterServiceImpl extends ServiceImpl<MonsterMapper, Monster>
                                implements MonsterService {
}
