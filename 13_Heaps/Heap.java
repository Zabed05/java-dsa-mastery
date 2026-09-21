import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

    private  ArrayList<T> list;

    // Constructor 
    public Heap(){
        list = new  ArrayList<>();
    }

    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index){
        return (index - 1)/2;
    }
    private int left(int index){
        return index * 2 + 1;
    }
    private int right(int index){
        return index * 2 + 2;
    }

    // Inserting items in a heap (using heapify up)
    public void insert (T value){
        list.add(value);
        upHeap(list.size() - 1);
    }
    private void upHeap(int index){
        if(index == 0){
            return;
        }
        int p = parent(index);

        if(list.get(index).compareTo(list.get(p)) < 0){
            swap(index, p);
        }
        upHeap(p);
    }

    // Removing item from a heap (using heapify down)
    public T remove() throws Exception {
        if(list.isEmpty()){
            throw new Exception("you are removing from an empty heap!");
        }

        T temp = list.get(0);

        T last = list.remove(list.size() - 1);
        if(!list.isEmpty()){
            list.set(0, last);
            downHeap(0);
        }
        return temp;
    }
    private void downHeap(int index){
        int min = index;
        int left = left(index);
        int right = right(index);

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0){
            min = left;
        }

        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0){
            min = right;
        }

        if(min != index){
            swap(min, index);
            downHeap(min);
        }
    }
}