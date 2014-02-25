package org.efoe.poc.springws.client;

import com.customer.service.CustomerRequestDocument;
import com.customer.service.CustomerRequestDocument.CustomerRequest;
import com.customer.service.CustomerResponseDocument;
import org.efoe.poc.springws.client.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        WebServiceTemplate template = context.getBean(WebServiceTemplate.class);
        CustomerRequestDocument reqDoc = CustomerRequestDocument.Factory.newInstance();
        CustomerRequest req = CustomerRequest.Factory.newInstance();
        req.setSsn("111111111");
        reqDoc.setCustomerRequest(req);
        
        CustomerResponseDocument respDoc = (CustomerResponseDocument)template.marshalSendAndReceive(reqDoc);
        System.out.println(respDoc.getCustomerResponse().getFirstName());
        System.out.println(respDoc.getCustomerResponse().getLastName());
        System.out.println(respDoc.getCustomerResponse().getSsn());
    }
}
