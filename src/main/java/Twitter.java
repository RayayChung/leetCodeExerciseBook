import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 2020/4/13.
 *
 * @author ray
 */
public class Twitter {


    private Map<Integer, Set<Integer>> followRelations;

    private Map<Integer, List<Content>> userTwitters;

    private static int count = 0;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followRelations = new HashMap<>();
        userTwitters = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Content content = new Content(tweetId, count ++);
        userTwitters.compute(userId, (key, list) -> {
            if (list == null) {
                List<Content> l = new ArrayList<>();
                l.add(content);
                return l;
            }
            list.add(content);
            return list;
        });
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        List<Content> users = userTwitters.get(userId);
        Map<Integer, Integer> mapping = new HashMap<>(10);
        add(heap, users, mapping);

        Set<Integer> followeeIds = followRelations.get(userId);
        if (followeeIds != null && !followeeIds.isEmpty()) {
            for (Integer followeeId : followeeIds) {
                if (followeeId == userId) {
                    continue;
                }
                List<Content> followees = userTwitters.get(followeeId);
                add(heap, followees, mapping);
            }
        }
        return heap.stream()
                .sorted(Comparator.reverseOrder())
                .map(mapping::get)
                .collect(Collectors.toList());
    }

    private void add(PriorityQueue<Integer> heap, List<Content> users, Map<Integer, Integer> mapping) {
        if (users != null && !users.isEmpty()) {
            for (Content content : users) {
                if (heap.size() < 10) {
                    heap.offer(content.getTimestamp());
                    mapping.put(content.getTimestamp(), content.getTweetId());
                } else if (heap.peek() < content.getTimestamp()) {
                    mapping.remove(heap.poll());
                    heap.offer(content.getTimestamp());
                    mapping.put(content.getTimestamp(), content.getTweetId());
                }
            }
        }
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        followRelations.compute(followerId, (key, valueSet) -> {
            if (valueSet == null) {
                Set<Integer> set = new HashSet<>();
                set.add(followeeId);
                return set;
            }
            valueSet.add(followeeId);
            return valueSet;
        });
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followeeIds = followRelations.get(followerId);
        if (followeeIds != null) {
            followeeIds.remove(followeeId);
        }
    }

    public static class Content {

        private int tweetId;

        private int timestamp;

        public Content(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }

        public int getTweetId() {
            return tweetId;
        }

        public void setTweetId(int tweetId) {
            this.tweetId = tweetId;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }
    }

    /**
     * ["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed","follow","getNewsFeed","unfollow","getNewsFeed"]
     * [[],[1,5],[2,3],[1,101],[2,13],[2,10],[1,2],[1,94],[2,505],[1,333],[2,22],[1,11],[1,205],[2,203],[1,201],[2,213],[1,200],[2,202],[1,204],[2,208],[2,233],[1,222],[2,211],[1],[1,2],[1],[1,2],[1]]
     * [null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,[222,204,200,201,205,11,333,94,2,101],null,[211,222,233,208,204,202,200,213,201,203],null,[222,204,200,201,205,11,333,94,2,101]]
     *
     * 222,204,200,201,205,11,333,94,2,101
     * 101,2,94,333,11,205,201,200,204,222
     *
     * 211,222,233,208,204,202,200,213,201,203
     * 211,222,233,208,202,213,203,22,505,13
     *
     * @param args
     */
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        String[] commands = {"Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed","follow","getNewsFeed","unfollow","getNewsFeed"};
        int[][] params = {{},{1,5},{2,3},{1,101},{2,13},{2,10},{1,2},{1,94},{2,505},{1,333},{2,22},{1,11},{1,205},{2,203},{1,201},{2,213},{1,200},{2,202},{1,204},{2,208},{2,233},{1,222},{2,211},{1},{1,2},{1},{1,2},{1}};
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            if (command.equals("Twitter")) {
                continue;
            }
            else if (command.equals("postTweet")) {
                twitter.postTweet(params[i][0], params[i][1]);
            }
            else if (command.equals("follow")) {
                twitter.follow(params[i][0], params[i][1]);
            }
            else if (command.equals("getNewsFeed")) {
                List<Integer> newsFeed = twitter.getNewsFeed(params[i][0]);
                System.out.println(newsFeed.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",")));
            }
            else if (command.equals("unfollow")) {
                twitter.unfollow(params[i][0], params[i][1]);
            }
        }
    }
}
