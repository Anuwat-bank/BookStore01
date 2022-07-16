package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.it.dto.PaymentsDTO;

import com.it.entity.PaymentEntity;
import com.it.repository.PaymemtRepository;

@Service
public class PaymentService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PaymemtRepository paymemtRepository;
	
	public List<PaymentsDTO> findPayAll(){
		List<PaymentEntity> payEntities = paymemtRepository.findAll();
		return modelMapper.map(payEntities, new TypeToken<List<PaymentsDTO>>() {}.getType());
	}
	
	public PaymentsDTO findPaymentsByPayId(String tranSecId) {
		Optional<PaymentEntity> payOnt = paymemtRepository.findById(tranSecId);
		if (payOnt.isPresent()) {
			return modelMapper.map(payOnt.get(), new TypeToken<PaymentsDTO>() {}.getType());
		}
		return null;
	}
	
	public boolean savePayment(PaymentsDTO paymentsDTO) {
        boolean saveFlg = false;
        try {
        	PaymentEntity entity = modelMapper.map(paymentsDTO, PaymentEntity.class);
            paymemtRepository.save(entity);
            saveFlg = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveFlg;
    }
	
	public boolean updatePayment(String tranSecId, PaymentsDTO paymentsDTO) {
		boolean updateFlg  = false;
		try {
			Optional<PaymentEntity> payOnt = paymemtRepository.findById(tranSecId);
			if (payOnt.isPresent()) {
				PaymentEntity entity = modelMapper.map(paymentsDTO, PaymentEntity.class);
				entity.setTranSecId(tranSecId);
				paymemtRepository.save(entity);
				updateFlg = true;
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return updateFlg;
		
	}
	
	public boolean deletePayment(String tranSecId) {
		boolean deleteFlg = false;
		try {
			paymemtRepository.deleteById(tranSecId);
			deleteFlg = true;
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return deleteFlg;
	}

}
