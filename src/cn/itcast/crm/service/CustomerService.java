package cn.itcast.crm.service;

import cn.itcast.common.utils.Page;
import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;

public interface CustomerService {
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	//根据ID查询客户
	public Customer selectCustomerById(Integer id);
	//根据ID修改客户
	public void updateCustomerById(Customer customer);
	//根据ID删除客户
	public void deleteCustomerById(Integer id);
}
