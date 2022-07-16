package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.it.dto.BooksDTO;

import com.it.entity.BookEntity;
import com.it.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<BooksDTO> findBookAll(){
		List<BookEntity> bookEntities = bookRepository.findAll();
		return modelMapper.map(bookEntities, new TypeToken<List<BooksDTO>>() {}.getType());
	}
	
	public BooksDTO findBookByBookId(Integer bId) {
		Optional<BookEntity> bookOnt = bookRepository.findById(bId);
		if (bookOnt.isPresent()) {
			return modelMapper.map(bookOnt.get(), new TypeToken<BooksDTO>() {}.getType());
		}
		return null;
	}

	
	public boolean saveBook(BooksDTO booksDTO) {
        boolean saveFlg = false;
        try {
        	BookEntity entity = modelMapper.map(booksDTO, BookEntity.class);
            bookRepository.save(entity);
            saveFlg = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveFlg;
    }
	
	public boolean updateBook(Integer bId, BooksDTO booksDTO) {
		boolean updateFlg  = false;
		try {
			Optional<BookEntity> bookOnt = bookRepository.findById(bId);
			if (bookOnt.isPresent()) {
				BookEntity entity = modelMapper.map(booksDTO, BookEntity.class);
				entity.setBId(bId);
				bookRepository.save(entity);
				updateFlg = true;
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return updateFlg;
		
	}
	
	public boolean deleteBook(Integer bId) {
		boolean deleteFlg = false;
		try {
			bookRepository.deleteById(bId);
			deleteFlg = true;
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return deleteFlg;
	}
}
