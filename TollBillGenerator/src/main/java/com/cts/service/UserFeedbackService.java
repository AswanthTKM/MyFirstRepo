package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.entity.UserFeedback;
import com.cts.repository.UserFeedbackRepository;

@Service
@Transactional
public class UserFeedbackService {

	@Autowired
	private UserFeedbackRepository repo;

	public void saveUserFeedback(UserFeedback userFeedback) {
		repo.save(userFeedback);
	}

	public List<UserFeedback> showAllUserFeedback() {
		return repo.findAll();
	}
}
