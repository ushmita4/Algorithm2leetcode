class Solution {
    List<String> l = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        HashMap<Character,Character []> map = new HashMap<>();
        map.put('2',new Character[] {'a','b','c'});
        map.put('3',new Character[] {'d','e','f'});
        map.put('4',new Character[] {'g','h','i'});
        map.put('5',new Character[] {'j','k','l'});
        map.put('6',new Character[] {'m','n','o'});
        map.put('7',new Character[] {'p','q','r','s'});
        map.put('8',new Character[] {'t','u','v'});
        map.put('9',new Character[] {'w','x','y','z'});
        
        if(digits.length()==0)
            return l;
        
        help(map,digits,"",0);
        return l;
    }
    
    public void help(HashMap<Character,Character []> map, String s, String prev,int i)
    {
        if(prev.length()==s.length())
        {
            l.add(prev);
            return;
        }
        //System.out.println(map.get(s.charAt(i)));
        for(int x = 0; x<map.get(s.charAt(i)).length; x++)
        {
            help(map,s,prev+map.get(s.charAt(i))[x],i+1);
        }
        
    }
}
