public class DataBuffer {
    private static final int CAPACITY = 20;
    private static int size = 0;
    public static int[] data = new int[CAPACITY];

    public static void write(int value){
        data[size++] = value;
    }

    public static int read(){
        return data[--size];
    }

    public static boolean isEmpty(){
        if (size == 0) {
            return true;
        }
        return false;
    }

    public static boolean isFull() {
        if (size == CAPACITY) {
            return true;
        }
        return false;
    }

    public static int size(){
        return size;
    }

    public static int capacity(){
        return CAPACITY;
    }
}
