package com.social.media.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.social.media.user.domain.SMUser;



public interface UserRepository extends CrudRepository<SMUser, Long> {


}