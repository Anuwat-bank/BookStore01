package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.it.dto.ReasonDTO;
import com.it.entity.ReasonEntity;
import com.it.repository.ReasonRepository;

@Service
public class ReasonService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ReasonRepository reasonRepository;
	
	public List<ReasonDTO> findReasonAll(){
		List<ReasonEntity> reasonEntities = reasonRepository.findAll();
		return modelMapper.map(reasonEntities, new TypeToken<List<ReasonDTO>>() {}.getType());
	}
	
	public ReasonDTO findReasonByReaId(Integer reId) {
		Optional<ReasonEntity> reaOnt = reasonRepository.findById(reId);
		if (reaOnt.isPresent()) {
			return modelMapper.map(reaOnt.get(), new TypeToken<ReasonDTO>() {}.getType());
		}
		return null;
	}
	
	public boolean saveReason(ReasonDTO reasonDTO) {
        boolean saveFlg = false;
        try {
        	ReasonEntity entity = modelMapper.map(reasonDTO, ReasonEntity.class);
            reasonRepository.save(entity);
            saveFlg = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveFlg;
    }
	
	public boolean updateReason(Integer reId,  ReasonDTO reasonDTO) {
		boolean updateFlg  = false;
		try {
			Optional<ReasonEntity> payOnt = reasonRepository.findById(reId);
			if (payOnt.isPresent()) {
				ReasonEntity entity = modelMapper.map(reasonDTO, ReasonEntity.class);
				entity.setReId(reId);;
				reasonRepository.save(entity);
				updateFlg = true;
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return updateFlg;
		
	}
	
	public boolean deleteReason(Integer reId) {
		boolean deleteFlg = false;
		try {
			reasonRepository.deleteById(reId);
			deleteFlg = true;
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return deleteFlg;
	}

	

}
