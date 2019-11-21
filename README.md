# general-search
general search legacy web app

The main purpose of this servlet app is to redirect from legacy requests to the current requests.

In particular:

	/generalSearch/main.html?id=12345   is redirected to  /rgdweb/elasticResults.html?category=General&term=12345

	/generalSearch/RgdSearch.jsp?quickSearch=1&searchKeyword=12345   is redirected to  /rgdweb/elasticResults.html?category=General&term=12345

	/generalSearch/advSearch.jsp?searchKeyword=12345   is redirected to  /rgdweb/elasticResults.html?category=General&term=12345
	

Build the app, by executing 'gradle build', rename the war to generalSearch.war, and then drop the war into tomcat's webapps directory.