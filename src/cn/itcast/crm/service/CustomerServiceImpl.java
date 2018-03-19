package cn.itcast.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.common.utils.Page;
import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;

/***
 * 客户管理
 * @author 范万里
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	//通过四个条件 查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo){
		Page<Customer> page = new Page<Customer>();
		//每页数
		page.setSize(5);
		vo.setSize(5);
		if (null != vo) {
			// 判断当前页
			if (null != vo.getPage()) {
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage() -1)*vo.getSize());
			}
			if(null != vo.getCustName() && !"".equals(vo.getCustName().trim())){
				vo.setCustName(vo.getCustName().trim());
			}
			if(null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())){
				vo.setCustSource(vo.getCustSource().trim());
			}
			if(null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())){
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if(null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())){
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			//总条数
			page.setTotal(customerDao.customerCountByQueryVo(vo));
			page.setRows(customerDao.selectCustomerListByQueryVo(vo));
		}
		return page;
	}
	public Customer selectCustomerById(Integer id) {
		return customerDao.selectCustomerById(id);
	}
	public void updateCustomerById(Customer customer) {
		customerDao.updateCustomerById(customer);
	}
	public void deleteCustomerById(Integer id) {
		customerDao.deleteCustomerById(id);
	} 
}
