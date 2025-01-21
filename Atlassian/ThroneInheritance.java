import java.util.*;

class ThroneInheritance {

    class Kingdom{
        String val;
        ArrayList<String> child = new ArrayList<>();
        public Kingdom(String val){
            this.val=val;
        }
    }

    HashMap<String,Kingdom> map;
    HashSet<String> isDead;
    Kingdom root;

    public ThroneInheritance(String kingName) {
        root=new Kingdom(kingName);
        map = new HashMap<>();
        isDead = new HashSet<>();
        map.put(kingName,root);
    }
    
    public void birth(String parentName, String childName) {
        Kingdom newNode = new Kingdom(childName);
        Kingdom par = map.get(parentName);
        par.child.add(childName); map.put(childName,newNode);
        return;
    }
    
    public void death(String name) {
        isDead.add(name);        
    }
    
    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        helper(res,root);
        return res;
    }

    void helper(List<String> res, Kingdom root){
        if(!isDead.contains(root.val)) res.add(root.val);
        for(int i=0; i<root.child.size(); i++){
            helper(res, map.get(root.child.get(i)));
        }
        return;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */