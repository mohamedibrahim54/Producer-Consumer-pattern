public class Producer {
    public void produce(){
        synchronized (Lock.instance){
            if (DataBuffer.isFull()) {
                try {
                    Lock.instance.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            DataBuffer.write((int)(Math.random()* 100));
            Lock.instance.notify();
        }
    }
}
