SHELL := /bin/bash
.PHONY: test install run help

test:	##	Execute all test
	@mvn clean verify

run:	##	Run application with maven
	@mvn clean install
	@mvn --projects backend spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=local"

release:
	./scripts/create_release.sh

hotfix: ##	Create hotfix
	./scripts/create_hotfix.sh