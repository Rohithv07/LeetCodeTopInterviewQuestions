class Solution {
    Map<String, String> root;
    Map<String, Double> dist;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // key = root, value = parent  root/parent = values
        root = new HashMap<>();
        // key = root value = dist; 
        // example:
        //    a/c = a/b * b/c = dist.get(a) * dist.get(b); 
        dist = new HashMap<>();
        // construct the hashmap
        for(int i=0; i<equations.size(); i++){
            List<String> equation = equations.get(i);
            // find parent of according factor
            // for example: (a, b) -> (2.0)    x,y are the parent of a,b accordingly
            //   we know a/x = dist(a)    b/y = dist(b)  a/b =values[i] to get x/y = (b/y) * (a/b) / (a/x) = dist(b)*values[i] / dist(a)
            String s = find(equation.get(0));
            String p = find(equation.get(1));
            root.put(s, p);
            dist.put(s, dist.get(equation.get(1)) * values[i]/ dist.get(equation.get(0)));
        }
        
        double[] res = new double[queries.size()];
        
        //after constructing all root and dist graph
        for(int j=0; j<queries.size(); j++){
            List<String> query = queries.get(j);
            if(!root.containsKey(query.get(0)) || !root.containsKey(query.get(1))){
                res[j] = -1.0;
            }else{
                String qs = find(query.get(0));
                String qp = find(query.get(1));
                if(!qs.equals(qp)) res[j] = -1;
                else{
                    // we have same parent p for all characters at this time. so we know qs/p = dist(qs) and qp/p = dist(qp). Hence, qs/qp = (qs/p)/(qp/p) = dist(qs) / dist(qp);
                    res[j] = dist.get(query.get(0)) / dist.get(query.get(1));
                }
            }
        }
        return res;
    }
	
    public String find(String s){
        if(!root.containsKey(s)){
            root.put(s, s);
            dist.put(s, 1.0);
            return s;
        }
        if(root.get(s).equals(s)) return s;
        String cur_p = root.get(s);
        String p = find(cur_p);
        root.put(s, p);
        dist.put(s, dist.get(s) * dist.get(cur_p));
        // p is the final parent;
        return p;
    }
}
