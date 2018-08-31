package com.cg.stepdefinition;



import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.cg.beans.Product;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class OnlineFeatureStepDefinition {
 private TestRestTemplate restTemplate;
 private ResponseEntity<String> responseEntity;
 private ResponseEntity<Product> responseEntityProduct;
 private ResponseEntity<List> responseEntityList; 
 @Before
 public void setUpTestEnv() {
	 restTemplate=new TestRestTemplate();
 }
 
	
	@When("^User give call to '/sayHello' service$")
	public void user_give_call_to_sayHello_service() throws Throwable {
	    responseEntity=restTemplate.getForEntity("http://localhost:9000/sayHello", String.class);
	}

	@Then("^user should receive status 'ok' And response message 'Hello World From RestFulWebService'$")
	public void user_should_receive_status_ok_And_response_message_Hello_World_From_RestFulWebService() throws Throwable {
	   // Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	  //  Assert.assertEquals("Hello World From RestFulWebService",responseEntity.getBody());
	 Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	 Assert.assertEquals("Hello world from restfulWebService",responseEntity.getBody());
		
	}
	
	@When("^user submit valid product details$")
	public void user_submit_valid_product_details() throws Throwable {
	    Product product= getProduct();
	    MultiValueMap<String, Object> map=new LinkedMultiValueMap<String,Object>();
	    map.add("id", product.getId());
	    map.add("name",product.getName());
	    map.add("model",product.getModel());
	    map.add("price",Double.toString(product.getPrice()));
	    map.add("manufacturingDate", product.getManufacturingDate());
	    HttpHeaders header=new HttpHeaders();
	    header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	    HttpEntity<MultiValueMap<String, Object>> httpEntity=new HttpEntity<>(map,header);
	    responseEntityProduct=restTemplate.postForEntity("http://localhost:9000/acceptProductDetails",httpEntity, Product.class);
	}

	@Then("^product successfully added message should be displayed$")
	public void product_successfully_added_message_should_be_displayed() throws Throwable {
	    Product expectedProduct=getProduct();
	    Product actualProduct=responseEntityProduct.getBody();
	    Assert.assertEquals(expectedProduct, actualProduct);
	    
	    }

 private Product getProduct() {
	 return new Product("i06","iphone","iphone6",40000,"05-Jun-2017");
 }
  
 @When("^user wants to fetch details of all products$")
 public void user_wants_to_fetch_details_of_all_products() throws Throwable {
     responseEntityList=restTemplate.getForEntity("http://localhost:9000/display",List.class);
 }

 @Then("^fetched succesfully message should be displayed$")
 public void fetched_succesfully_message_should_be_displayed() throws Throwable {
     Assert.assertEquals(HttpStatus.OK, responseEntityList.getStatusCode());
 }


@When("^user gives an Id$")
public void user_gives_an_Id() throws Throwable {
    responseEntityProduct=restTemplate.getForEntity("http://localhost:9000/findProduct?id=v01",Product.class);
}

@Then("^user should receive details of that product$")
public void user_should_receive_details_of_that_product() throws Throwable {
	 Assert.assertEquals(HttpStatus.OK, responseEntityProduct.getStatusCode());
}

}
