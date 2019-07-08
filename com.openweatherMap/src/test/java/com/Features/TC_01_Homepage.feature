Feature: Logging into CRM



@Home
Scenario Outline: Verify labels is in homepage
Given user is in openweathermap homepage
Then verify "<menuName>" in homepage 
Examples:
| menuName |
| Weather  |
| Maps     |
| Guide    |
|  API     |
| Price    |
| Partners |
| Stations | 
|  Widgets |
|  Blog    |



