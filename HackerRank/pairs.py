https://www.hackerrank.com/challenges/pairs/problem?h_l=interview&playlist_slugs%5B%5D=virtusa

dic={}
n,k=map(int,raw_input().split())
l=map(int,raw_input().split())
for i in l:
    dic[i]=True
ans=0
for i in dic:
    if i+k in dic:
        ans+=1
print ans# Enter your code here. Read input from STDIN. Print output to STDOUT


