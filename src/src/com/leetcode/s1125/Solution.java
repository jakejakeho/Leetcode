package src.com.leetcode.s1125;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Set<String> reqSkillsSet = new HashSet<>();
        for (String skill : req_skills) {
            reqSkillsSet.add(skill);
        }
        return recursive(reqSkillsSet, people, 0);
    }

    private int[] recursive(Set<String> reqSkillSet, List<List<String>> people, int index) {
        if (reqSkillSet.size() == 0 || index >= people.size()) {
            return null;
        }
        List<Integer> peopleTaken = new ArrayList<>();
        // take this guy
        List<String> skillsRemoved = new ArrayList<>();
        for (int i = 0; i < people.get(index).size(); i++) {
            if (reqSkillSet.contains(people.get(index).get(i))) {
                skillsRemoved.add(people.get(index).get(i));
                reqSkillSet.remove(people.get(index).get(i));
            }
        }
        if (skillsRemoved.size() > 1) {
            peopleTaken.add(index);
        }
        int[] taken = recursive(reqSkillSet, people, index + 1);
        // don't take this guy
        reqSkillSet.addAll(skillsRemoved);
        return null;
    }
}
