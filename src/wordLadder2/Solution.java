package wordLadder2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public class myType {
		String word;
		int length;
		
		myType (String s, int a) {
			word = s;
			length = a;
		}
	}
	
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
    	ArrayList<ArrayList<String>> re = new ArrayList<ArrayList<String>>();
    	HashMap<String, ArrayList<String>> pre = new HashMap<String, ArrayList<String>>();
    	HashMap<String, Integer> dict2 = new HashMap<String, Integer>();
    	
        Queue<myType> q = new LinkedList<myType>();
        q.offer(new myType(start, 1));
        dict.remove(start);

        int len = start.length();
        int endLen = Integer.MAX_VALUE;
        
        myType cur = null;
        String s = "";
        
        while (!q.isEmpty()) {
        	cur = q.poll();
        	StringBuffer sb = new StringBuffer(cur.word);
        	for (int i = 0; i < len; i++) {
        		char temp = sb.charAt(i);
        		for (char c = 'a'; c <= 'z'; c++) {
        			sb.setCharAt(i, c);
        			s = sb.toString();
        			if (cur.length == endLen) {
        				break;
        			}
        			if (s.equals(end)) {
        				endLen = cur.length+1;
        			}
        			if (dict.contains(s) && (!dict2.containsKey(s) || dict2.get(s) == cur.length+1)) {
        				if (!dict2.containsKey(s))
        					q.offer(new myType(s, cur.length+1));
        				dict2.put(s, cur.length+1);
        				if (!pre.containsKey(s)) {
        					pre.put(s, new ArrayList<String>());
        				}
        				pre.get(s).add(cur.word);
        			}
        		}
        		sb.setCharAt(i, temp);
        	}
        }
        if (endLen == Integer.MAX_VALUE) return re;
        
        s = end;
        ArrayList<String> stack = new ArrayList<String>();
        stack.add(s);

        print(re, pre, stack, s, start);
        
        return re;
    }
    
    public void print(ArrayList<ArrayList<String>> re, HashMap<String, ArrayList<String>> pre,  ArrayList<String> stack, String cur, String start) {
    	if (cur.equals(start)) {
    		ArrayList<String> singlePath = new ArrayList<String>(stack.size());
    		for (int i = stack.size()-1; i > -1; i--) {
    			singlePath.add(stack.get(i));
    		}
    		re.add(singlePath);
    	} else {
        	ArrayList<String> temp = pre.get(cur);
        	for (int i = 0; i < temp.size(); i++) {
        		stack.add(temp.get(i));
        		print(re, pre, stack, temp.get(i), start);
        		stack.remove(stack.size()-1);
        	}
    	}
    }
}
