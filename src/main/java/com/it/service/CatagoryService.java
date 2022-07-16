package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.it.dto.CatagorysDTO;

import com.it.entity.CatagoryEntity;
import com.it.repository.CatagoryRepository;

@Service
public class CatagoryService {
	

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CatagoryRepository catagoryRepository;
	
	public List<CatagorysDTO> findCatagoryAll(){
		List<CatagoryEntity> cateEntities = catagoryRepository.findAll();
		return modelMapper.map(cateEntities, new TypeToken<List<CatagorysDTO>>() {}.getType());
	}

	
	public CatagorysDTO findCateByCateId(Integer cateId) {
		Optional<CatagoryEntity> cateOnt = catagoryRepository.findById(cateId);
		if (cateOnt.isPresent()) {
			return modelMapper.map(cateOnt.get(), new TypeToken<CatagorysDTO>() {}.getType());
		}
		return null;
	}
	
	public boolean saveCatagory(CatagorysDTO catagorysDTO) {
        boolean saveFlg = false;
        try {
        	CatagoryEntity  entity = modelMapper.map(catagorysDTO, CatagoryEntity.class);
            catagoryRepository.save(entity);
            saveFlg = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveFlg;
    }
	
	public boolean updateCatagory(Integer cateId, CatagorysDTO catagorysDTO) {
		boolean updateFlg  = false;
		try {
			Optional<CatagoryEntity> cateOnt = catagoryRepository.findById(cateId);
			if (cateOnt.isPresent()) {
				CatagoryEntity entity = modelMapper.map(catagorysDTO, CatagoryEntity.class);
				entity.setCateId(cateId);;
				catagoryRepository.save(entity);
				updateFlg = true;
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return updateFlg;
		
	}
	
	public boolean deleteCatagory(Integer cateId) {
		boolean deleteFlg = false;
		try {
			catagoryRepository.deleteById(cateId);
			deleteFlg = true;
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return deleteFlg;
	}
	
}
