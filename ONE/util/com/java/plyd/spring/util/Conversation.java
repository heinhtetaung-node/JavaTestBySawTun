package com.java.plyd.spring.util;

import java.util.HashMap;

import com.java.plyd.spring.presentation.main.SchoolMainFrame;

public class Conversation {
	
	public static void addConversation(String key, Object value) {
		SchoolMainFrame.conversation.put(key, value);
	}
	
	public static Object getConversationValue(String key) {
		return SchoolMainFrame.conversation.get(key);
	}
	
	public static void endConversation(String key) {
		SchoolMainFrame.conversation.remove(key);
	}

}
