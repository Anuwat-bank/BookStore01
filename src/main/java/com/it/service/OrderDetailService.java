package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.it.dto.OrderDetailsDTO;
import com.it.dto.UserDetailsDTO;
import com.it.entity.OrderDetailEntity;
import com.it.entity.UserDetailEntity;
import com.it.repository.OrderDetailRepository;

@Service
public class OrderDetailService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	public List<OrderDetailsDTO> findOrderDetailAll(){
		List<OrderDetailEntity> orderDeEntities = orderDetailRepository.findAll();
		return modelMapper.map(orderDeEntities, new TypeToken<List<OrderDetailsDTO>>() {}.getType());
	}
	
	
	public OrderDetailsDTO findOrderdetailByorderDetailId(Integer orderId) {
		OrderDetailEntity orderDeOnt = orderDetailRepository.findByOrderId(orderId);
		if (orderDeOnt != null) {
			return modelMapper.map(orderDeOnt, new TypeToken<OrderDetailsDTO>() {}.getType());
		}
		return null;
	}
	

	
	public boolean saveOrderDetail(OrderDetailsDTO orderDetailsDTO) {
        boolean saveFlg = false;
        try {
        	OrderDetailEntity entity = modelMapper.map(orderDetailsDTO, OrderDetailEntity.class);
            orderDetailRepository.save(entity);
            saveFlg = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveFlg;
    }
	
	public boolean updateOrderDetail(Integer orderDetailId, OrderDetailsDTO orderDetailsDTO) {
		boolean updateFlg  = false;
		try {
			Optional<OrderDetailEntity> orderDeOnt = orderDetailRepository.findById(orderDetailId);
			if (orderDeOnt.isPresent()) {
				OrderDetailEntity entity = modelMapper.map(orderDetailsDTO, OrderDetailEntity.class);
				entity.setOrderDetailId(orderDetailId);
				orderDetailRepository.save(entity);
				updateFlg = true;
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return updateFlg;
		
	}
	
	public boolean deleteOrderDetailById(Integer orderDetailId) {
		boolean deleteFlg = false;
		try {
			orderDetailRepository.deleteById(orderDetailId);
			deleteFlg = true;
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return deleteFlg;
	}

}
