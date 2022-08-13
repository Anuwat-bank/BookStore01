package com.it.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.CenterOrderDTO;
import com.it.dto.OrderDetailsDTO;
import com.it.dto.OrderStoreDTO;
import com.it.dto.OrdersDTO;
import com.it.dto.PaymentsDTO;
import com.it.dto.ResponeOrderDTO;
import com.it.dto.UserDTO;
import com.it.dto.UserDetailsDTO;
import com.it.entity.BookEntity;
import com.it.entity.OrderDetailEntity;
import com.it.entity.OrderEntity;
import com.it.entity.PaymentEntity;
import com.it.repository.BookRepository;
import com.it.repository.OrderDetailRepository;
import com.it.repository.OrderRepository;
import com.it.repository.PaymemtRepository;
import com.it.repository.UserDetailRepository;
import com.it.repository.UserRepository;

@Service
public class OrderStoreService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserDetailService userDetailService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PaymemtRepository paymemtRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<ResponeOrderDTO> findOrderByUserId(Integer userId) {

		List<ResponeOrderDTO> responeOrderDTOs = new ArrayList<>();
		List<OrderEntity> orderOnt = orderRepository.findByUserId(userId);
		List<OrderStoreDTO> result = new ArrayList<>();
		if (orderOnt != null) {

			for (OrderEntity data : orderOnt) {

				Optional<BookEntity> bookEntity = bookRepository.findById(data.getOrderDetail().get(0).getBId());

				OrderStoreDTO ordersDTO = new OrderStoreDTO();
				ordersDTO.setOrderId(data.getOrderId());
				ordersDTO.setBId(bookEntity.get().getBId());
				ordersDTO.setBName(bookEntity.get().getBName());
				ordersDTO.setOrderAmount(data.getOrderDetail().get(0).getOrderAmount());
				ordersDTO.setOrderNumber(data.getOrderDetail().get(0).getOrderNumber());
				ordersDTO.setCId(data.getCId());
				result.add(ordersDTO);

			}
			if (null != result && !result.isEmpty()) {
				List<Integer> cIdList = result.stream().map(m -> m.getCId()).distinct().collect(Collectors.toList());

				for (Integer data : cIdList) {
					UserDetailsDTO userDtDTO = userDetailService.findByCid(data);
					List<OrderStoreDTO> list = result.stream().filter(a -> a.getCId().equals(data))
							.collect(Collectors.toList());
					if (null != list && !list.isEmpty()) {
						ResponeOrderDTO responeOrderDTO = new ResponeOrderDTO();
						responeOrderDTO.setCName(userDtDTO.getCName());
						responeOrderDTO.setCId(list.get(0).getCId());
						responeOrderDTO.setOrderList(list);
						responeOrderDTO.setSummaryAmount(summaryAmount(list, "AMT"));
						responeOrderDTO.setSummaryProduct(summaryAmount(list, "PDT"));
						responeOrderDTOs.add(responeOrderDTO);

					}
				}
			}

		}
		return responeOrderDTOs;

	}

	public BigDecimal summaryAmount(List<OrderStoreDTO> list, String flg) {
		List<BigDecimal> amountList = null;
		if ("AMT".equals(flg)) {
			amountList = list.stream().map(m -> m.getOrderAmount().multiply(new BigDecimal(m.getOrderNumber())))
					.collect(Collectors.toList());
		} else if ("PDT".equals(flg)) {
			amountList = list.stream().map(m -> new BigDecimal(m.getOrderNumber())).collect(Collectors.toList());
		}

		return amountList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
	}


	public List<CenterOrderDTO> findByCid(Integer cId) {
		
		List<CenterOrderDTO> result = null;
		
		try {
			List<OrderEntity> orderOnt = orderRepository.findByCid(cId);
			
			if(null != orderOnt && !orderOnt.isEmpty()) {
				result = new ArrayList<>();
				
				for(OrderEntity data : orderOnt) {
					CenterOrderDTO centerOrderObj = new CenterOrderDTO();
					Optional<BookEntity> bookEntity = bookRepository.findById(data.getOrderDetail().get(0).getBId());
					Optional<PaymentEntity> paymentEntity = paymemtRepository.findById(data.getTranSecId());
					
					centerOrderObj.setBId(data.getOrderDetail().get(0).getBId());
					centerOrderObj.setBName(bookEntity.get().getBName());
					centerOrderObj.setCId(data.getCId());
					centerOrderObj.setOrderAmount(data.getOrderDetail().get(0).getOrderAmount());
					centerOrderObj.setOrderId(data.getOrderId());
					centerOrderObj.setOrderNumber(data.getOrderDetail().get(0).getOrderNumber());
					centerOrderObj.setRecordStatus(data.getRecordStatus());
					centerOrderObj.setTranSecId(data.getTranSecId());
					centerOrderObj.setUserId(data.getUserId());
					centerOrderObj.setPaymentsDTO(modelMapper.map(paymentEntity.get(), new TypeToken<PaymentsDTO>() {}.getType()));
					
					result.add(centerOrderObj);
					
				}
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	
	}

}
