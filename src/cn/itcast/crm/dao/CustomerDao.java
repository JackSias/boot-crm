package cn.itcast.crm.dao;

import java.util.List;

import cn.itcast.crm.pojo.BaseDict;
import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;

public interface CustomerDao {
    //总条数
	public Integer customerCountByQueryVo(QueryVo vo);
	//结果集selectCustomerListByQueryVo
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	//根据ID查询客户
	public Customer selectCustomerById(Integer id);
	//根据ID修改客户
	public void updateCustomerById(Customer customer);
	//根据ID删除用户
	public void deleteCustomerById(Integer id);
}
