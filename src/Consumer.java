public class Consumer {
    public void consume(){
        synchronized (Lock.instance){
            if (DataBuffer.isEmpty()) {
                try {
                    Lock.instance.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            DataBuffer.read();
            Lock.instance.notify();
        }
    }
}
