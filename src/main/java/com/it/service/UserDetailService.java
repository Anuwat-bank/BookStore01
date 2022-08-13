package com.it.service;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.UserDTO;
import com.it.dto.UserDetailsDTO;
import com.it.entity.UserDetailEntity;
import com.it.entity.UserEntity;
import com.it.repository.UserDetailRepository;
import com.it.repository.UserRepository;
@Service
public class UserDetailService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserDetailRepository userDetailRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserDetailsDTO> findUserDetailAll(){
		List<UserDetailEntity> userDetailEntities = userDetailRepository.findAll();
		return modelMapper.map(userDetailEntities, new TypeToken<List<UserDetailsDTO>>() {}.getType());
	}

	
	
	public UserDetailsDTO findUserDetailByuserDetailId(Integer userId) {
		UserDetailEntity userEntity =  userDetailRepository.findByUserId(userId);
		if(userEntity != null) {
			return modelMapper.map(userEntity, new TypeToken<UserDetailsDTO>() {}.getType());
		}
		return null;
	} 
	
	 
	
	public boolean saveUserDetail(UserDetailsDTO userDetailDTO) {
        boolean saveFlg = false;
        try {
        	
        	UserEntity userEntity = modelMapper.map(userDetailDTO, UserEntity.class);
        	userEntity = userRepository.save(userEntity);
        	
        	UserDetailEntity userDetailentity = modelMapper.map(userDetailDTO, UserDetailEntity.class);
        	userDetailentity.setUserId(userEntity.getUserId());
            userDetailRepository.save(userDetailentity);
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
	
	public List<UserDetailsDTO> findAllByStatus(String recordStatus) {
		List<UserDetailEntity> userDeEntities = userDetailRepository.getAllByStatus(recordStatus);
		return modelMapper.map(userDeEntities, new TypeToken<List<UserDetailEntity>>() {
		}.getType());
	}
	
	
	public UserDetailsDTO findByCid(Integer cId) {
		UserDetailEntity userEntity =  userDetailRepository.findBycId(cId);
		if(userEntity != null) {
			return modelMapper.map(userEntity, new TypeToken<UserDetailsDTO>() {}.getType());
		}
		return null;
	} 
	
	public UserDetailsDTO findUserDetailByUserId(Integer userId) {
		UserDetailEntity userEntity =  userDetailRepository.findUserDetailByUserId(userId);
		if(userEntity != null) {
			return modelMapper.map(userEntity, new TypeToken<UserDetailsDTO>() {}.getType());
		}
		return null;
	} 
	
}