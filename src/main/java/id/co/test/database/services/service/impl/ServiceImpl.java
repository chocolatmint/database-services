package id.co.test.database.services.service.impl;

import id.co.test.database.services.dao.CustomerDAO;
import id.co.test.database.services.domain.Customer;
import id.co.test.database.services.dto.CustomerRequestDTO;
import id.co.test.database.services.dto.Response;
import id.co.test.database.services.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{
	
	CustomerDAO customerDAO;
	
	@Autowired
	public ServiceImpl (CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public Customer getCustomer(String idCustomer) {
		return customerDAO.getCustomerByCustomerId(idCustomer);
	}

	@Override
	public Response saveCustomer(CustomerRequestDTO request) throws Exception {
		Customer customer = new Customer();
		customer.setName(request.getName());
		customer.setPhone(request.getAlamat());
		
		customerDAO.save(customer);
		
		return Response.newSuccessResponse();
	}

	@Override
	public Response updateCustomer(String idCustomer, CustomerRequestDTO request) throws Exception {
		Customer customer = customerDAO.getCustomerByCustomerId(idCustomer);

		if (customer != null) {
			customer.setName(request.getName());
			customer.setPhone(request.getAlamat());

			customerDAO.save(customer);
		}

		return Response.newSuccessResponse();
	}

	@Override
	public Response deleteCustomer(String idCustomer) throws Exception {
		customerDAO.deleteCustomerByCustomerId(idCustomer);

		return Response.newSuccessResponse();
	}

}
