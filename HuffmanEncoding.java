
// Program: Huffman Encoding using Greedy Strategy

import java.util.PriorityQueue;
import java.util.Scanner;

// Node class for Huffman tree
class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        left = right = null;
    }
}

// Comparator for the priority queue (min-heap)
class MyComparator implements java.util.Comparator<Node> {
    public int compare(Node x, Node y) {
        return x.freq - y.freq;
    }
}

public class HuffmanEncoding {

    // Recursive function to print Huffman codes
    static void printCode(Node root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.ch)) {
            System.out.println(root.ch + " : " + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] charArray = new char[n];
        int[] charFreq = new int[n];

        System.out.println("Enter characters:");
        for (int i = 0; i < n; i++) {
            charArray[i] = sc.next().charAt(0);
        }

        System.out.println("Enter their frequencies:");
        for (int i = 0; i < n; i++) {
            charFreq[i] = sc.nextInt();
        }

        // Create a priority queue (min-heap)
        PriorityQueue<Node> q = new PriorityQueue<>(n, new MyComparator());

        for (int i = 0; i < n; i++) {
            Node node = new Node(charArray[i], charFreq[i]);
            q.add(node);
        }

        Node root = null;

        // Build the Huffman Tree
        while (q.size() > 1) {
            Node x = q.poll();  // extract min
            Node y = q.poll();  // extract next min

            Node f = new Node('-', x.freq + y.freq);
            f.left = x;
            f.right = y;
            root = f;

            q.add(f);
        }

        System.out.println("\nHuffman Codes are:");
        printCode(root, "");

        sc.close();
    }
}

