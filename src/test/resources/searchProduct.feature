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