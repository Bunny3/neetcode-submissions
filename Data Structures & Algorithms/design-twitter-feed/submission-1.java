
class Twitter {
    private HashMap<Integer, List<int[]>> userTweetMapping;
    private HashMap<Integer, Set<Integer>> followerList;
    private int timestamp;

    public Twitter() {
        timestamp = 0;
        userTweetMapping = new HashMap<>();
        followerList = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweetMapping.putIfAbsent(userId, new ArrayList<>());
        // Store [timestamp, tweetId]
        userTweetMapping.get(userId).add(new int[]{++timestamp, tweetId});
    }

    private List<int[]> tweetList(int userId) {
        return userTweetMapping.getOrDefault(userId, new ArrayList<>());
    }

    public List<Integer> getNewsFeed(int userId) {
        List<int[]> allTweets = new ArrayList<>(tweetList(userId));

        // Get all followees for this user
        Set<Integer> followees = followerList.getOrDefault(userId, new HashSet<>());
        for (int followee : followees) {
            allTweets.addAll(tweetList(followee));
        }

        // Sort descending by timestamp (tweet[0])
        allTweets.sort((a, b) -> b[0] - a[0]);

        List<Integer> newsFeed = new ArrayList<>();
        // Fetch up to 10 most recent tweets
        int count = Math.min(10, allTweets.size());
        for (int i = 0; i < count; i++) {
            newsFeed.add(allTweets.get(i)[1]);
        }

        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followerList.putIfAbsent(followerId, new HashSet<>());
        followerList.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (followerList.containsKey(followerId)) {
            followerList.get(followerId).remove(followeeId);
        }
    }
}