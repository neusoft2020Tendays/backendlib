package com.hitstu.oa.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitstu.oa.store.mapper.IGoodsMapper;
import com.hitstu.oa.store.model.GoodsModel;
import com.hitstu.oa.store.service.IGoodsService;


@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements IGoodsService {

	@Autowired
	private IGoodsMapper goodsMapper = null;

	public void setGoodsMapper(IGoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}
	
	@Override
	public void add(GoodsModel goodsmodel) throws Exception {
		goodsMapper.insert(goodsmodel);
		
	}

	@Override
	public void delete(GoodsModel goodsmodel) throws Exception {
		goodsMapper.delete(goodsmodel);
		
	}

	@Override
	public void modify(GoodsModel goodsmodel) throws Exception {
		goodsMapper.update(goodsmodel);
		
	}

	@Override
	public List<GoodsModel> getByAll() throws Exception {
		return goodsMapper.selectByAll();
	}

	@Override
	public GoodsModel getById(String id) throws Exception {
		return goodsMapper.selectById(id);
	}

	@Override
	public List<GoodsModel> getByAllWithPage(int rows, int page) throws Exception {
		
		return goodsMapper.selectByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		return goodsMapper.selectCountByAll();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		int count = this.getCountByAll();
		int pageCount = 0;
		if (count % rows == 0) {
			pageCount = count / rows;
		} else {
			pageCount = count / rows + 1;
		}
		return pageCount;
	}
	
	public static void main(String[] args) {
		/* 已弃用 */
//		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigForSM.class);
//		IEmployeeService employeeService = context.getBean(IEmployeeService.class);
//		try {
//			System.out.println(employeeService.getById("1705004").getName());
//			EmployeeModel employeeModel = getEmployeeModel(
//					"1705004", "D05", "孙悟空", "男", 27, "否", "否");
//			employeeService.modify(employeeModel);
//			System.out.println(employeeService.getById("1705004").getName());
//			employeeService.delete(employeeModel);
//			System.out.println(employeeService.getByAll().size());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		GoodsServiceImpl gs = new GoodsServiceImpl();
		try {
			System.out.println(gs.getByAll().size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
