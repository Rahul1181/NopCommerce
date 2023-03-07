Feature: Add Address

Scenario Outline: To validate add address functionality
Given user is on login page
When user enter "<username>" and "<password>" and click login button
Then users clicks on My account and user add new address "<firstName>" "<lastName>" "<email>" "<companyName>" "<city>" "<address1>" "<address2>" "<zipCode>" "<phoneNumber>" and click save button

Examples:
|username|password|firstName|lastName|email|companyName|city|address1|address2|zipCode|phoneNumber|
|rahulmandal@gmail.com|rahul123|RAHUL|MANDAL|rahulmandal@gmail.com|Wipro|Chennai|Shollingalur|Near Accenture|O6O119|O753456123O|







