package cn.itcast.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.common.utils.Page;
import cn.itcast.crm.pojo.BaseDict;
import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;
import cn.itcast.crm.service.BaseDictService;
import cn.itcast.crm.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	//注解在成员变量上
	@Value("${formType.code}")
	private String formTypeCode;
	
	@RequestMapping(value="/customer/list")
    public String list(QueryVo vo,Model model) {
		//通过四个条件 查询分页对象
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		List<BaseDict> fromType = baseDictService.selectBaseDicListByCode(formTypeCode);
		List<BaseDict> industryType = baseDictService.selectBaseDicListByCode("001");
		List<BaseDict> levelType = baseDictService.selectBaseDicListByCode("006");
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
    }
	//去修改页面
	@RequestMapping(value = "/customer/edit.action")
	public @ResponseBody
	Customer edit(Integer id){
		System.err.println("============================================================"+id);
		Customer c=customerService.selectCustomerById(id);
		return customerService.selectCustomerById(id);
	}
	//修改数据
	@RequestMapping(value="/customer/update.action")
    public @ResponseBody
    String update(Customer customer) {
		customerService.updateCustomerById(customer);
		return "OK";
    }
	//修改删除数据
	@RequestMapping(value="/customer/delete.action")
    public @ResponseBody
    String delete(Integer id) {
		customerService.deleteCustomerById(id);
		return "OK";
    }
}
