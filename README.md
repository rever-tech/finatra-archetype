Finatra Scala Template 

	+ Built-in config for development & production
	+ Built-in scala wrapped service
	+ Predefine project template with Result & Thrift for microservice
	
Usage:
	

		git clone git@github.com:rever-tech/finatra-archetype.git
		cd <path>/scala-template
		mvn install archetype:update-local-catalog
	
		cd <path>
		mvn archetype:generate -B -DarchetypeGroupId=scala 	\
			-DarchetypeArtifactId=finatra-archetype 		\
			-DarchetypeVersion=1.0 -DgroupId=company 		\
			-DartifactId=projectx 							\
			-DpackageName=company.projectx  				\
			-DarchetypeCatalog=local
		cd projectx
		mvn package
		chmod +x runservice
		./runservice start -Dmode=development
		curl -XGET localhost:8080/ping
		./runservice stop
		


