class MyCircularQueue {
    private int[] arr;
    private int start;
    private int end;
    private int k;

    public MyCircularQueue(int k) {
        this.k = k;
        this.arr = new int[k + 1];
        this.start = 0;
        this.end = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        arr[end] = value;
        end++;
        end %= k + 1;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        int value = arr[start];
        start++;
        start %= k + 1;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return arr[start];
    }
    
    public int Rear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int idx = end - 1;
        idx += k + 1;
        idx %= k + 1;
        return arr[idx]; 
    }
    
    public boolean isEmpty() {
        return start == end;
    }
    
    public boolean isFull() {
        return (end + 1) % (k + 1) == start;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */