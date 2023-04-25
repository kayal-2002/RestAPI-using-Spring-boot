package com.making.demo.service;

import java.util.List;

import com.making.demo.entity.CollegeFriends;

public interface CollegeService {
   List<CollegeFriends> getall(); 
   CollegeFriends save(CollegeFriends clg);
   CollegeFriends update(CollegeFriends clg);
   CollegeFriends getFriendById(Long id);
   void delete(Long id);
Object findByEmail(String email);
}
