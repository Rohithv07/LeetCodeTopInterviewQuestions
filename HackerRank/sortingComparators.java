https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem?h_l=interview&playlist_slugs%5B%5D=virtusa




class Checker implements Comparator<Player> {
  	// complete this method
	public int compare(Player a, Player b) {
        if (a.score < b.score)
            return 1;
        else if (a.score > b.score)
            return -1;
        else
            return a.name.compareTo(b.name);
    }
}


