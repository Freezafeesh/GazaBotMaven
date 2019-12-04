/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import com.gblite.GBLMain;
import java.util.List;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 *
 * @author troy
 */
public class Cull extends ListenerAdapter{
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
    String[] args = event.getMessage().getContentRaw().split(" ");
    if(args[0].equalsIgnoreCase(GBLMain.prefix + "c")) {
                            String User = event.getAuthor().getName();
                            
                            if(args.length < 2){
                            event.getChannel().sendMessage("Include the num of messages you want to delete").queue();
                        }
                            
                        else{
                            
                            try{List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                            event.getChannel().deleteMessages(messages).queue();
                            Thread.sleep(1000);
                            event.getChannel().sendMessage("`deleted "+args[1]+" messages successfully`").queue();
                           
                            }catch(Exception e){
                               if(e.toString().startsWith("java.lang.IllegalArgumentException: Message")){
                                event.getChannel().sendMessage("`Can't delete > 100 messages at once`").queue();
                            }
                               else{
                                    event.getChannel().sendMessage("`Can't delete messages > 2 weeks`").queue();
                               }
                            
                        }    
                            }    
        }
    }
}