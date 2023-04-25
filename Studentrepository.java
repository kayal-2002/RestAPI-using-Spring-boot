package com.making.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.making.demo.entity.CollegeFriends;

public interface Studentrepository extends JpaRepository<CollegeFriends,Long> {

	Optional<CollegeFriends> findByEmail(String email);

	

}
