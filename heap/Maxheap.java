import java.util.*;

public class Maxheap
{
    public static List<Integer> ar = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Maxheap mheap = new Maxheap();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++){
		    insert(sc.nextInt());
		}
		System.out.println(ar.get(0));
		int f = remove();
		System.out.println(f);
		System.out.println(ar.get(0));
	}
	public static void insert(int n){
	    ar.add(n);
	    int i = ar.size() - 1;
	    int p = (i - 1) / 2;
	    while(ar.get(p) < ar.get(i) && i > 0){
	        int t = ar.get(p);
	        ar.set(p, ar.get(i));
	        ar.set(i, t);
	        i = p;
	        p = (i - 1) / 2;
	    }
	}
	public static int remove(){
	    int res = ar.get(0);
	    int i = ar.size() - 1;
	    ar.set(0, ar.get(i));
	    i = 0;
	    int left = (i * 2) + 1;
	    int right = (i * 2) + 2;
	    while(ar.size() > left){
	        if(ar.get(i) < ar.get(left) || ar.get(i) < ar.get(right)){
	            if(ar.get(i) < ar.get(left) && ar.get(left) > ar.get(right)){
	                int t = ar.get(i);
	                ar.set(i,ar.get(left));
	                ar.set(left, t);
	                i = left;
	            }else{
	                int t = ar.get(i);
	                ar.set(i, ar.get(right));
	                ar.set(right, t);
	                i = right;
	            }
	            left = (i * 2) + 1;
	            right = (i * 2) + 2;
	        }else{
	            break;
	        }
	    }
	    return res;
	}
}
