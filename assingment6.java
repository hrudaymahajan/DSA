
/*Represent a given graph using adjacency matrix/list to perform DFS
using adjacency list to perform BFS. Use the map of the area around the college as the
graph. Identify the prominent land marks as nodes and perform DFS and BFS on that*/




import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class graph{
    List<List<Integer>> node;
    boolean done[];
    graph(int N){
    node= new ArrayList<>();
    done=new boolean[N];

    for(int i=0;i<N;i++){
        node.add(i,new ArrayList<>());
    }
    }
public void edge(int a,int b){
        node.get(a).add(b);
        node.get(b).add(a);
}
public void bfs(int start){
    Queue<Integer> queue=new LinkedList<>();

    queue.add(start);
    done[start]=true;
    while(!queue.isEmpty()){
    int N=queue.poll();
    System.out.println(N+"");
    List<Integer>sublist=node.get(N);
     for(int sub: sublist){
        if(!done[sub]){
             queue.add(sub);
                done[sub]=true;
             }

      }
    }


}
public void dfs( int start){
    Stack<Integer>stack=new Stack<>();
    stack.push(start);
    done[start]=true;

    while(!stack.isEmpty()){
        int N=stack.pop();
        System.out.println(N+"");

        List<Integer>sublist=node.get(N);
        for(int sub:sublist){
            if(!done[sub]){
                stack.push(sub);
                done[sub]=true;
            }

            }
        }


    }

    }



public class assingment6{
    public static void main(String[] args)
{
    int nodes=7;
   int nodes2=7;
    graph a=new graph(nodes);
    a.edge(0, 1);
    a.edge(0, 2);
    a.edge(0, 3);
    a.edge(1, 4);
    a.edge(2, 4);
    a.edge(2, 5);
    a.edge(4, 5);
    
    a.bfs(0);

    graph b=new graph(nodes2); 
    System.out.println("dsf"); 

    b.edge(0, 1);
    b.edge(0, 2);
    b.edge(1, 3);
    b.edge(2, 4);
    b.edge(3, 5);
    b.edge(4, 5);
    b.edge(4, 6);

    b.bfs(0);
   
}


}
