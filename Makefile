SHELL := /bin/bash
.PHONY: test install run help

test:	##	Execute all test
	@mvn clean verify

run:	##	Run application with maven
	@mvn clean install
	@mvn --projects backend spring-boot:run