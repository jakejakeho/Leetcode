//package src.com.leetcode.s355;
//
//import java.util.*;
//
//public class Twitter {
//    public Twitter() {
//
//    }
//
//    public void postTweet(int userId, int tweetId) {
//    }
//
//    public List<Integer> getNewsFeed(int userId) {
//
//    }
//
//    public void follow(int followerId, int followeeId) {
//
//    }
//
//    public void unfollow(int followerId, int followeeId) {
//    }
//}
//
//class Tweet {
//    int userId;
//    int tweetId;
//    Date createTime;
//
//    public Tweet(int userId, int tweetId, Date createTime) {
//        this.userId = userId;
//        this.tweetId = tweetId;
//        this.createTime = createTime;
//    }
//
//    public Comparator<Tweet> getComparator() {
//        return Comparator.comparing(tweet -> tweet.createTime.getTime());
//    }
//}
//
//class User {
//    int userId;
//    HashSet<Integer> followingIds;
//    List<Integer> tweetIds;
//
//    public User(int userId) {
//        this.userId = userId;
//    }
//
//    public void follow(int userId) {
//        followingIds.add(userId);
//    }
//
//    public void addTweet(int tweetId) {
//        tweetIds.add(tweetId);
//    }
//}