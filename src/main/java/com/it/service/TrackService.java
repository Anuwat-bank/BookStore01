package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.it.dto.TrackDTO;

import com.it.entity.TrackEntity;
import com.it.repository.TrackRepository;

@Service
public class TrackService {
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private TrackRepository trackRepository;
	

	public List<TrackDTO> findTrackAll(){
		List<TrackEntity> roEntities = trackRepository.findAll();
		return modelMapper.map(roEntities, new TypeToken<List<TrackDTO>>() {}.getType());
	}
	
	public TrackDTO findTrackByTrackId(Integer trackId) {
		Optional<TrackEntity> traOnt = trackRepository.findById(trackId);
		if (traOnt.isPresent()) {
			return modelMapper.map(traOnt.get(), new TypeToken<TrackDTO>() {}.getType());
		}
		return null;
	}
	
	public boolean saveTrack(TrackDTO trackDTO) {
        boolean saveFlg = false;
        try {
        	TrackEntity entity = modelMapper.map(trackDTO, TrackEntity.class);
            trackRepository.save(entity);
            saveFlg = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveFlg;
    }
	
	public boolean updateTrack(Integer trackId,  TrackDTO trackDTO) {
		boolean updateFlg  = false;
		try {
			Optional<TrackEntity> traOnt = trackRepository.findById(trackId);
			if (traOnt.isPresent()) {
				TrackEntity entity = modelMapper.map(trackDTO, TrackEntity.class);
				entity.setTrackId(trackId);
				trackRepository.save(entity);
				updateFlg = true;
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return updateFlg;
		
	}
	
	public boolean deleteTrack(Integer trakId) {
		boolean deleteFlg = false;
		try {
			trackRepository.deleteById(trakId);
			deleteFlg = true;
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return deleteFlg;
	}

	
	

}
