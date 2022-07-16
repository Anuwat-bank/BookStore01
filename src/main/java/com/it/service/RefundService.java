package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.it.dto.RefundsDTO;

import com.it.entity.RefundEntity;
import com.it.repository.RefundRepository;

@Service
public class RefundService {

	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RefundRepository refundRepository;
	
	public List<RefundsDTO> findRefunAll(){
		List<RefundEntity> refEntities = refundRepository.findAll();
		return modelMapper.map(refEntities, new TypeToken<List<RefundsDTO>>() {}.getType());
	}
	
	public RefundsDTO findRefunByRfId(Integer rfId) {
		Optional<RefundEntity> refOnt = refundRepository.findById(rfId);
		if (refOnt.isPresent()) {
			return modelMapper.map(refOnt.get(), new TypeToken<RefundsDTO>() {}.getType());
		}
		return null;
	}
	
	public boolean saveRefun(RefundsDTO refundsDTO) {
        boolean saveFlg = false;
        try {
        	RefundEntity entity = modelMapper.map(refundsDTO, RefundEntity.class);
            refundRepository.save(entity);
            saveFlg = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveFlg;
    }
	
	public boolean updateRefun(Integer rfId,  RefundsDTO reasonDTO) {
		boolean updateFlg  = false;
		try {
			Optional<RefundEntity> refOnt = refundRepository.findById(rfId);
			if (refOnt.isPresent()) {
				RefundEntity entity = modelMapper.map(reasonDTO, RefundEntity.class);
				entity.setRfId(rfId);
				refundRepository.save(entity);
				updateFlg = true;
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return updateFlg;
		
	}
	
	
	public boolean deleteRefun(Integer rfId) {
		boolean deleteFlg = false;
		try {
			refundRepository.deleteById(rfId);
			deleteFlg = true;
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return deleteFlg;
	}

	
	
}
