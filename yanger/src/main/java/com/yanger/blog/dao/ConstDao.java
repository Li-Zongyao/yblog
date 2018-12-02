package com.yanger.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yanger.blog.po.Const;
import com.yanger.generator.dao.MybatisBaseDao;

/**
 * 表const对应Dao接口
 */
@Mapper
public interface ConstDao extends MybatisBaseDao<Const, Integer> {

	List<Const> findAllByDepict(String depict);
	
}