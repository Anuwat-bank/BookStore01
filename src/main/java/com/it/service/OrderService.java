package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.it.dto.OrdersDTO;

import com.it.entity.OrderEntity;
import com.it.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<OrdersDTO> findOrderAll(){
		List<OrderEntity> orderEntities = orderRepository.findAll();
		return modelMapper.map(orderEntities, new TypeToken<List<OrdersDTO>>() {}.getType());
	}
	
	
	public OrdersDTO findOrderById(Integer orderId) {
		Optional<OrderEntity> orderOnt = orderRepository.findById(orderId);
		if (orderOnt.isPresent()) {
			return modelMapper.map(orderOnt.get(), new TypeToken<OrdersDTO>() {}.getType());
		}
		return null;
	}
	
	public boolean saveOrder(OrdersDTO ordersDTO) {
        boolean saveFlg = false;
        try {
        	OrderEntity entity = modelMapper.map(ordersDTO, OrderEntity.class);
            orderRepository.save(entity);
            saveFlg = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveFlg;
    }
	
	public boolean updateOrder(Integer orderId, OrdersDTO ordersDTO) {
		boolean updateFlg  = false;
		try {
			Optional<OrderEntity> orderOnt = orderRepository.findById(orderId);
			if (orderOnt.isPresent()) {
				OrderEntity entity = modelMapper.map(ordersDTO, OrderEntity.class);
				entity.setOrderId(orderId);
			    orderRepository.save(entity);
				updateFlg = true;
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return updateFlg;
		
	}
	public boolean deleteOrder(Integer orderId) {
		boolean deleteFlg = false;
		try {
			orderRepository.deleteById(orderId);
			deleteFlg = true;
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return deleteFlg;
	}
	
}



