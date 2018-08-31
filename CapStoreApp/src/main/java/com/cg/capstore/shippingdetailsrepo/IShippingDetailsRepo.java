package com.cg.capstore.shippingdetailsrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capstore.beans.CustomerBean;

public interface IShippingDetailsRepo extends JpaRepository<CustomerBean, String> {

	
	@Query("SELECT c FROM CustomerBean c WHERE c.email=(:email)")
	public CustomerBean getCustDetails(@Param(value="email") String email);
}
