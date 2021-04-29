package id.co.test.database.services.domain;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq_gen")
	@SequenceGenerator(name="customer_id_seq_gen", sequenceName = "customer_id_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	public Long id;
	
	@Column(name = "name", nullable = false)
	public String name;
	
	@Column(name = "phone", nullable = false)
	public String phone;

	public Long getId() { return id; }

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone (String phone) { this.phone = phone; }
	
	
}
