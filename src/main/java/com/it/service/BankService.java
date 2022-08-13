package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.BanksDTO;

import com.it.entity.BankEntity;

import com.it.repository.BankRepository;
@Service
public class BankService {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private BankRepository bankRepository;
	
	public List<BanksDTO> findBanksAll(){
		List<BankEntity> bankEntities = bankRepository.findAll();
		return modelMapper.map(bankEntities, new TypeToken<List<BanksDTO>>() {}.getType());
	}
	
	
	public BanksDTO findBanksByBankId(Integer bankId) {
		Optional<BankEntity> bankOnt = bankRepository.findById(bankId);
		if (bankOnt.isPresent()) {
			return modelMapper.map(bankOnt.get(), new TypeToken<BanksDTO>() {}.getType());
		}
		return null;
	}
	
	public boolean saveBank(BanksDTO banksDTO) {
        boolean saveFlg = false;
        try {
        	BankEntity entity = modelMapper.map(banksDTO, BankEntity.class);
            bankRepository.save(entity);
            saveFlg = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveFlg;
    }
	public boolean updateBank(Integer bankId, BanksDTO banksDTO) {
		boolean updateFlg  = false;
		try {
			Optional<BankEntity> bankOnt = bankRepository.findById(bankId);
			if (bankOnt.isPresent()) {
				BankEntity entity = modelMapper.map(banksDTO, BankEntity.class);
				entity.setBankId(bankId);
				bankRepository.save(entity);
				updateFlg = true;
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return updateFlg;
		
	}
	
	public boolean deleteBank(Integer bankId) {
		boolean deleteFlg = false;
		try {
			bankRepository.deleteById(bankId);
			deleteFlg = true;
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return deleteFlg;
	}
	
	public List<BanksDTO> findBanksByUserId(Integer userId) {
		List<BankEntity> bankOnt = bankRepository.findByUserId(userId);
		if (null != bankOnt) {
			return modelMapper.map(bankOnt, new TypeToken <List<BanksDTO>>() {}.getType());
		}
		return null;
	}
}
