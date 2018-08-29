package com.cg.capstore.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="Transaction")
public class PaymentDetailsBean {

	@Id
	@Column(name="transaction_id")
	private String transactionId;
	
	@Column(name="transaction_date")
	private Date transactionDate;
	
	@Column(name="payment_amount")
	private Double paymentAmount;
	
	@Column(name="revenue")
	private Double capStoreRevenueAmount;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public Double getCapStoreRevenueAmount() {
		return capStoreRevenueAmount;
	}
	public void setCapStoreRevenueAmount(Double capStoreRevenueAmount) {
		this.capStoreRevenueAmount = capStoreRevenueAmount;
	}
}
	