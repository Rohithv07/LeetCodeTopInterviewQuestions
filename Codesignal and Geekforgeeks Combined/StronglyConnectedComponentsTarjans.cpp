 static bool comp(vector<int> &a, vector<int> &b) {
        return a[0]<b[0];
    }
    
    void dfs(vector<int> *adj, int u, vector<bool> &visited, vector<bool> &inStack, stack<int> &stk, int &time_t, vector<int> &discovery, vector<int> &low, vector<vector<int>> &components) {
        visited[u] = true;
        stk.push(u);
        inStack[u] = true;
        discovery[u] = time_t;
        low[u] = time_t;
        time_t++;
        for(int v:adj[u]) {
            if(!visited[v]) {
                dfs(adj, v, visited, inStack, stk, time_t, discovery, low, components);
                low[u] = min(low[u], low[v]);
            }
            else {
                if(inStack[v]) {
                    low[u] = min(low[u], discovery[v]);
                }
            }
        }
        if(low[u]==discovery[u]) {
            vector<int> curr;
            while(stk.top()!=u) {
                curr.push_back(stk.top());
                inStack[stk.top()] = false;
                stk.pop();
            }
            curr.push_back(stk.top());
            inStack[stk.top()] = false;
            stk.pop();
            components.push_back(curr);
        }
    }
    
    vector<vector<int>> tarjans(int V, vector<int> adj[]) {
        int time_t = 0;
        vector<int> discovery(V);
        vector<int> low(V);
        vector<bool> inStack(V, false);
        vector<bool> visited(V, false);
        stack<int> stk;
        vector<vector<int>> components;
        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                dfs(adj, i, visited, inStack, stk, time_t, discovery, low, components);
            }
        }
        
        
        // for(int i=0; i<V; i++) {
        //     cout<<discovery[i]<<" ";
        // }
        // cout<<endl;
        // for(int i=0; i<V; i++) {
        //     cout<<low[i]<<" ";
        // }
        // cout<<endl;
        // for(int i=0; i<components.size(); i++) {
        //     for(int j=0; j<components[i].size(); j++) {
        //         cout<<components[i][j]<<" ";
        //     }
        //     cout<<endl;
        // }
        
        
        for(vector<int> &x:components) {
            sort(x.begin(), x.end());
        }
        sort(components.begin(), components.end(), comp);
        return components;
    }