package src.com.leetcode.s355;

import java.util.*;

public class Twitter {

    private int clock = 0;

    HashMap<Integer, List<int[]>> database = new HashMap<>();

    HashMap<Integer, Set<Integer>> followDatabase = new HashMap<>();

    public Twitter() {

    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        twitter.getNewsFeed(
            1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede
        // tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        twitter.getNewsFeed(
            1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer
        // following user 2.
    }

    public void postTweet(int userId, int tweetId) {
        int[] newPost = createPost(tweetId);
        List<int[]> posts = database.getOrDefault(userId, new ArrayList<>());
        posts.add(newPost);
        database.put(userId, posts);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> thisUserFollower = new ArrayList<>(followDatabase.getOrDefault(userId, new HashSet<>()));
        // show this user post as well
        thisUserFollower.add(userId);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Integer followerId : thisUserFollower) {
            priorityQueue.addAll(database.getOrDefault(followerId, new ArrayList<>()));
        }

        List<Integer> result = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            int[] post = priorityQueue.poll();
            if (post == null) {break;}
            result.add(post[0]);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> followers = followDatabase.getOrDefault(followerId, new HashSet<>());
        followers.add(followeeId);
        followDatabase.put(followerId, followers);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followers = followDatabase.getOrDefault(followerId, new HashSet<>());
        followers.remove(followeeId);
        followDatabase.put(followerId, followers);
    }

    private int[] createPost(int tweetId) {
        return new int[] {tweetId, clock++};
    }
}