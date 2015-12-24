package com.fluidnotions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class CustomWebMvcAutoConfig extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {
	
private static final Log log = LogFactory
			.getLog(CustomWebMvcAutoConfig.class);
		 
  @Value("${fileStoreRootDir}")	
  private String fileStoreRootDir;	
 
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	log.debug("addResourceLocations:  externalDownloadsDirectoryPath: "+fileStoreRootDir); 
    registry.addResourceHandler("/downloads/**").addResourceLocations("file:///"+fileStoreRootDir);
    super.addResourceHandlers(registry);
  }
}
