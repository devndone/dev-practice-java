package practice.dev.problemsolving;

import java.util.ArrayList;

public class SpiralOrder2DArrayGeneration {
	
	public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
		 //public static Integer[][] generateMatrix(int a) {
			 int t = 0, b = (a - 1), l = 0, r = (a - 1), dir = 0;
			 int num = 0;
			 Integer[][] result = new Integer[a][a];
			 //System.out.println(result.length);
			 while(t <= b && l <= r) {
			     if(dir == 0) {
			    	 if(result[t] == null) {
			    		 result[t] = new Integer[a];
			    		 //System.out.println(result[t].length);
			    	 }
			         for(int i = l; i <= r; i++) {
			            result[t][i] = ++num;
			         }
			         t++;
			     } else if(dir == 1) {
			    	 for(int i = t; i <= b; i++) {
			    		 if(result[i] == null) {
				    		 result[i] = new Integer[a];
				    		 //System.out.println(result[i].length);
				    	 }
			    		 result[i][r] = ++num;
			         }
			         r--;
			     } else if(dir == 2) {
			    	 if(result[b] == null) {
			    		 result[b] = new Integer[a];
			    		 //System.out.println(result[b].length);
			    	 }
			         for(int i = r; i >= l; i--) {
			        	 result[b][i] = ++num;
			         }
			         b--;
			     } else if(dir == 3) {
			    	 for(int i = b; i >= t; i--) {
			        	 if(result[i] == null) {
				    		 result[i] = new Integer[a];
				    		 //System.out.println(result[i].length);
				    	 }
			        	 result[i][l] = ++num;
			         }
			         l++;
			     }
			     dir = (dir + 1) % 4;
			 }
			 return twoDArrayToList(result);
		}
		
	private static ArrayList<ArrayList<Integer>> twoDArrayToList(Integer[][] twoDArray) {
	    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	    int i = 0;
	    for (Integer[] array : twoDArray) {
	    	list.add(i, new ArrayList<Integer>(array.length));
	    	for (Integer array1 : array) {
	    		list.get(i).add(array1);
	    		
	    	}
	    	i++;
	    }
	    return list;
	}
	
	public static Integer[][] generateMatrix1(int a) {
			 int t = 0, b = (a - 1), l = 0, r = (a - 1), dir = 0;
			 int num = 0;
			 Integer[][] result = new Integer[a][a];
			 //System.out.println(result.length);
			 while(t <= b && l <= r) {
			     if(dir == 0) {
			    	 if(result[t] == null) {
			    		 result[t] = new Integer[a];
			    		 //System.out.println(result[t].length);
			    	 }
			         for(int i = l; i <= r; i++) {
			            result[t][i] = ++num;
			         }
			         t++;
			     } else if(dir == 1) {
			    	 for(int i = t; i <= b; i++) {
			    		 if(result[i] == null) {
				    		 result[i] = new Integer[a];
				    		 //System.out.println(result[i].length);
				    	 }
			    		 result[i][r] = ++num;
			         }
			         r--;
			     } else if(dir == 2) {
			    	 if(result[b] == null) {
			    		 result[b] = new Integer[a];
			    		 //System.out.println(result[b].length);
			    	 }
			         for(int i = r; i >= l; i--) {
			        	 result[b][i] = ++num;
			         }
			         b--;
			     } else if(dir == 3) {
			    	 for(int i = b; i >= t; i--) {
			        	 if(result[i] == null) {
				    		 result[i] = new Integer[a];
				    		 //System.out.println(result[i].length);
				    	 }
			        	 result[i][l] = ++num;
			         }
			         l++;
			     }
			     dir = (dir + 1) % 4;
			 }
			 return result;
		}
	
	public static void main(String[] args) {
		Integer[][] a = generateMatrix1(4);
		int n = 0, m = 0;
		while (n < a.length) {
			System.out.println("[");
			while(m < a.length) {
				System.out.print(", " + a[n][m]);
				m++;
			}
			m = 0;
			System.out.println("]\n");
			n++;
		}
	}
}

