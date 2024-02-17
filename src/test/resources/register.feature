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