impression_mark web service
===========================

This service is tested on Mac OS X 10.7.3, installed with git version 1.7.7.5 (Apple Git-26), and Apache Maven 3.0.4

Pre requisite to run the project :
-----------------------------------
1) A system should have a stable internet connection

2) git should be installed on your system. If it's not installed, 

    refer : https://help.github.com/articles/set-up-git

You should have a read access to clone the public repository from github.

3) Apache maven should be installed on your system. If it's not installed, 

     refer : http://maven.apache.org/download.cgi


Setting up the project a.k.a service
-------------------------------------
It's a RESTful web service developed using Jersey framework. To run the project, follow the instructions

  1) First clone the repository in your local system
    
       git clone -b https://github.com/iamon3/impression_mark.git
   
  2) Run the following command
     
       sudo mvn clean; sudo mvn package; sudo mvn jetty:run
     
This step will take some time and will download all the required dependencies fot the module. Once the donwloading 
and packaging step is done, jetty server will be booted showing the messgae jetty server is running on port 9090. You will see the following log statement on the terminal.

	INFO::Started SelectChannelConnector@0.0.0.0:9090
	[INFO] Started Jetty Server     

Here your are done! Your web service is up and running to server the resource request.

  3) To stop the server on Linux/Mac

     	Ctrl+C

For any assistance please reach out to me at
-------------------------------------------
	iamon3.free@gmail.com
