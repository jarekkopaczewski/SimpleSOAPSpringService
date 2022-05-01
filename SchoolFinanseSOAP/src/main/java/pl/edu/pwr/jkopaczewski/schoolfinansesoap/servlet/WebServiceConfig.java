package pl.edu.pwr.jkopaczewski.schoolfinansesoap.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

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

    @Bean(name = "people")
    public DefaultWsdl11Definition peopleWsdlDefinition(XsdSchema peopleSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PeoplePort");
        wsdl11Definition.setLocationUri("/finance");
        wsdl11Definition.setSchema(peopleSchema);
        return wsdl11Definition;
    }

    @Bean(name = "payments")
    public DefaultWsdl11Definition paymentsWsdlDefinition(XsdSchema paymentsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PaymentsPort");
        wsdl11Definition.setLocationUri("/finance");
        wsdl11Definition.setSchema(paymentsSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema peopleSchema() {
        return new SimpleXsdSchema(new ClassPathResource("people.xsd"));
    }

    @Bean
    public XsdSchema paymentsSchema() { return new SimpleXsdSchema(new ClassPathResource("payment.xsd")); }

    @Bean
    public XsdSchema eventsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("event.xsd"));
    }
}
