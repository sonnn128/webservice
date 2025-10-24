Postman SOAP test instructions for Product SOAP service

Base WSDL: http://localhost:8081/ws/products.wsdl
Service endpoint: http://localhost:8081/ws

Headers to set in Postman for SOAP requests:
- Content-Type: text/xml
- SOAPAction: "" (not required for Spring-WS, leave empty)

1) createProduct
Request (POST to /ws):

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:prod="http://example.com/demo/ws/products">
   <soapenv:Header/>
   <soapenv:Body>
      <prod:createProductRequest>
         <prod:name>Product A</prod:name>
         <prod:price>19.99</prod:price>
         <prod:description>Example product</prod:description>
      </prod:createProductRequest>
   </soapenv:Body>
</soapenv:Envelope>

Response body will contain createProductResponse with id, success and message.

2) getAllProducts
Request (POST to /ws):

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:prod="http://example.com/demo/ws/products">
   <soapenv:Header/>
   <soapenv:Body>
      <prod:getAllProductsRequest/>
   </soapenv:Body>
</soapenv:Envelope>

Response will contain getAllProductsResponse with a products list.

3) updateProduct
Request (POST to /ws):

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:prod="http://example.com/demo/ws/products">
   <soapenv:Header/>
   <soapenv:Body>
      <prod:updateProductRequest>
         <prod:id>1</prod:id>
         <prod:name>Updated name</prod:name>
         <prod:price>29.99</prod:price>
      </prod:updateProductRequest>
   </soapenv:Body>
</soapenv:Envelope>

Response: updateProductResponse with success and message.

4) deleteProduct
Request (POST to /ws):

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:prod="http://example.com/demo/ws/products">
   <soapenv:Header/>
   <soapenv:Body>
      <prod:deleteProductRequest>
         <prod:id>1</prod:id>
      </prod:deleteProductRequest>
   </soapenv:Body>
</soapenv:Envelope>

Response: deleteProductResponse with success and message.

Workflow notes:
- Start the application (make sure MySQL is reachable per application.properties):
  mvn spring-boot:run
- Use Postman to create a request: set method POST, URL http://localhost:8081/ws, set header Content-Type: text/xml, paste the SOAP envelope in the body (raw).
- The WSDL at /ws/products.wsdl can be opened in a browser to see the service contract.
- For testing without MySQL, modify `application.properties` to use an in-memory H2 datasource.

