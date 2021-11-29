Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

 

Example 1:

Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Explanation:
The first and second John's are the same person as they have the common email "johnsmith@mail.com".
The third John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Example 2:

Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 

Constraints:

1 <= accounts.length <= 1000
2 <= accounts[i].length <= 10
1 <= accounts[i][j] <= 30
accounts[i][0] consists of English letters.



class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToId = new HashMap<>();
        int id = 0;
        int [] parent = new int[10001];
        for (int i=0; i<10001; i++) {
            parent[i] = i;
        }
        for (List<String> account:accounts) {
            String name = "";
            for (String email:account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                }
                union(parent, emailToId.get(account.get(1)), emailToId.get(email));
            }
        }
        Map<Integer, List<String>> result = new HashMap<>();
        for (String email: emailToName.keySet()) {
            int index = find(parent, emailToId.get(email));
            result.computeIfAbsent(index, x->new ArrayList()).add(email);
        }
        for (List<String> component: result.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList(result.values());
    }
    public int find(int [] parent, int v) {
        if (parent[v] == v)
            return v;
        return find(parent, parent[v]);
    }
    public void union(int [] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }
}