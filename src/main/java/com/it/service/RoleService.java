package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.it.dto.RoleDto;

import com.it.entity.RoleEntity;
import com.it.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<RoleDto> findRoleAll(){
		List<RoleEntity> roEntities = roleRepository.findAll();
		return modelMapper.map(roEntities, new TypeToken<List<RoleDto>>() {}.getType());
	}
	
	public RoleDto findRoleByRoleId(Integer roleId) {
		Optional<RoleEntity> roOnt = roleRepository.findById(roleId);
		if (roOnt.isPresent()) {
			return modelMapper.map(roOnt.get(), new TypeToken<RoleDto>() {}.getType());
		}
		return null;
	}
	
	public boolean saveRole(RoleDto roleDto) {
        boolean saveFlg = false;
        try {
        	RoleEntity entity = modelMapper.map(roleDto, RoleEntity.class);
            roleRepository.save(entity);
            saveFlg = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveFlg;
    }
	
	public boolean updateRole(Integer roleId,  RoleDto roleDto) {
		boolean updateFlg  = false;
		try {
			Optional<RoleEntity> roOnt = roleRepository.findById(roleId);
			if (roOnt.isPresent()) {
				RoleEntity entity = modelMapper.map(roleDto, RoleEntity.class);
				entity.setRoleId(roleId);
				roleRepository.save(entity);
				updateFlg = true;
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return updateFlg;
		
	}
	
	public boolean deleteRole(Integer roleId) {
		boolean deleteFlg = false;
		try {
			roleRepository.deleteById(roleId);
			deleteFlg = true;
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return deleteFlg;
	}


}
