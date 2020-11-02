package com.github.mgljava.basicstudy.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainParser {

  public static void main(String[] args) {
    List<String> strings = new DomainParser().subdomainVisits(
        new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
    System.out.println(strings);
  }

  // 9001 discuss.leetcode.com
  public List<String> subdomainVisits(String[] cpdomains) {
    List<String> ans = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    for (String domain : cpdomains) {
      String cnt = domain.split(" ")[0];
      String d = domain.split(" ")[1];
      String[] strings = d.split("\\.");
      for (int i = 0; i < strings.length; i++) {
        int j = strings.length - 1;
        int start = i;
        StringBuilder key = new StringBuilder();
        while (start <= j) {
          key.append(strings[start]);
          key.append(".");
          start++;
        }
        String nKey = key.substring(0, key.toString().length() - 1);
        if (map.containsKey(nKey)) {
          map.put(nKey, map.get(nKey) + Integer.parseInt(cnt));
        } else {
          map.put(nKey, Integer.parseInt(cnt));
        }
      }
    }
    map.forEach((key, value) -> ans.add(value + " " + key));
    return ans;
  }
}
