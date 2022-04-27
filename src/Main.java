public class Main {
    public static void main(String[] args) {
        System.out.println("Data Buffer Capacity: " + DataBuffer.capacity());

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable producerRunnable = () ->{
            for (int i = 0; i < 25; i++) {
                producer.produce();
            }
        };
        Runnable consumerRunnable = () ->{
            for (int i = 0; i < 20; i++) {
                consumer.consume();
            }
        };

        Thread producerThread = new Thread(producerRunnable);
        Thread consumerThread = new Thread(consumerRunnable);

        producerThread.start();
        consumerThread.start();

        System.out.println("Data Buffer Size before join: " + DataBuffer.size());

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Data Buffer Size after join: " + DataBuffer.size());
    }
}
