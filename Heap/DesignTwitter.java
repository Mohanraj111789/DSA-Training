class Twitter {
    int time;
    HashMap<Integer,ArrayList<int[]>> tweets;
    HashMap<Integer,HashSet<Integer>> followMap;

    public Twitter() {
        time = 0;
        tweets = new HashMap<>();
        followMap = new HashMap<>();
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{tweetId, time++});
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        HashSet<Integer> followees = followMap.getOrDefault(userId, new HashSet<>());
        followees.add(userId);
        for (int followeeId : followees) {
            ArrayList<int[]> userTweets = tweets.getOrDefault(followeeId, new ArrayList<>());
            for (int[] tweet : userTweets) {
                pq.add(tweet);
                if (pq.size() > 10) {
                    pq.poll();
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll()[0]);
        }
        return result;



        
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
        
    }
}