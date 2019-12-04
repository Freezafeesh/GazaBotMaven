package com.gblite;


import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author troy
 */
public class GBLMain {
    public static JDA jda;
    public static String prefix = ".";  
    public static int i = 1;
    public static int k;
    public static void main(String[] args){
        
        try {
         jda = new JDABuilder(AccountType.BOT).setToken("NjUxMjEwNTY1MzQ3MzExNjI2.Xea2DA.OAliVwfh7s6kuFHn2odY0g-vsmM").build(); 
        } catch (Exception e) {
            System.out.println(e);
        }
         jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
         jda.getPresence().setActivity(Activity.playing("null"));
         jda.addEventListener(new Commands.Cull());
   
}
}
