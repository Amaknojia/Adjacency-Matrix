package homework4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


static int[][] graph;

static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));



public static void main(String[] args) {
  
  

graph = new int[10][10]; 
       
        graph[0][2] = 10;
        graph[0][3] = 50;
        graph[0][5] = 20;
        graph[1][0] = 15;
        graph[1][4] = 10;
        graph[1][5] = 50;
        graph[2][0] = 50;
        graph[3][2] = 10;
        graph[3][6] = 20;
        graph[4][5] = 10;
        graph[4][6] = 5;
        graph[5][6] = 15;
        graph[6][2] = 20;
        graph[6][3] = 5;

  
  int numInitialEdges = 0;
  
  for(int a = 0; a < 7; a++) {
   for(int b = 0; b < 7; b++) {
    graph[a][b] = Integer.MAX_VALUE;
   }
  }
  

  for (int a = 0; a < 7; a++) {
   for (int b = 0; b < 7; b++) {
    if (a == b)
     graph[a][b] = 0;
   }
  }
  
  
    int i = 0;
    int j = 0;
  
  while(numInitialEdges < 8) {
   
    i = (int) (Math.random() * 5);
    j = (int) (Math.random() * 5);
   
   if (i != j) {
    if (graph[i][j] == Integer.MAX_VALUE) {
     graph[i][j] = (int) (Math.random() * 20) + 1;
     numInitialEdges++;
    }
   }
  } 
     

  
  
  System.out.println("INITIAL ADJACENCY MATRIX:");
  System.out.println();
  displayGraph(graph);
  
  floydsAlgorithm(graph);
  
  System.out.println("AFTER FLOYD'S ALGORITHM...\n");
  System.out.println("FINAL ADJACENCY MATRIX:");
  System.out.println();
  displayGraph(graph);
  
  System.out.println();

  
} 


public static void displayGraph(int[][] graph) {
    System.out.println("    A   B C   D   E   F G");
    System.out.println(" ==========================");
    
    int charCode = 0;
    for (int a = 0; a < 7; a++) {
     System.out.print((char) (charCode + 65) + " ");
     
     for (int b = 0; b < 7; b++) {
      System.out.print(" ");
      if (graph[a][b] == Integer.MAX_VALUE) {
       System.out.print("---");
      } else {
      System.out.format("%3s", graph[a][b]);
      }
     }
     charCode++;
     System.out.println();
    } 
    System.out.println();
} 


public static void floydsAlgorithm(int[][] graph) {
  for (int a = 0; a < 7; a++) {
   for (int b = 0; b < 7; b++) {
    if (a != b) {
     if (graph[a][b] != Integer.MAX_VALUE) {
      for (int c = 0; c < 7; c++) {
       if (c != a) {
        if (graph[c][a] != Integer.MAX_VALUE) {
        int tempSum = graph[a][b] + graph[c][a];
        if (c != b) {
        if (graph[c][b] == Integer.MAX_VALUE) {
        graph[c][b] = tempSum;
        System.out.println("All-pairs shortest paths are:");
        displayGraph(graph);
        System.out.println("Press enter to continue:");
        try {
        if (input.read() == 13) {
        continue;
        }
        } catch (IOException e) {
        e.printStackTrace();
        }
           
        } else {
           if (tempSum < graph[c][b]) {
            
            graph[c][b] = tempSum;
            System.out.println("All-pairs shortest paths are:");
            displayGraph(graph);
            
            System.out.println("Press enter to continue:");
            try {
             
             if (input.read() == 13) {
              continue;
             }
            } catch (IOException e) {
             e.printStackTrace();
            }
           }
          }
         }
        }
       }
      }
     }
    }
   }
  } 
} 


} 