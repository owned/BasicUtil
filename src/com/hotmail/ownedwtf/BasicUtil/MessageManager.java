package com.hotmail.ownedwtf.BasicUtil;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class MessageManager{
	
	private MessageManager() { }
	
	private static MessageManager instance = new MessageManager();
	
	public static MessageManager getInstance() {
		return instance;
		
	}
	public void missingp(CommandSender sender, String msg){
		msg(sender, ChatColor.YELLOW + "[BasicUtil] " + ChatColor.RED, msg);
	}
	
	private void msg(CommandSender sender, String string, String msg){
		sender.sendMessage(string + msg);
	}

}
