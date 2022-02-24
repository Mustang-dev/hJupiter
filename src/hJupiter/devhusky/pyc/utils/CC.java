package hJupiter.devhusky.pyc.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

public class CC {
	
	public static String translate(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
	
	public static List<String> set(List<String> lcs) {
	    List<String> lsc = new ArrayList<>();
	    lcs.forEach(slc -> lsc.add(CC.translate(slc)));
	    return lsc;
	  }
	
	public static List<String> replaceMarks(List<String> lcs) {
		List<String> lsc = new ArrayList<>();
		lcs.forEach(slc -> lsc.add(slc.replace("[", "")
				.replace("]", "")));
				
				return lsc;
	}
	
	public static String convertString(List<String> stl) {
		if(stl == null)return null;
		for (int i=0;i<stl.size();i++) {
			return stl.get(i);
		}
		return null;
	}
}
