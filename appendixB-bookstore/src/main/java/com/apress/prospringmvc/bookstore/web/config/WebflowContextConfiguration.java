package com.apress.prospringmvc.bookstore.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

/**
 * The glue between Web Flow and Spring MVC, registers the {@link FlowHandlerAdapter} and {@link FlowHandlerMapping}
 * which will enable the {@link DispatcherServlet} to recognize Web Flow requests and send them to the
 * {@link FlowExecutor}
 * 
 * @author Koen Serneels
 */

@Configuration
@Profile("container")
@ImportResource("classpath:/spring/webflow-config.xml")
public class WebflowContextConfiguration {

	@Autowired
	private FlowExecutor flowExecutor;
	@Autowired
	private FlowDefinitionRegistry flowRegistry;

	@Bean
	public FlowHandlerAdapter flowHandlerAdapter() {
		FlowHandlerAdapter flowHandlerAdapter = new FlowHandlerAdapter();
		flowHandlerAdapter.setFlowExecutor(flowExecutor);
		return flowHandlerAdapter;
	}

	@Bean
	public FlowHandlerMapping flowHandlerMapping() {
		FlowHandlerMapping flowHandlerMapping = new FlowHandlerMapping();
		flowHandlerMapping.setFlowRegistry(flowRegistry);
		flowHandlerMapping.setOrder(0);
		return flowHandlerMapping;
	}
}