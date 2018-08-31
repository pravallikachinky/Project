package com.cg.capstore.shippingdetailsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capstore.beans.CustomerBean;
import com.cg.capstore.shippingdetailsrepo.IShippingDetailsRepo;

@Service
public class ShippingDetailsService implements IShippingDetailsService {

    @Autowired
	private IShippingDetailsRepo repo;
	
	@Override
	public CustomerBean shippingDetailsMsg(String email) {
		
		CustomerBean customerBean=repo.getCustDetails(email);
		
		return customerBean;
	}

}
