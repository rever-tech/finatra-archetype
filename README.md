Finatra Scala Template 

	+ Built-in config for development & production
	+ Built-in scala wrapped service
	+ Predefine project template with Result & Thrift for microservice
	
Usage:
	#Clone & Install Maven Archetype

		git clone git@github.com:zkidkid/scala-template.git <br/>
		cd <path>/scala-template <br/>
		mvn install archetype:update-local-catalog <br/>
	#Generate & Start projectx 	
		cd <path> <br/>
		mvn archetype:generate -B -DarchetypeGroupId=scala -DarchetypeArtifactId=finatra-archetype -DarchetypeVersion=1.0 -DgroupId=company -DartifactId=projectx -DpackageName=company.projectx  -DarchetypeCatalog=local
		cd projectx <br/>
		mvn package
		chmod +x runservice
		./runservice start -Dmode=development
		curl -XGET localhost:8080/ping
		./runservice stop
		


