package com.jsp.workspace.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class WorkspaceConfig {
	
	public Docket getDocket() {
		
		 Contact contact = new Contact("Jspiders", "www.jspiders.com", "jspiders@gmail.com");
		
		 List <VendorExtension> extensions = new ArrayList<VendorExtension>(); 
		
		 ApiInfo apiInfo = new ApiInfo("workspace","description","1.01","terms of Services",
				                            "contact","license","licenseurl");
		 		
		return new Docket (DocumentationType.SWAGGER_2).select().apis(
				RequestHandlerSelectors.basePackage("com.jsp.workspace")).build().
							apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
		
}
