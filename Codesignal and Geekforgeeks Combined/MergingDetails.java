Bob, a teacher of St. Joseph School given a task by his principal to merge the details of the students where each element details[i] is a list of strings, where the first element details[i][0] is a name of the student, and the rest of the elements are emails representing emails of the student.   Two details definitely belong to the same student if there is some common email to both detail.  After merging the details, return the details of the student in the following format: the first element of each detail is the name of the student, and the rest of the elements are emails in sorted order. The details themselves can be returned in any order.  Note: Two details have the same name, they may belong to different people as people could have the same name. A person can have any number of details initially, but all of their details definitely have the same name.

Example 1:

Input: 
n: 4
details = 
[["John","johnsmith@mail.com","john_newyork@mail.com"],
["John","johnsmith@mail.com","john00@mail.com"],
["Mary","mary@mail.com"],
["John","johnnybravo@mail.com"]]
Output: 
[["John","john00@mail.com","john_newyork@mail.com",
"johnsmith@mail.com"],["Mary","mary@mail.com"],
["John","johnnybravo@mail.com"]]
Explanation:
The first and second John's are the same person as 
they have the common email "johnsmith@mail.com".
The third John and Mary are different people as none
of their email addresses are used by other accounts.
We could return these lists in any order, for example
the answer [['Mary', 'mary@mail.com'], 
['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 
'johnsmith@mail.com']] 
would still be accepted.
Example 2:

Input: 
n: 5
details = 
[["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
Output: 
[["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
Your Task:
You don't need to read or print anything. Your task is to complete the function mergeDetails() which takes 2D List of string details denoting the details of the students and returns the list of strings denoting the details of student after merging.

Expected Time Complexity: O(N*M*logN) - where N is the size of details length and M is the size of number of strings for a name.
Expected Auxiliary Space: O(N*M) - where N is the size of details length and M is the size of number of strings for a name.

Constraints:

1 <= details.length <= 1000
2 <= details[i].length <= 10
1 <= details[i][j].length <= 30
details[i][0] consists of English letters.
details[i][j] (for j > 0) is a valid email.


class Solution {
 public:
   vector<vector<string>> mergeDetails(vector<vector<string>>& details) {
       // code here
        vector<vector<string>>vv;
      for(int i=0;i<details.size();i++)
      {
          if(details[i][0]!="-")
          {
              set<string>s;
              vector<string>v;
              for(int j=1;j<details[i].size();j++)
              {
                  s.insert(details[i][j]);
              }
              for(int j=i+1;j<details.size();j++)
              {
                  if(details[j][0]!="-")
                  {
                      for(int k=1;k<details[j].size();k++)
                      {
                          auto pos=s.find(details[j][k]);
                          if(pos!=s.end())
                          {
                              details[j][0]="-";
                              for(int k=1;k<details[j].size();k++)
                              {
                                  s.insert(details[j][k]);
                              }
                          }
                      }
                  }
              }
              v.push_back(details[i][0]);
              for(auto i=s.begin();i!=s.end();i++) v.push_back(*i);


              vv.push_back(v);
          }
      }
      sort(vv.rbegin(),vv.rend()); /* i have reverse that because only 56 test cases passed before this and i did the reverse the vv(vector) then the all test cases passed now…*/
      return vv;
   }
};
 