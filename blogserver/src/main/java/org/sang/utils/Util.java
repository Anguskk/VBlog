package org.sang.utils;

import org.sang.bean.User;
import org.sang.bean.Client;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by sang
 */
public class Util {
    public static User getCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
    public static Client getCurrentClient(){
        Client client = (Client) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return client;
    }
}
