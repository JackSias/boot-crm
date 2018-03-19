package cn.itcast.crm.dao;

import java.util.List;

import cn.itcast.crm.pojo.BaseDict;

public interface BaseDictDao {
    //查询
	public List<BaseDict> selectBaseDicListByCode(String code);
}
