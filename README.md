# Introduction

Welcome to Rumos Expert Certification automation project. This project use Cucumber, Selenium(Java) and Allure to perform end-to-end testing of a web application. 

The primary objective of this project is to develop an automated test script for the Mercadao website (https://mercadao.pt/). The test script will cover the following features:

```python
  @register
  Feature: Register on Mercadao Store
 
  Scenario Outline: Test valid register
    Given I am at mercadao register page using "<browser>"
    When I insert valid data for register
    And I click to register button
    Then I will be at confirmation by email page "https://mercadao.pt/account/my-details"
    
       Examples: 
      | browser |
      | chrome  |
      | firefox |
```
```python
 @login
 Feature: Login on Mercadao Store
 
  Scenario Outline: Test valid login
    Given I am at mercadao login page using "<browser>"
    When I insert valid data
    And I click to sign in button
    Then I will be at dashboard "https://mercadao.pt/"
    And Will show on the right corner "Olá, Rumos"
   
       Examples: 
      | browser |
      | chrome  |
      | firefox |
```
```python
  @search
  Feature: Search and visualize product on Mercadao Store
  
  Scenario Outline: Test valid search 
    Given I at Store solmar-acores Mercadao using "<browser>"
    When  search for "Peixe" on search box
    And I press enter
    Then I will be at search dashboard "https://mercadao.pt/store/solmar-acores/search?queries=Peixe"
    And Select First Item and see the information
    
       Examples: 
      | browser |
      | chrome  |
      | firefox |

  ```
```python

   @add_to_cart
   Feature: Add item on Mercadao Store
  
  Scenario Outline: Test valid check out 
    Given I at Store solmar-acores Mercadao using "<browser>" and search for "Peixe"
    When I select the first item 
    And Buy the item
    And write the postal code "9500-764"
    And I click on my cart
    Then Verify if the item is on the cart
  
  
        Examples: 
      | browser |
      | chrome  |
      | firefox |
```
```python
   @check_out
   Feature: Add item on Mercadao Store
  
 Scenario Outline: Validate the checkout process
 Given I logged into Mercadao using "<browser>" and initiated a search, selected the "Conjunto 2 Cadeiras 1 Sofá e 1 Mesa de Apoio Etna Kilimanjaro" on Solmar-acores, and entered the postal code.
 When I click the checkOut button
 And choose Click & Collect and select the first address, and click Seguinte
 And pick a delivery time, then click Continue
 And opt for MB WAY and click Finalizar Compra
Then I should receive a message stating "Olá, a confirmação de pagamento foi enviada para a app do MB WAY do número 967716431. Deverá fazer a confirmação no tempo indicado. Se não fizer, deverá aguardar 10 minutos para o carrinho de compras ficar novamente disponível no Mercadão"

       Examples: 
      | browser |
      | chrome  |

```
## Requirements

- Java JDK 8 or higher
- Maven
- WebDriver for your preferred browser (Chrome, firefox and Edge)

## Project organization

In this project, there are 4 packages located in the src/test/java directory. 

![image](https://github.com/slidon95/MercadaoPipeline/assets/132678833/4d5d43be-8efc-4062-a8a6-3dd1dcdbff6d)


- The 'Config' package is dedicated to browser configuration. 

- The 'PageObjects' package, we have the following classes: 

     - AddCartPage - methods related to the addCart page; 
     - CheckOutPage - methods related to checkOut page;
     -  General - methods with general utility that can be applicable to all web pages;
     - GenerateRandomEmail - methods related to randomly generated email to be use on register;
     -  LoginPage - methods related to the login page;
     - RegisterPage - methods related to the register page;
     - SearchPage- methods related to the search page. 

- The 'mercadaoBDD' package, there is the 'TestRunner' used to execute tests and display results.

- In the 'mercadaoBDD.steps' package, you will find the 'AddToCartTest, CheckOutTest, LoginTest, RegisterTest, SearchTest' class utilizing methods from the classes created in the 'PageObjects' package. While it is possible to consolidate all the code directly into this class, I have opted for separation to facilitate potential reuse in alternative test scenarios and to improve overall readability.

In the src/test/java directory, you will find the 'addItem.feature, checkOut.feature, login.feature, register.feature, searchProdutfeature' a scenarios written in Gherkin, that provide a clear and understandable representation of test cases.

![image](https://github.com/slidon95/MercadaoPipeline/assets/132678833/8930f076-8816-493d-b08e-95bc37b9695d)

In the driver folder, you can locate the executable files for Chrome, firefox and Edge browsers.

![image](https://github.com/slidon95/MercadaoPipeline/assets/132678833/19d8f485-5a03-4a60-a3a5-7a04ce863d76)

On the target directory, you'll find the surefire_report containing the Allure reports generated for the tests.

![image](https://github.com/slidon95/MercadaoPipeline/assets/132678833/10701af5-3834-434d-9c29-ecebe828e2c3)

Lastly, there is the pom.xml which serves for dependencies, build configurations, and plugins.

![image](https://github.com/slidon95/MercadaoPipeline/assets/132678833/b621991b-63c0-435e-945b-6678148ffcd7)

## Running Tests

Ensure that the project is converted to TestNG, and then go to the project's root directory. Right-click on the project source, select 'Run As' and choose 'Maven Test'.

![image](https://github.com/slidon95/MercadaoPipeline/assets/132678833/d93498d9-33c4-4c5e-b635-ef3aeef20d86)


## Report and Run in Jenkins

Test reports are generated using Allure Report in Jenkins Pipeline.

https://github.com/slidon95/MercadaoPipeline/assets/132678833/9e0cf003-76f0-4cb6-bb93-67a47d1efee4


## DEMO

In this section, I will showcase a demo for each feature.

- Register

https://github.com/slidon95/MercadaoPipeline/assets/132678833/7cae18f0-151d-4130-aefd-97b927f79ed9

- Login

https://github.com/slidon95/MercadaoPipeline/assets/132678833/3d3ad4c1-1698-43c5-8b46-943c038bd9cc

- Search for a product

https://github.com/slidon95/MercadaoPipeline/assets/132678833/b31414c6-3763-4dd4-ad52-d4803453fc30

- Add an item to the cart

https://github.com/slidon95/MercadaoPipeline/assets/132678833/b56e25c2-d727-4f89-a2ff-989364b9913d

- Simulate Checkout

https://github.com/slidon95/MercadaoPipeline/assets/132678833/0e7aa486-d4f4-4760-918a-f68b2cb31074



