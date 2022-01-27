package trie.trie2;

class Node {

    Node links[] = new Node[26];
    int countEndsWith = 0;
    int countPrefix = 0;

    public Node() {

    }

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    void increaseEnd() {
        countEndsWith++;
    }

    void increasePrefix() {
        countPrefix++;
    }

    void deleteEnd() {
        countEndsWith--;
    }

    void reducePrefix() {
        countPrefix--;
    }

    int getEnd(){
        return countEndsWith;
    }

    int getPrefix() {
        return countPrefix;
    }
}

public class Trie_II {

    private Node root;

    Trie_II(){
        root = new Node();
    }

    // Insert a word into the trie

    public void insert(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word){
        Node node = root;
        for(int i = 0; i<word.length(); i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        return node.getPrefix();
    }

    public void erase(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                node.reducePrefix();
            }else {
                return;
            }
        }
        node.deleteEnd();
    }

    public static void main(String[] args) {
        Trie_II t = new Trie_II();
        t.insert("apple");
        t.insert("apple");
        t.insert("apps");
        t.insert("apx");
        System.out.println(t.countWordsEqualTo("apple"));
        System.out.println(t.countWordsStartingWith("ap"));
        t.erase("apple");
        System.out.println(t.countWordsStartingWith("ap"));
    }
}
