class Twitter {
    private Map<Integer, Integer> tweetMap;
    private Map<Integer, List<Integer>> userTweets;
    private Map<Integer, Set<Integer>> userFollows;

    private int clock;

    public Twitter() {
        this.tweetMap = new HashMap<>();
        this.userTweets = new HashMap<>();
        this.userFollows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.put(tweetId, clock++);

        userTweets.putIfAbsent(userId, new ArrayList<>());
        userTweets.get(userId).add(tweetId);

        System.out.println("Added tweet " + tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> tweetMap.get(a) - tweetMap.get(b));

        // Add own tweets
        if (userTweets.containsKey(userId)) {
            for (int tweet : userTweets.get(userId)) {
                System.out.println("Processing tweet " + tweet);
                pq.offer(tweet);
                if (pq.size() > 10) {
                    pq.poll();
                }
            }
        }

        if (userFollows.containsKey(userId)) {
            Set<Integer> followees = userFollows.get(userId);
            for (int user : followees) {
                if (userTweets.containsKey(user)) {
                    for (int tweet : userTweets.get(user)) {
                        pq.offer(tweet);
                        if (pq.size() > 10) {
                            pq.poll();
                        }
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(0, pq.poll());
        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        userFollows.putIfAbsent(followerId, new LinkedHashSet<>());
        userFollows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!userFollows.containsKey(followerId)) {
            return;
        }

        Set<Integer> followeeSet = userFollows.get(followerId);
        followeeSet.remove(followeeId);
    }
}
