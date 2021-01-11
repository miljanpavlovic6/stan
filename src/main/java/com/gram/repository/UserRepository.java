package com.gram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import com.gram.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUserName(String userName);


}
