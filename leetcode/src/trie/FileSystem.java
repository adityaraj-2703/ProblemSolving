package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  FileSystem {
    Map<String,FileSystem> hm;
    String content;
    FileSystem root;
    public FileSystem() {
        hm = new HashMap<>();
    }
    
    public List<String> ls(String path) {
        if(root==null){
            return new ArrayList<>();
        }
        String[] dir = path.split("/");
        FileSystem curr = root;
        for(int i=0;i<dir.length;i++){
            if(!curr.hm.containsKey(dir[i])){
                hm.put(dir[i], new FileSystem());
            }
            curr = curr.hm.get(dir[i]);

        }
        if(curr==null){
            return new ArrayList<>();
        }
        List<String> li = new ArrayList<>();
        for(Map.Entry<String,FileSystem> m : curr.hm.entrySet()){
            li.add(m.getKey());
        }
        Collections.sort(li);
        return li;
    }
    
    public void mkdir(String path) {
        if(path.length()==1 && path.charAt(0)=='/'){
            return;
        }
        String[] dir = path.split("/");
        if(root==null){
            root = new FileSystem();
            hm.put("/",root);
        }
        FileSystem curr = root;
        for(int i=1;i<dir.length;i++){
            if(!curr.hm.containsKey(dir[i])){
                curr.hm.put(dir[i], new FileSystem());
            }
            curr = curr.hm.get(dir[i]);

        }

        
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] dir = filePath.split("/");
        if(root==null){
            root = new FileSystem();
            hm.put("/",root);
        }
        FileSystem curr = root;
        for(int i=1;i<dir.length;i++){
            if(!curr.hm.containsKey(dir[i])){
                curr.hm.put(dir[i], new FileSystem());
            }
            curr = curr.hm.get(dir[i]);

        }
        if(curr.content!=null){
            curr.content = curr.content + content;
        }
        else{
            curr.content = content;
        }
        
    }
    
    public String readContentFromFile(String filePath) {
        String[] dir = filePath.split("/");
        if(root==null){
            root = new FileSystem();
            hm.put("/",root);
        }
        FileSystem curr = root;
        for(int i=1;i<dir.length;i++){
            if(!curr.hm.containsKey(dir[i])){
                return "";
            }
            curr = curr.hm.get(dir[i]);

        }
        return curr.content;
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        fs.mkdir("/a/b/c");
        fs.addContentToFile("/a/b/c/d","hello");
        List<String> li = fs.ls("/");
        for(int i=0;i<li.size();i++){
            System.out.println(li.get(i));
        }
        String res = fs.readContentFromFile("/a/b/c/d");
        System.out.println(res);
    }
}
