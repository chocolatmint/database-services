package id.co.test.database.services.service;

import id.co.test.database.services.domain.Customer;
import id.co.test.database.services.dto.CustomerRequestDTO;
import id.co.test.database.services.dto.Response;

public interface Service {

	Customer getCustomer(String idCustomer);
	
	Response saveCustomer(CustomerRequestDTO request) throws Exception;

	Response updateCustomer(String idCustomer, CustomerRequestDTO request) throws Exception;

	Response deleteCustomer(String idCustomer) throws Exception;

}
