package com.it.service;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.it.dto.UserDetailsDTO;
import com.it.entity.UserDetailEntity;
import com.it.repository.UserDetailRepository;
@Service
public class UserDetailService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserDetailRepository userDetailRepository;
	
	public List<UserDetailsDTO> findUserDetailAll(){
		List<UserDetailEntity> userDetailEntities = userDetailRepository.findAll();
		return modelMapper.map(userDetailEntities, new TypeToken<List<UserDetailsDTO>>() {}.getType());
	}

	
	
	public UserDetailsDTO findUserDetailByuserDetailId(Integer userDetailId) {
		Optional<UserDetailEntity> userDetailOnt =  userDetailRepository.findById(userDetailId);
		if(userDetailOnt.isPresent()) {
			return modelMapper.map(userDetailOnt.get(), new TypeToken<UserDetailsDTO>() {}.getType());
		}
		return null;
	} 
	
	public boolean saveUserDetail(UserDetailsDTO userDetailDTO) {
        boolean saveFlg = false;
        try {
        	UserDetailEntity entity = modelMapper.map(userDetailDTO, UserDetailEntity.class);
            userDetailRepository.save(entity);
            saveFlg = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveFlg;
    }
	
	public boolean updateUserDetail(Integer userDetailId, UserDetailsDTO userDetailsDTO) {
		boolean updateFlg  = false;
		try {
			Optional<UserDetailEntity> userDetailOnt = userDetailRepository.findById(userDetailId);
			if (userDetailOnt.isPresent()) {
				UserDetailEntity entity = modelMapper.map(userDetailsDTO, UserDetailEntity.class);
				entity.setUserDetailId(userDetailId);
				userDetailRepository.save(entity);
				updateFlg = true;
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return updateFlg;
		
	}
	
	public boolean deleteUserDetailByUserDetailId(Integer userDetailId) {
		boolean deleteFlg = false;
		try {
			userDetailRepository.deleteById(userDetailId);
			deleteFlg = true;
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return deleteFlg;
	}
	
	
}