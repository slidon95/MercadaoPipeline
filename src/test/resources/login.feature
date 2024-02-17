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