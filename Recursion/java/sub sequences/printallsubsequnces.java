/*
-----------
pseudo code
-----------

 * 
 * 
 * 
 *     
 * 
 *              f(0, [])
               /        \
          Take 1         Don't Take 1
         f(1, [1])       f(1, [])
        /        \      /        \
    Take 2    Don't   Take 2   Don't
   f(2,[1,2]) f(2,[1]) f(2,[2]) f(2,[])
      |         |        |        |
    [1,2]     [1]      [2]      []
 * 
 * 
 * 
 * 
 *                   f(0, [])
                   /        \
              Take 3         Don't Take 3
             f(1, [3])       f(1, [])
            /        \      /        \
        Take 2    Don't    Take 2   Don't
       f(2,[3,2]) f(2,[3]) f(2,[2]) f(2,[])
       /    \     /    \    /    \   /    \
   Take 1 Don't Take 1 Don't Take 1 Don't Take 1 Don't
  f(3,[3,2,1]) f(3,[3,2]) f(3,[3,1]) f(3,[3]) f(3,[2,1]) f(3,[2]) f(3,[1]) f(3,[])
      |         |          |         |         |         |        |        |
   [3,2,1]   [3,2]      [3,1]      [3]      [2,1]      [2]      [1]      []
   \

    * f(i,[]){
 *  if(i > = n){
 *      print([]);
 * }
 * [].add(arr[i])
 * 
 * f(i+1, []) --> take 
 * 
 * [].remove(arr[i])
 * 
 * f(i+1,[]) --> not take
 * }
 * this is the pseudo code
 */

import java.util.*;
public class printallsubsequnces {
       public static void printSubsequences(int[] arr, int index, List<Integer> current){
              int n = arr.length;
              if(index >= n){
                System.out.println(current);
                return;1
              }

              current.add(arr[index]);

              printSubsequences(arr, index+1, current);

              current.remove(current.size() -1);

              printSubsequences(arr, index+1, current);
       }

       public static void main(String args[]){
                int[] arr = {3,2,1};

                List<Integer> current = new ArrayList<>();

                printSubsequences(arr, 0, current);


       }
}
