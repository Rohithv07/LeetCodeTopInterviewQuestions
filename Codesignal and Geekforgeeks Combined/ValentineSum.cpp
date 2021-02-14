// https://www.youtube.com/watch?v=6N7y7EFeuhI&t=672s


struct Node
{
    int data;
    Node* left;
    Node* right;
};

*/



class Solution{

   public:
    
    unordered_map<Node*,Node*>map;
    
    Node* storeparent(Node*root,int target)
    {
        Node*t; 
        if (root==NULL)
          return t;
          
        map[root]=NULL; 
        
        queue<Node*>q;
        
        q.push(root);
        
        while(!q.empty())
        {
            
          Node*p=q.front();
          
          if (p->data==target)
          {
              t=p;
          }
        
        if (p->right)
        {
            map[p->right]=p;
            q.push(p->right);
            
        }
        if (p->left)
        {
            map[p->left]=p;
            q.push(p->left);
        }
        
        q.pop();
        
        }
        return t;
    }
    
    int sum_at_distK(Node* root, int target, int k)
    {
        
         Node*t=storeparent(root,target);
        
         if (t==NULL) 
           return 0;
         
         long long int sum=0; 
         
         queue<Node*>q;
         
         set<Node*>s;
         
         q.push(t);
         s.insert(t);
         int level=0;
         
         while(!q.empty() and level<=k)
         {
             int size=q.size();
             
             for (int i=0;i<size;i++)
             {Node*f=q.front();
             sum+=f->data;
             
             if (f->right && s.find(f->right)==s.end() )
             {
                 q.push(f->right);
                 s.insert(f->right);
             }
             
             if (f->left && s.find(f->left)==s.end())
             {
                 q.push(f->left);
                  s.insert(f->left);
                
             }
             if (map[f] && s.find(map[f])==s.end())
             {
                 q.push(map[f]);
                  s.insert(map[f]);
             }
             q.pop();
             }
             level++;
         }
         
         
         
         return sum;
         
    }



};

