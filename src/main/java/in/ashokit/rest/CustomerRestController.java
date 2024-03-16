package in.ashokit.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Customer;

@RestController
public class CustomerRestController {
	@PostMapping(value="/customer", consumes="application/json",produces="text/plain")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer c){
		System.out.println(c);
		String body="Customer Saved...";
		return new ResponseEntity<>(body,HttpStatus.CREATED);
		
	}
	@PutMapping(value="/customer",consumes="application/json",produces="text/plain")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer c){
		System.out.println(c);
		String body="Customer Updated...";
		return new ResponseEntity<>(body,HttpStatus.OK);
	}
	@DeleteMapping(value="/customer",produces="text/plain")
	public ResponseEntity<String> deleteCustomer(@RequestParam("id") String name){ 
	String body="Customer Deleted...";
	return new ResponseEntity<>(body,HttpStatus.OK);
	}
	
	@GetMapping(value="/customer", produces="application/json")
	public Customer getCustomer() {
		Customer c=new Customer(101,"Smith","smith@gmail.com");
		return c;	
	}
	@GetMapping(value="/customers",produces="application/json")
	public List<Customer> getCustomers(){
		Customer c1=new Customer(101,"John","john@gmail.com");
		Customer c2=new Customer(102,"David","david@gmail.com");
		Customer c3=new Customer(103,"Mark","mark@gmail.com");
		Customer c4=new Customer(104,"Samuel","samuel@gmail.com");
		Customer c5=new Customer(105,"Tony","tony@gmail.com");
		List<Customer> customers = Arrays.asList(c1,c2,c3,c4,c5);
		return customers;
	}

}
