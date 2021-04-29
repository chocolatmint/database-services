package id.co.test.database.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.test.database.services.domain.Customer;
import id.co.test.database.services.dto.CustomerRequestDTO;
import id.co.test.database.services.dto.Response;
import id.co.test.database.services.service.Service;

@RestController
@RequestMapping("/customer")
public class Controller {

	Service service;
	
	@Autowired
	public Controller (Service service) {
		this.service = service;
	}
	
	@GetMapping(value = "/{idCustomer}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomer (@PathVariable String idCustomer) {
		Customer customer = service.getCustomer(idCustomer);
		if (customer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> saveCustomer (@RequestBody CustomerRequestDTO request) {
		try {
			return new ResponseEntity<>(service.saveCustomer(request), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/update/{idCustomer}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> updateCustomer (@PathVariable String idCustomer, @RequestBody CustomerRequestDTO request) {
		try {
			return new ResponseEntity<>(service.updateCustomer(idCustomer, request), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/delete/{idCustomer}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> deleteCustomer (@PathVariable String idCustomer) {
		try {
			return new ResponseEntity<>(service.deleteCustomer(idCustomer), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
