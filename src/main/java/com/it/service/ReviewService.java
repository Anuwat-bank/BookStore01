package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.it.dto.ReviewsDTO;

import com.it.entity.ReviewEntity;
import com.it.repository.ReviewRepository;

@Service
public class ReviewService {

	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ReviewRepository  reviewRepository;
	
	public  List<ReviewsDTO> findReviewAll(){
		List<ReviewEntity> rvEntities = reviewRepository.findAll();
		return modelMapper.map(rvEntities, new TypeToken<List<ReviewsDTO>>() {}.getType());
	}
	
	public ReviewsDTO findReviewByRvId(Integer rvId) {
		Optional<ReviewEntity> rvfOnt = reviewRepository.findById(rvId);
		if (rvfOnt.isPresent()) {
			return modelMapper.map(rvfOnt.get(), new TypeToken<ReviewsDTO>() {}.getType());
		}
		return null;
	}
	
	public boolean saveReview(ReviewsDTO reviewsDTO) {
        boolean saveFlg = false;
        try {
        	ReviewEntity entity = modelMapper.map(reviewsDTO, ReviewEntity.class);
            reviewRepository.save(entity);
            saveFlg = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveFlg;
    }
	
	
	public boolean updateReview(Integer rvId,  ReviewsDTO reviewsDTO) {
		boolean updateFlg  = false;
		try {
			Optional<ReviewEntity> rvOnt = reviewRepository.findById(rvId);
			if (rvOnt.isPresent()) {
				ReviewEntity entity = modelMapper.map(reviewsDTO, ReviewEntity.class);
				entity.setRvId(rvId);
				reviewRepository.save(entity);
				updateFlg = true;
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return updateFlg;
		
	}
	
	public boolean deleteRefun(Integer rvId) {
		boolean deleteFlg = false;
		try {
			reviewRepository.deleteById(rvId);
			deleteFlg = true;
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return deleteFlg;
	}

	
}
