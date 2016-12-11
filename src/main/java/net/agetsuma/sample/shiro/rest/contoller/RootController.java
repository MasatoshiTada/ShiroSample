/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.agetsuma.sample.shiro.rest.contoller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import net.agetsuma.sample.shiro.entity.UserAccount;
import net.agetsuma.sample.shiro.entity.UserAccountRepository;
import net.agetsuma.sample.shiro.rest.thymeleaf.ThymeleafViewable;
import net.agetsuma.sample.shiro.service.auth.SigninService;

/**
 * Show top page.
 * @author Norito AGETSUMA
 */
@RequestScoped
@Path("/")
public class RootController {
    
    @Inject
    UserAccountRepository userAccountRepository;
    
    @Inject
    SigninService signinService;
    
    @GET
    public ThymeleafViewable getUsers() {
        HashMap<String, Object> map = new HashMap<>();
        if(!signinService.hasManagerRole()) {
            map.put("accountList", Collections.emptyList());
        } else {
            List<UserAccount> accountList = userAccountRepository.referAll();
            map.put("accountList", accountList);
        }
        return new ThymeleafViewable("index.html", map);
    }
    
}
