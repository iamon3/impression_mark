impression_mark web service
===========================

This service is tested on Mac OS X 10.7.3, installed with git version 1.7.7.5 (Apple Git-26), and Apache Maven 3.0.4

Pre requisite for running the service :
---------------------------------------
1) A system should have a stable internet connection

2) git should be installed on your system. If it's not installed, refer :

    https://help.github.com/articles/set-up-git

You should have a read access to clone the public repository from github.

3) Apache maven should be installed on your system. If it's not installed, refer : 

     http://maven.apache.org/download.cgi
     
4) This is optional. A client is needed to test the service. curl is simple comand line client. If it's not installed, refer:

     http://curl.haxx.se/docs/install.html


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

Testing the service
-------------------

We can use any client for testing e.g. curl, Google chrome browser extensions viz Dev HTTP clinet, REST console, POSTMAN

I used curl for testing. Following  are examples of service calls and their responses.

1) Create a document

	curl -i -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d  '{"content":"book", 		"author":"chetan bhagat", "title":"5 point someone","topic":"story"}' http://localhost:9090/impression-mark/services/documents

	Response
	
	HTTP/1.1 200 OK
	Content-Type: application/json
	Transfer-Encoding: chunked
	Server: Jetty(6.1.22)

	{"documentId":"1","content":"book","title":"5 point someone","author":"chetan bhagat","topic":"story","isMarked":"true"}


2) Fetch a document

	curl -i -X GET -H "Accept:application/json" http://localhost:9090/impression-mark/services/documents/1

	Response
	
	HTTP/1.1 200 OK
	Content-Type: application/json
	Transfer-Encoding: chunked
	Server: Jetty(6.1.22)

	{"documentId":"1","content":"book","title":"5 point someone","author":"chetan bhagat","topic":"story","isMarked":"true"}


3) Update a document

	curl -i -X PUT -H "Content-Type:application/json" -H "Accept:application/json" -d  '{"author":"CHETAN BHAGAT"}' http://localhost:9090/impression-mark/services/documents/1

	Response

	HTTP/1.1 200 OK
	Content-Type: application/json
	Transfer-Encoding: chunked
	Server: Jetty(6.1.22)

	{"documentId":"1","content":"book","title":"5 point someone","author":"CHETAN BHAGAT","topic":"story","isMarked":"true"}

4) Delete a document 

	curl -i -X DELETE -H "Accept:application/json" http://localhost:9090/impression-mark/services/documents/1

	Response

	HTTP/1.1 200 OK
	Content-Type: application/json
	Transfer-Encoding: chunked
	Server: Jetty(6.1.22)

	{"documentId":"1","content":"book","title":"5 point someone","author":"CHETAN BHAGAT","topic":"story","isMarked":"true"}


For any assistance please reach out to me at
-------------------------------------------
	iamon3.free@gmail.com
