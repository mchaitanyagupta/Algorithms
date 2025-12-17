import java.util.*;
public class MinHeap<T extends Comparable<T>>
{
    private ArrayList<T> list;
    MinHeap(){
        list = new ArrayList<>();
    }
    private void swap(int f, int s){
        T t = list.get(f);
        list.set(f, list.get(s));
        list.set(s, t);
    }
    private int parent(int i){
        return (i - 1) /2;
    }
    private int left(int i){
        return (i * 2) + 1;
    }
    private int right(int i){
        return (i * 2) + 2;
    }
    public void insert(T v){
        //upheap
        list.add(v);
        upheap(list.size() - 1);
    }
    private void upheap(int i){
        int p = parent(i);
        if(i == 0)return;
        if(list.get(i).compareTo(list.get(p)) < 0){
            swap(i, p);
            upheap(p);
        }
        
    }
    public T remove() throws Exception{
        if(list.isEmpty())throw new Exception("Removing from a empty Heap!");
        T temp = list.get(0);
        T last = list.remove(list.size() - 1);
        if(!list.isEmpty())list.set(0, last);
        downheap(0);
        return temp;
    }
    private void downheap(int i){
        int min = i;
        int left = left(i);
        int right = right(i);
        if(left < list.size() && list.get(left).compareTo(list.get(min)) < 0)min = left;
        if(right < list.size() && list.get(right).compareTo(list.get(min)) < 0)min = right;
        
        if(min != i){
            swap(min, i);
            downheap(min);
        }
    }
    public ArrayList<T> heapsort() throws Exception{
        ArrayList<T> res = new ArrayList<>();
        while(!list.isEmpty()){
            res.add(this.remove());
        }
        return res;
    }
	public static void main(String[] args) throws Exception{
		System.out.println("Hello World");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		MinHeap<Integer> h = new MinHeap();
		for(int i = 0; i < n; i++){
		    h.insert(sc.nextInt());
		}
    
		System.out.println(h.remove());
		ArrayList l = h.heapsort();
		System.out.println(l);
		
	}
	
}



//this is implementation for min heap
//if we change the comparasion in methods like upheap and downheap to greater than zero then it convertts to max heap without any change in the core code base
