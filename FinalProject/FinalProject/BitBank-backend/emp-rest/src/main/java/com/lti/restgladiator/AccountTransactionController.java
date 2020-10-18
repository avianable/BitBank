package com.lti.restgladiator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entitygladiator.AccountTransaction;
import com.lti.servicegladiator.AccounTransactionService;

@CrossOrigin
@RestController
public class AccountTransactionController {

	@Autowired
	private AccounTransactionService service;
	
	@PostMapping(value = "/transfer/{senderAccountNumber}/{receiverAccountNumber}/{money}")
	public void transferFundToAccountNumber(@PathVariable int senderAccountNumber,@PathVariable int receiverAccountNumber,
			@PathVariable double money) throws Exception {
 		
      		service.transferFundsToAccount(senderAccountNumber, receiverAccountNumber, money);
		
//	    	return "Money sent successfully";
	}
	
	
	@GetMapping(value = "/statement/{accNumber}", produces = "application/json")
	public List<AccountTransaction> listTxn(@PathVariable int accNumber){
		
		return service.fetchTransactionByAccNumber(accNumber);
	
	}
}
