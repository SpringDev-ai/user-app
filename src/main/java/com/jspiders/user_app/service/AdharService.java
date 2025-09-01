package com.jspiders.user_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.user_app.dao.AdharDao;
import com.jspiders.user_app.entity.AdharCard;
import com.jspiders.user_app.entity.User;
import com.jspiders.user_app.repository.UserRepository;

@Service
public class AdharService {

//	@Autowired
//	private AdharDao adharDao;
//	
//	@Autowired
//	private UserRepository userRepository;
//
//	public AdharCard registerAdhar(AdharCard adhar, int userId) {
//		Optional<User> optional = userRepository.findById(userId);
//		if(optional.isPresent()) {
////			optional.get().setAdharCard(adhar);
//			AdharCard adhar2 = adharDao.registerAdhar(adhar);
//			return adhar2;
//		}
//		return null;
//	}
}
