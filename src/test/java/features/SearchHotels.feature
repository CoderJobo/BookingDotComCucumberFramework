Feature: Search hotels on Booking.com

  Scenario Outline: As a user I want to search for hotels with a sauna
    Given I am navigated to Booking.com
    And I accept cookie preferences
    When I enter the location <location>
    And I enter my dates
    And I enter my guest room details <numAdults> <numChildren> <numRooms>
    And I click Search
    And I see my search results
    When I apply a filter for Spa and wellness centre
    And I apply a filter for Sauna
    Then the hotel <hotelListed> should be listed
    And the hotel <hotelNotListed> should not be listed

    Examples:
      | location | numAdults | numChildren | numRooms | hotelListed                             | hotelNotListed            |
      | Limerick | 4         | 0           | 1        | Maldron Hotel & Leisure Centre Limerick | Limerick Strand Hotel     |
      | Moscow   | 1         | 3           | 2        | Four Seasons Hotel Moscow               | Radisson Blu Belorusskaya |

  Scenario Outline: As a user I want to search for a hotel using a Star Rating filter
    Given I am navigated to Booking.com
    And I accept cookie preferences
    When I enter the location <location>
    And I enter my dates
    And I enter my guest room details <numAdults> <numChildren> <numRooms>
    And I click Search
    And I see my search results
    When I apply a <numStars> Star Rating filter
    Then the hotel <hotelListed> should be listed
    And the hotel <hotelNotListed> should not be listed

    Examples:
    | location | numAdults | numChildren | numRooms | numStars | hotelListed             | hotelNotListed            |
    | Limerick | 2         | 0           | 1        | 5        | The Savoy Hotel         | George Limerick Hotel     |
    | Paris    | 2         | 4           | 2        | 3        | Dauphine Saint Germain  | Pullman Paris Tour Eiffel |

