Feature: Test MyO2 simple flow

  Scenario: Verify Latest bill widget on My Mobile Page
    Given I login as valid user "011111082"
    Then I should see "Latest bill" widget
    And I should see bill summary as follows
      | £370.81 |
    And I should see bill details as follows
      | You were billed on | Payment was due on | Balance |
      | 16 May 2014        | 28 May 2014        | £207.00 |
    And I should see balance info icon on widget
    And I should see the "View latest bill" button on widget
    Then I should see page name as "O2 | My Bills"
    Then I should see Device number as "07011111082"
    Then I should see Billing period as "16 May 2014"
    Then I should see Tariff charges as "£85.61"
    Then I should see Monthly extras as "£40.20"
    Then I should see Sub total of tariff as "£125.81"
    Then I should see Minutes as "£31.10"
    Then I should see Messages as "£4.00"
    Then I should see Data as "0"
    Then I should see Charges when abroad as "£15.70"
    Then I should see Premium & information services as "£3.60"
    Then I should see Things you've bought as "£4.00"
    Then I should see Sub total as "£64.52"
    Then I should see Discounts as "£0.00"
    Then I should see Order charges as "£100.00"
    Then I should see Total before VAT as "£350.81"
    Then I should see VAT as "£20.00"
    Then I should see Total airtime bill as "£370.81"
