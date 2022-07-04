
Feature: Add new address

  Scenario Outline: Login and add new address
    Given I am at mystore page with valid user account
    When I sign using mail: swiderus@interia.pl password: jklopol1
    And Add new address clicking Addresses tile and then link to createNewAddress
    And Type alias in new address: <alias>
    And Type First name in new address: <First name>
    And Type Last name in new address: <Last name>
    And Type Address in new address: <Address>
    And Type City in new address: <City>
    And Type zip code in new address: <zip code>
    And Type phone number in new address: <phone number>
    And Save new address
    Then Find proper tile with new address, and compare data of alias, and compare data of <alias>, <First name>, <Last name>, <Address>, <City>, <zip code>, <country>, <phone number>


    Examples:
      | alias | First name | Last name | Address | City | zip code | country | phone number |
      | Dolas | Grzegorz | Brzeczyszczykiewicz | Moja 31 | Chrzaszczyrzewoszyce | 03-333 | United Kingdom | 123456789 |