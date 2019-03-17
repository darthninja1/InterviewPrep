package graph;

import java.util.HashSet;
import java.util.Set;

// https://www.hackerrank.com/contests/juniper-hackathon/challenges/friend-circles
// https://www.careercup.com/question?id=4815967075958784
public class FriendsCircle {
    public static void main(String[] args) {
        // @formatter:off
        String[] friends = {"YYNN",
                            "YYYN",
                            "NYYN",
                            "NNNY"};
        // @formatter:on
        System.out.println(numberOfFriendsCircle(friends));
    }

    static int numberOfFriendsCircle(String[] friends) {
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < friends.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            visited.add(i);
            count++;
            checkFriends(friends, i, visited);
        }
        return count;
    }

    private static void checkFriends(String[] friends, int index, Set<Integer> visited) {
        for (int i = 0; i < friends[index].length(); i++) {
            if (!visited.contains(i) && i != index) {
                if (friends[index].charAt(i) == 'Y') {
                    visited.add(i);
                    checkFriends(friends, i, visited);
                }
            }
        }
    }
}
