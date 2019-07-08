Feature: Verify City search functionality


@Search
Scenario: Verify Search with invalid cityname
Given user is in openweathermap homepage
And I enter Invalid cityname to search
| InvalidCityName |
| Invalidcitydata |
And Click on Search button
Then Verify message NotFound


@Search
Scenario Outline: Verify Search with valid city
Given user is in openweathermap homepage 
And I enter valid "<cityName>" in Searchfield
And Click on Search button
Then Verify "<cityName>" in Home Page


Examples:
| cityName    |
| Navi Mumbai |

 