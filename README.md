Finatra Scala Template 

	+ Built-in config for development & production
	+ Built-in scala wrapped service
	+ Predefine project template with Result & Thrift for microservice
	
Usage:
git clone project to scala-finatra-archtype folder
cd scala-finatra-archtype
mvn install archetype:update-local-catalog
cd /project-folder
mvn archetype:generate -B -DarchetypeGroupId=scala -DarchetypeArtifactId=finatra-archetype -DarchetypeVersion-1.0 -DgroupId=rever -DartifactId=finatra-template -DpackageName=com.rever.usercache  -DarchetypeCatalog=local
cd /finatra-template
mvn package
chmod +x runservice
./runservice start|stop|restart -Dmode=development

