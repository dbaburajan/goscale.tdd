# goscale.tdd
## Test Assignment for GoScale
### Author : Darshan Baburajan <dbaburaj@Divya>

#### Dependencies
##### Logging
- slf4j-api-1.7.25.jar
- logback-classic-1.1.11.jar
- logback-core-1.1.11.jar
##### Readable logging
- commons.text-1.8.jar
- commons-lang3-3.9.jar

#### Workflow
- Create java project
- Create StringCalculator.java
	- 'add' method
	- cases
		- null input
		- empty input
		- one input
		- two inputs
		- more than 2 inputs
- Add slf4j log dependency
- Allow more than 2 inputs
- Allow 'new line' as delimiter '\n'
	- cases
		- one delimiter
		- multiple delimiters
- Support different delimiters
	- cases
		- ; delimiter
		- \n delimiter
		- any other delimiter (eg. &)
			- one character
			- two characters
- Throw exception for negative number
	- cases
		- one negative number
		- multiple negatives
- Get call count
- Ignore numbers greater than or equal to 1000
- Support delimiters of one character
- Support delimiters of any length
- Register event against add() method