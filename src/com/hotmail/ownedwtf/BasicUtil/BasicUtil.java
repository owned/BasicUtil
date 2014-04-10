package com.hotmail.ownedwtf.BasicUtil;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class BasicUtil extends JavaPlugin{

	public void onEnable(){
		Bukkit.getServer().getLogger().info("BasicUtil v " + this.getDescription().getVersion()  + " enabled!");
	}
	
	public void onDisable(){
		Bukkit.getServer().getLogger().info("BasicUtil v " + this.getDescription().getVersion() + " disabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	if (sender.isOp() == false){
		sender.sendMessage(ChatColor.RED + "You do no have permission to use this command.");
	}else{
		if (cmd.getName().equalsIgnoreCase("fakeop")){
			if (args.length == 0){
				sender.sendMessage(ChatColor.RED + "Please specify a player.");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null){
				sender.sendMessage(ChatColor.RED + "Could not find player " + args[0] + ".");
				return true;
			}
				target.sendMessage(ChatColor.YELLOW + "You are now op!");
				sender.sendMessage(ChatColor.GREEN + "Success");
		}
		if (cmd.getName().equalsIgnoreCase("fakejoin")){
			if (args.length == 0){
				sender.sendMessage(ChatColor.RED + "Please specify a player.");
				return true;
			}
			Bukkit.broadcastMessage(ChatColor.YELLOW + args[0] + " has joined the game.");
		}
		if (cmd.getName().equalsIgnoreCase("fakequit")){
			if (args.length == 0){
				sender.sendMessage(ChatColor.RED + "Please specify a player.");
				return true;
			}
			Bukkit.broadcastMessage(ChatColor.YELLOW + args[0] + " has quit the game.");
		}
		if (cmd.getName().equalsIgnoreCase("heal")){
			if (args.length == 0){
				sender.sendMessage(ChatColor.RED + "Please specify a player.");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null){
				sender.sendMessage(ChatColor.RED + "Could not find player " + args[0] + ".");
				return true;
			}
			target.setHealth(20);
			}
		if (cmd.getName().equalsIgnoreCase("slap")){
			if (args.length == 0){
				sender.sendMessage(ChatColor.RED + "Please specify a player.");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null){
				sender.sendMessage(ChatColor.RED + "Could not find player " + args[0] + ".");
				return true;
			}
			target.damage(3);
			target.playSound(target.getLocation(), Sound.FALL_BIG, 100, 100);
			target.sendMessage(ChatColor.RED + "You obviously did something wrong if you are getting slapped so stop it!");
		}
		if (cmd.getName().equalsIgnoreCase("enderchest")){
			if (args.length == 0){
				sender.sendMessage(ChatColor.RED + "Please specify a player.");
				return true;
			}
		Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null){
			sender.sendMessage(ChatColor.RED + "Could not find player " + args[0] + ".");
			return true;
		}
			target.openInventory(target.getEnderChest());
		}
	}
	return true;
}
}