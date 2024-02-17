   
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