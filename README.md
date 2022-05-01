# Table of contents
* [General info](#general-info)
* [Built With](#built-with)
* [Payment endpoint](#payment-endpoint)
* [Servlet](#servlet)
* [License](#license)

# About The Project

## General info

<p class="text-justify">
  Simple SOAP Spring app.
</p>

## Built with

* [Java](https://www.java.com/pl/)
* [Spring](https://spring.io/)
* [H2](https://www.h2database.com/html/main.html)
* [Lombok](https://github.com/projectlombok/lombok)

## Payment endpoint

```java
  @Endpoint
  public class PaymentEndpoint {
      private static final String NAMESPACE_URI = "localhost";
      @Autowired
      PaymentService paymentService;

      @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaymentRequest")
      @ResponsePayload
      public GetPaymentResponse getPaymentResponse(@RequestPayload GetPaymentRequest request) {
          return ResponseFactory.paymentResponseOf(SoapFactory.paymentOf(paymentService.getPaymentById(request.getPaymentId())));
      }

      @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deletePaymentRequest")
      @ResponsePayload
      public DeletePaymentResponse deletePaymentResponse(@RequestPayload DeletePaymentRequest request) {
          return ResponseFactory.deletePaymentResponseOf(paymentService.deletePayment(request.getPaymentId()));
      }

      @PayloadRoot(namespace = NAMESPACE_URI, localPart = "payPaymentRequest")
      @ResponsePayload
      public PayPaymentResponse payPaymentResponse(@RequestPayload PayPaymentRequest request) {
          return ResponseFactory.payPaymentResponseOf(paymentService.setIsPayed(request.getPaymentId()));
      }
  }
}
```

## Servlet
```java
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/finance/*");
    }

    @Bean(name = "event")
    public DefaultWsdl11Definition eventWsdlDefinition(XsdSchema eventsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("EventsPort");
        wsdl11Definition.setLocationUri("/finance");
        wsdl11Definition.setSchema(eventsSchema);
        return wsdl11Definition;
    }
    
    @Bean
    public XsdSchema eventsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("event.xsd"));
    }
```

## License

Distributed under the Apache-2.0 License.

<p align="right">(<a href="#top">back to top</a>)</p>
