class RecentCounter {
    LinkedList<Integer> list;
    public RecentCounter() {
        this.list = new LinkedList<>();
    }
    
    public int ping(int t) {
        this.list.addLast(t);
        while (this.list.size() > 0) {
            if (this.list.getFirst() < t-3000)
                this.list.removeFirst();
            else break;
        }
        return this.list.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
