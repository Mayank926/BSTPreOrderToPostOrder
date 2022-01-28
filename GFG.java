// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

class Node { 
	int data; 
	Node left, right; 
	Node(int d) { 
		data = d; 
		left = right = null; 
	} 
} 


class GFG {
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputline[i]);
            }
            
            Node res = post_order(arr, n);
            printPostorder(res);
            System.out.println();
        }
    }
    
    
    
    
 // } Driver Code Ends
//User function Template for Java


//Function that constructs BST from its preorder traversal.
public static Node post_order(int pre[], int size) 
{
    Node root = createTree(pre,0,size-1);

        return root;
} 

private static Node createTree(int[] arr, int beg, int end) {
        if(beg>end)
            return null;
        else{
            Node root = new Node(arr[beg]);
            int separationIndex = getSeparationIndex(arr,root.data,beg+1,end);
            root.right=createTree(arr,separationIndex,end);
            root.left=createTree(arr,beg+1,separationIndex-1);
            return root;
        }
    }

    private static int getSeparationIndex(int arr[],int data, int start, int end) {
        if(start==end){
            if(arr[start]>data)
                return start;
            else
                return start+1;
        }
        while(start<=end && arr[start]<data )
            start++;
        return start;
    }

// { Driver Code Starts.


public static 	void printInorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		printInorder(node.left); 
		System.out.print(node.data + " "); 
		printInorder(node.right); 
	} 
	
public static 	void printPostorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		printPostorder(node.left); 
		printPostorder(node.right);
		System.out.print(node.data + " "); 
	} 
	
public static 	void printPreorder(Node node) { 
		if (node == null) { 
			return; 
		} 
		System.out.print(node.data + " "); 
		printPreorder(node.left); 
		printPreorder(node.right);
	} 

}  // } Driver Code Ends
