/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jc.agendaws.webservice.impl;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author resource
 */
@javax.ws.rs.ApplicationPath("service")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.jc.agendaws.webservice.impl.ContatosEndPoint.class);
        resources.add(br.com.jc.agendaws.webservice.impl.LoguinEndPoint.class);
    }
    
}
