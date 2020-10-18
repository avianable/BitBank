package com.lti.restgladiator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entitygladiator.Beneficiary;
import com.lti.servicegladiator.BeneficiaryService;

@CrossOrigin
@RestController
public class BeneficiaryRestController {

	@Autowired
	private BeneficiaryService service;
	
	@PostMapping(value = "/addbenef",consumes ="application/json")
	public String addBeneficiary(@RequestBody Beneficiary beneficiary) {
		service.addBeneficiary(beneficiary);
		return "Beneficiary added successfully";
	}

	@GetMapping(value = "/fetchbenef/{accountNo}", produces = "application/json")
	public  List<Beneficiary> fetchbeneficiary(@PathVariable int accountNo) {
		return service.FetchByAccountNumber(accountNo);
	}
	
	
	@GetMapping(value = "/listbenf", produces = "application/json")
	public List<Beneficiary> listBeneficiary(){
		return service.fetchAll();
	}
	
	@DeleteMapping("/delbenf/{id}")
	public String delEmployee(@PathVariable int id) {
		service.remove(id);
		return "Beneficiary deleted successfully";
	}
	
}