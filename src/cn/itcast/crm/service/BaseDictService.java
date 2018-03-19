package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.pojo.BaseDict;

public interface BaseDictService {
	public List<BaseDict> selectBaseDicListByCode(String code);
}
