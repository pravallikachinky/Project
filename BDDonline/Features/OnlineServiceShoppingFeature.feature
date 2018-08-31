Feature: Test Online shop service

@create
Scenario: User wants to test the service of online shop

When User give call to '/sayHello' service
Then user should receive status 'ok' And response message 'Hello World From RestFulWebService'

When user submit valid product details
Then product successfully added message should be displayed

When user wants to fetch details of all products
Then fetched succesfully message should be displayed

When user gives an Id
Then user should receive details of that product 
