The worlds most successful thief Albert Spaggiari was planning for his next heist on the world bank. He decides to carry a sack with him, which can carry a maximum weight of C kgs. Inside the world bank there were N large blocks of gold. All the blocks have some profit value associated with them i.e. if he steals ith block of weight w[i] then he will have p[i] profit. As blocks were heavy he decided to steal some part of them by cutting them with his cutter.
The thief does not like symmetry, hence, he wishes to not take blocks or parts of them whose weight is a perfect square. Now, you need to find out the maximum profit that he can earn given that he can only carry blocks of gold in his sack. 
Note: The answer should be precise upto 3 decimal places.

Example 1 :

N = 3, C = 10
w[] = {4, 5, 7}
p[] = {8, 5, 4)
Output: 
7.857
Explanation: As first blocks weight is 4
which is a perfect square, he will not use 
this block. Now with the remaining blocks 
the most optimal way is to use 2nd block 
completely and cut 5kg piece from the 3rd 
block to get a total profit of 5 + 2.857 
= 7.857
Your Task:
You don't need to read or print anything. Your task is to complete the function maximumProfit() which takes N, C, w[ ] and p[ ] as input parameters and returns the maximum profit thief can achieve with precision upto 3 decimal places.

Expected Time Complexity: O(N * LogN)
Expected Space Complexity : O(N)

Constraints:
1 ≤ N ≤ 103
1 ≤ C ≤ 1018
1 ≤ Wi ≤ 109
1 ≤ Pi ≤ 109'


public:
long double maximumProfit(int N, long long C, vector<long long> w, vector<long long> p){
    // Code here.
          vector<pair<double,long long int >> v;   
        //loop to generate vector of profit per weight 
    for(int i=0;i<N;i++){
        int x=sqrt(w[i]);
        if(pow(x,2)==w[i])
            continue;
        else{
            v.push_back({(double)p[i]/w[i],w[i]});
        }
    }
    //sort p vector in ascending order of profit per weight ratio
    sort(v.begin(),v.end(),greater<pair<double,long long int>>());
    double profit=0;
    for(int i=0;i<=p.size();i++){
        if(v[i].second<=C){
            profit+=v[i].first*v[i].second;
            C-=v[i].second;
        }
        else if(v[i].second>C){
            profit+=C*v[i].first;
            break;
        }
    }
    return profit;
}
};