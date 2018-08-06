package com.cg.plp.testcases;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.cg.plp.bean.Account;
import com.cg.plp.exception.AccountException;
import com.cg.plp.service.AccountService;
import com.cg.plp.service.IAccountService;

public class AccountTest {
	Account acc = new Account();
	IAccountService service;

	@Before
	public void init() {
		service = new AccountService();
	}
	@Test
	public void testValidateMobile()  {
		
		acc.setCustName("Pravallika");
		acc.setPhoneNum("3333344447");
		acc.setBal(50000.00);
		acc.setGender("female");
		acc.setEmailId("pravallika@gmail.com");
		acc.setDoj(Date.valueOf(LocalDate.now()));
		try {
			service.validateMobile(acc.getPhoneNum());
				
		} catch (AccountException e) {
		    System.err.println(e.getMessage());
			assertEquals("please enter mobile number with 10 digits",e.getMessage());
		
		}
		
	}
	
	@Test
	public void testValidateName(){
		acc.setCustName("Pravallika");
		acc.setPhoneNum("3333344444");
		acc.setBal(50000.00);
		acc.setGender("female");
		acc.setEmailId("pravallika@gmail.com");
		acc.setDoj(Date.valueOf(LocalDate.now()));
		try {
			
			service.validateName(acc.getCustName());
		} catch (AccountException e) {
			System.err.println(e.getMessage());
		assertEquals("Name should not be empty",e.getMessage());
		
	}
  }
	
	@Test
	public void testValidateNameWithCondition(){
		acc.setCustName("Pravallik");
		acc.setPhoneNum("3333344444");
		acc.setBal(50000.00);
		acc.setGender("female");
		acc.setEmailId("pravallika@gmail.com");
		acc.setDoj(Date.valueOf(LocalDate.now()));
	
		try {
			service.validateName(acc.getCustName());
		} catch (AccountException e) {
			System.err.println(e.getMessage());
		assertEquals("Name should start with capital letters and contain only characters",e.getMessage());
	}
  }
	
	@Test
	public void testValidateEmailId(){
		acc.setCustName("Pravallika");
		acc.setPhoneNum("3333344444");
		acc.setBal(50000.00);
		acc.setGender("female");
		acc.setEmailId("pravallika@gmail.com");
		acc.setDoj(Date.valueOf(LocalDate.now()));
		try{
			service.validateEmailId(acc.getEmailId());
			
		}catch(AccountException e){
			System.err.println(e.getMessage());
			assertEquals("please enter the emailId",e.getMessage());
		}
	}
	
	@Test
	public void testValidateEmailIdCheckProper(){
		acc.setCustName("Pravallika");
		acc.setPhoneNum("3333344444");
		acc.setBal(50000.00);
		acc.setGender("female");
		acc.setEmailId("pravallika@gmail.com");
		acc.setDoj(Date.valueOf(LocalDate.now()));
		try{
			service.validateEmailId(acc.getEmailId());
		}catch(AccountException e){
			System.err.println(e.getMessage());
			assertEquals("please enter valid emailid",e.getMessage());
		}
	}
	
	@Test
	public void testBal(){
		acc.setCustName("Pravallika");
		acc.setPhoneNum("3333344444");
		acc.setBal(50000.00);
		acc.setGender("female");
		acc.setEmailId("pravallika@gmail.com");
		acc.setDoj(Date.valueOf(LocalDate.now()));
		try {
			service.validateBalance(acc.getBal());
				
			
		
		} catch (AccountException e) {
			System.err.println(e.getMessage());
			assertEquals("please enter valid number",e.getMessage());
		}
	}

	@Test
	public void testCreateAcc(){
		acc.setCustName("Pravallika");
		acc.setPhoneNum("3333344444");
		acc.setBal(50000.00);
		acc.setGender("female");
		acc.setEmailId("hello@gmail.com");
		acc.setDoj(Date.valueOf(LocalDate.now()));
		try {
			service.createAcc(acc);
				
			
			
		} catch (AccountException e) {
		
			
		}
	}
	@Test
	public void testCreateAcc1(){
		acc.setCustName("Sunny");
		acc.setPhoneNum("1111122222");
		acc.setBal(30000.00);
		acc.setGender("male");
		acc.setEmailId("sunny@gmail.com");
		acc.setDoj(Date.valueOf(LocalDate.now()));
		try {
			service.createAcc(acc);
				
			
			
		} catch (AccountException e) {
		
			
		}
	}
	
	@Test
	public void testShowBal() {
		acc.setPhoneNum("3333344444");
		try {
			service.showBal(acc.getPhoneNum());
		} catch (AccountException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void testDepositCheckAccount(){
	acc.setPhoneNum("1111122222");
	double dep=1500.00;
	try{
	service.withdraw(acc.getPhoneNum(),dep);
	}catch(AccountException e){
	assertEquals("Account balance is Low",e.getMessage());
	}
	}
	
	@Test
	public void testDepositCheckmobile(){
	acc.setPhoneNum("1111122222");
	double dep=1500.00;
	try{
		service.validateMobile(acc.getPhoneNum());
	}catch(AccountException e){
	assertEquals("please enter mobile number with 10 digits",e.getMessage());
	}
	}
	
	@Test
	public void testDepositCheckAmount(){
	acc.setPhoneNum("1111122222");
	double dep=1500.00;
	try{
		service.validateBalance(dep);
	}catch(AccountException e){
	System.err.println(e.getMessage());
	assertEquals("please enter valid number",e.getMessage());
	}
	}
	
	@Test
	public void testDeposit(){
	acc.setPhoneNum("3333344444");
	double dep=1500.00;
	try{
		service.deposit(acc.getPhoneNum(),dep);
		System.out.println("Amount is deposited successfully");
	}catch(AccountException e){
	System.err.println(e.getMessage());
	}
	}
	
	
	@Test
	public void testWithdrawCheckMobile(){
	acc.setPhoneNum("1111122222");
	double dep=1500.00;
	try{
		service.validateMobile(acc.getPhoneNum());
	}catch(AccountException e){
	System.err.println(e.getMessage());
	assertEquals("please enter mobile number with 10 digits",e.getMessage());
	}
	}
	
	
	@Test
	public void testWithdrawCheckAmount(){
	acc.setPhoneNum("1111122222");
	double dep=1500.00;
	try{
		service.validateBalance(dep);
	}catch(AccountException e){
	System.err.println(e.getMessage());
	assertEquals("please enter valid number",e.getMessage());
	}
	}
	
	@Test
	public void testWithdrawCheckAmountBal(){
	acc.setPhoneNum("3333344444");
	double dep=50000.00;
	try{
		service.withdraw(acc.getPhoneNum(),dep);
	}catch(AccountException e){
	assertEquals("Account Does not exist",e.getMessage());
	}
	}
	@Test
	public void testWithdraw(){
	acc.setPhoneNum("3333344444");
	double dep=500.00;
	try{
		service.deposit(acc.getPhoneNum(),dep);
		System.out.println("Amount is withdrawn successfully");
	}catch(AccountException e){
	System.err.println(e.getMessage());
	}
	}
	
	@Test
	public void testFundTransferCheckPhone1(){
		Account acc1=new Account();
		Account acc2=new Account();
		acc1.setPhoneNum("1111122222");
		acc2.setPhoneNum("3333344444");
		double money=1230.00;
		try {
			service.validateMobile(acc1.getPhoneNum());
		} catch (AccountException e) {
		
			assertEquals("please enter mobile number with 10 digits",e.getMessage());
		}
	}
	@Test
	public void testFundTransferCheckPhone2(){
		Account acc1=new Account();
		Account acc2=new Account();
		acc1.setPhoneNum("1111122222");
		acc2.setPhoneNum("3333344444");
		double money=1230.00;
		try {
			service.validateMobile(acc2.getPhoneNum());
		} catch (AccountException e) {
			
			assertEquals("please enter mobile number with 10 digits",e.getMessage());
		}
	}
	@Test
	public void testFundTransferCheckBal(){
		Account acc1=new Account();
		Account acc2=new Account();
		acc1.setPhoneNum("1111122222");
		acc2.setPhoneNum("3333344444");
		double money=1230.00;
		try {
		 service.validateBalance(money);
		}catch(AccountException e){
	
		assertEquals("Amount must be a number greater than zero",e.getMessage());
		}
		
	}
	
	@Test
	public void testFundTransferCheckAccount1(){
		Account acc1=new Account();
		Account acc2=new Account();
		acc1.setPhoneNum("1111122222");
		acc2.setPhoneNum("3333344444");
		double money=1230.00;
		try {
			service.fundTransfer(acc1.getPhoneNum(),acc2.getPhoneNum(), money);
		}catch(AccountException e){
		
		assertEquals("Account does not exist",e.getMessage());
		}
		
	}
	@Test
	public void testFundTransferCheckAccount2(){
		Account acc1=new Account();
		Account acc2=new Account();
		acc1.setPhoneNum("1111122222");
		acc2.setPhoneNum("3333355555");
		double money=1230.00;
		try {
			service.fundTransfer(acc1.getPhoneNum(),acc2.getPhoneNum(), money);
		}catch(AccountException e){

		assertEquals("Account does not exist",e.getMessage());
		}
		
	}
	
	@Test
	public void testFundTransferCheckBalAcc1(){
		Account acc1=new Account();
		Account acc2=new Account();
		acc1.setPhoneNum("1111122222");
		acc2.setPhoneNum("3333344444");
		double money=2234.00;
		try {
			service.fundTransfer(acc1.getPhoneNum(),acc2.getPhoneNum(), money);
		}catch(AccountException e){
		assertEquals("Account does not exist",e.getMessage());
		}
		
	}
	@Test
	public void testFundTransfer(){
		Account acc1=new Account();
		Account acc2=new Account();
		acc1.setPhoneNum("1111122222");
		acc2.setPhoneNum("3333344444");
		double money=1230.00;
		try {
			service.fundTransfer(acc1.getPhoneNum(),acc2.getPhoneNum(), money);
			System.out.println("Amount transfered successfully");
		}catch(AccountException e){
		System.err.println(e.getMessage());
		}
		
	}
	
	@Test
	public void testPrintDetails(){
		acc.setPhoneNum("1111122222");
		try {
			service.getDetails(acc.getPhoneNum());
			System.out.println("Details are printed successfully");
		} catch (AccountException e) {
			assertEquals("Account does not exist",e.getMessage());
		}
	}
}
