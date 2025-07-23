package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveSubFoldersFromFileSystem {
    public List<String> removeSubfolders(String[] folder) {
        Trie root = new Trie();
        for(String path : folder){
            Trie curr = root;
            String[] folders = path.split("/");
            for(String name : folders){
                if(name.equals("")){
                    continue;
                }
                if(!curr.children.containsKey(name)){
                    curr.children.put(name,new Trie());
                    curr = curr.children.get(name);
                }
            }
            curr.isEndOfFolder = true;
        }
        List<String> res = new ArrayList<>();
        for(String path : folder){
            Trie curr = root;
            String[] name = path.split("/");
            boolean isSub = false;
            for(int i=0;i<name.length;i++){
                if(name[i].equals("")){
                    continue;
                }
                Trie next = curr.children.get(name[i]);
                if(next!=null && next.isEndOfFolder && i!=name.length-1){
                    isSub = true;
                    break;
                }
                curr = next;
            }
            if(!isSub){
                res.add(path);
            }
        }
        return res;
    }

    class Trie{
        Map<String,Trie> children;
        boolean isEndOfFolder;
        Trie(){
            this.children = new HashMap<>();
            this.isEndOfFolder = false;
        }
    }

    public static void main(String[] args) {
        String[] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        System.out.println(new RemoveSubFoldersFromFileSystem().removeSubfolders(folder));

    }

}
