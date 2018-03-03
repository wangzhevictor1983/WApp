package com.wapp.server.configuration;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class WebConfig {
	  @Bean
	  public EmbeddedServletContainerFactory servletContainer() {

	    TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {

	        @Override
	        protected void postProcessContext(Context context) {

	          SecurityConstraint securityConstraint = new SecurityConstraint();
	          securityConstraint.setUserConstraint("CONFIDENTIAL");
	          
	          SecurityCollection collection = new SecurityCollection();
	          collection.addPattern("/*");	          
	          collection.addMethod("post");
	          securityConstraint.addCollection(collection);
	          context.addConstraint(securityConstraint);
	        }
	    };
	    tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
	    return tomcat;
	  }
	  
	  private Connector initiateHttpConnector() {

		    Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		    connector.setScheme("http");
		    connector.setPort(9091);
		    connector.setSecure(false);
		    connector.setRedirectPort(9090);
		    
		    
		    //connector.setA
		    //connector.setAttribute("SSLEnabled", true); 
		    return connector;
		  }
}
