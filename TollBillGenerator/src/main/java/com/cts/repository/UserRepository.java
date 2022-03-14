package com.cts.repository;
//Repository for user
import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    //Repository method for getting user by username and password
	public User findByUuserNameAndUpassword(String uuserName, String upassword);

}
