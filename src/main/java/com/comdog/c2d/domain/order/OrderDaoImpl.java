package com.comdog.c2d.domain.order;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comdog.c2d.dto.Order;

@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	SqlSession sql;
	
	//조회
	@Override
	public List<Order> findAllOrders() {
		return sql.selectList("order.findAllOrders");
	}

}
