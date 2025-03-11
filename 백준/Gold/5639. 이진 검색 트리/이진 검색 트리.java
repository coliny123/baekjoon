import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int value;
        Node left, right;
        
        Node(int value){
            this.value=value;
        }
        
        Node(int value, Node left, Node right){
            this.value=value;
            this.left=left;
            this.right=right;
        }
        
       void insert(Node node){
            if(this.value > node.value){
                if(this.left == null){
                    this.left = node;
                }else{
                    this.left.insert(node);
                }
            }else{
                if(this.right == null){
                    this.right = node;
                }else{
                    this.right.insert(node);
                }
            }
        }
    }
    
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Node root = new Node(Integer.valueOf(br.readLine()));
        
        while(true){
            String input = br.readLine();
            if(input == null) break;
            
            root.insert(new Node(Integer.valueOf(input)));
        }
        
        postOrder(root);
    }
    
    
    static void postOrder(Node node){
        if(node == null){
            return;
        }
        
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}
