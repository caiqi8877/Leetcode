public class Solution {
    public String simplifyPath(String path) {
        if(path == null )return null;
        Stack<String> s = new Stack<String>();
        String[] items = path.split("/");
        for(String item : items){
            if(item.equals("") || item.equals("."){
                continue;
            }else if(items.equals("..")){
                if(!s.isEmpty){
                    s.pop();
                }
            }else{
                s.push(item);
            }
        }
        StringBuilder sb = new StringBuilder();
        
    }
}