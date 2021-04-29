package id.co.test.database.services.dao;

import id.co.test.database.services.domain.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomerDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	public Customer getCustomerByCustomerId(String customerId) {
		TypedQuery<Customer> q = entityManager.createQuery("from Customer where id = :customerId", Customer.class);
		q.setParameter("customerId", Long.parseLong(customerId));
		q.setMaxResults(1);
		
		try {
			return q.getSingleResult();
		} catch (NoResultException n) {
			return null;
		}
	}
	
	public void save(Customer entity) throws Exception {
		try {
			if (entity.getId() != null) {
				entityManager.merge(entity);
			} else {
				entityManager.persist(entity);
			}
		} catch(Exception e) {
			throw new Exception();
		}
	}

	public void deleteCustomerByCustomerId(String id) throws Exception {
		try {
			Query q = entityManager.createNativeQuery("delete from Customer where id = :id", Customer.class);
			q.setParameter("id", Long.parseLong(id));
			q.executeUpdate();
		} catch (Exception e){
			throw new Exception();
		}
	}
}
