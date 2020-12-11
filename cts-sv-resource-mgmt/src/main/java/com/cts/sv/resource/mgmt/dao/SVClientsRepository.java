package com.cts.sv.resource.mgmt.dao;

import org.springframework.data.repository.CrudRepository;

import com.cts.sv.resource.mgmt.domain.SVCUser;



public interface SVClientsRepository extends CrudRepository<SVCUser, Long> {


}