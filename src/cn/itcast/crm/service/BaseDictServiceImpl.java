package cn.itcast.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.BaseDictDao;
import cn.itcast.crm.pojo.BaseDict;
@Service
//@Transactional
public class BaseDictServiceImpl implements BaseDictService {
    @Autowired 
	private BaseDictDao baseDictDao;
    
	public List<BaseDict> selectBaseDicListByCode(String code) {
		return baseDictDao.selectBaseDicListByCode(code);
	}

}
