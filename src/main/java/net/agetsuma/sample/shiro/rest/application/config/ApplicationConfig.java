/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.agetsuma.sample.shiro.rest.application.config;

import net.agetsuma.sample.shiro.rest.contoller.RootController;
import net.agetsuma.sample.shiro.rest.thymeleaf.ThymeleafTemplateProcessor;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.mvc.MvcFeature;
import org.glassfish.jersey.server.mvc.beanvalidation.MvcBeanValidationFeature;

/**
 * JAX-RS Configration.
 * @author Norito AGETSUMA
 * @author Masatoshi Tada
 */
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        packages(RootController.class.getPackage().getName());
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        register(MvcFeature.class);
        property(MvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/views/");
        register(MvcBeanValidationFeature.class);
        register(ThymeleafTemplateProcessor.class);
    }
    
}
