package com.cts.repository;
//Repository for user feedback
import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.UserFeedback;

public interface UserFeedbackRepository extends JpaRepository<UserFeedback, Integer> {

}
