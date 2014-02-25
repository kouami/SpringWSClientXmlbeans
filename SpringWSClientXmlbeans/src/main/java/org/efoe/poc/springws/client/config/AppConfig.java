/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.efoe.poc.springws.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.xmlbeans.XmlBeansMarshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.CommonsHttpMessageSender;

/**
 *
 * @author Emmanuel
 */
@Configuration
public class AppConfig {
     @Bean
    public WebServiceTemplate template() {
        WebServiceTemplate t = new WebServiceTemplate();
        t.setDefaultUri("http://localhost:8080/swsj/services/customerServices");
        t.setMarshaller(xmlBeansMarshaller());
        t.setUnmarshaller(xmlBeansMarshaller());
        t.setMessageFactory(messageFactory());
        t.setMessageSender(messageSender());
        return t;
    }
    
    @Bean
    public XmlBeansMarshaller xmlBeansMarshaller(){
        return new XmlBeansMarshaller();
    }
    
    @Bean
    public CommonsHttpMessageSender messageSender(){
        return new CommonsHttpMessageSender();
    }
    
    @Bean
    public SaajSoapMessageFactory messageFactory(){
        return new SaajSoapMessageFactory();
    }
    
    /*
    @Bean
    public AxiomSoapMessageFactory axiomMessageFactory(){
        return new AxiomSoapMessageFactory();
    }*/
}
