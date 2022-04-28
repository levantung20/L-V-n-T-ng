package com.vti.repository;

import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vti.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {
	@Modifying
	@Transactional
	@Query("DELETE FROM Account WHERE id IN (:ids)")
	public void deleteByIds(@PathParam("ids") List<Integer> ids);

	public boolean existsByUsername(String username);

	public Account findByUsername(String username); // login username
	
	Page<Account> getAccountsByDepartmentIsNull(Pageable pageable);
	
	
	

}
