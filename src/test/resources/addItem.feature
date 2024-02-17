   
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