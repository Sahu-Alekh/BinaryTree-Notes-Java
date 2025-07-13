import java.util.*;

public class Heap_Implimentation {

    static class HEAP {
        ArrayList<Integer> arr = new ArrayList<>();

        //Addition in the heap
        public void Add(int data) {
            arr.add(data);

            int x = arr.size() - 1; //corent location
            int par = (x - 1) / 2; //parent location

            while(arr.get(x) < arr.get(par)) { // Swaping Function
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;                    //Updating the locations
                par = (x - 1) / 2;
            }
        }



        //Removeing in the heap
        public void remove() {
            //step1 - swap first and last index data
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step2 - delete the last index data
            arr.remove(arr.size()-1);

            //step3 - hepify function to correct our Binary tree/heap
            heapfy(0);
        }



        //O(log n) time complexity
        private void heapfy(int i) { //taking that index to fix it
            
            int leftChild = 2*i+1;
            int RightChild = 2*i+2;
            int minInd = i;

            //it check if we are in the leaf/last node && what is min value minIndex or the leftChild and store it in the minIndex
            if(leftChild < arr.size() && arr.get(minInd) > arr.get(leftChild)) {
                minInd = leftChild;
            }

            //Same for right also
            if(RightChild < arr.size() && arr.get(minInd) > arr.get(RightChild)) {
                minInd = RightChild;
            }

            //in up we stored the min value Index
            //now its time to swap the both index values with i and minIndex 
            if(minInd != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minInd));
                arr.set(minInd, temp);

                heapfy(minInd);
            }
        }


        //peak from Heap
        public int Peak() {
            return arr.get(0);
        }

        //IsEmpty
        public boolean Isempty(){
            return arr.size() == 0;
        }
    }

    public static void main(String args[]) {
        HEAP h= new HEAP();

        h.Add(8);
        h.Add(2);
        h.Add(7);
        h.Add(3);

        while (!h.Isempty()) {
            System.out.println(h.Peak());
            h.remove();
        }
    }
}
