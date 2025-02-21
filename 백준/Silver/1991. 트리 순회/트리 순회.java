import java.util.*;
import java.io.*;


class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    static Node[] tree;     
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        
        tree = new Node[N+1];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            
            char parentNode = input[0].charAt(0);
            char leftNode = input[1].charAt(0);
            char rightNode = input[2].charAt(0);
            
            if (tree[parentNode - 'A'] == null) {
                tree[parentNode - 'A'] = new Node(parentNode); 
            }
            if (leftNode != '.') {
                tree[leftNode - 'A'] = new Node(leftNode);
                tree[parentNode - 'A'].left = tree[leftNode - 'A'];
            }
            if (rightNode != '.') { 
                tree[rightNode - 'A'] = new Node(rightNode);
                tree[parentNode - 'A'].right = tree[rightNode - 'A']; 
            }        
        }
        
        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        postOrder(tree[0]);
        
    }
    
    
    static void preOrder(Node cur){
        if(cur == null){
            return;
        }
        System.out.print(cur.value);
        preOrder(cur.left);
        preOrder(cur.right);
    }
    
    static void inOrder(Node cur){
        if(cur == null){
            return;
        }
        inOrder(cur.left);
        System.out.print(cur.value);
        inOrder(cur.right);
    }
    
    static void postOrder(Node cur){
        if(cur == null){
            return;
        }
        postOrder(cur.left);
        postOrder(cur.right);
        System.out.print(cur.value);
    }
}
