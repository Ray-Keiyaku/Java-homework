class Main {
    public static void main(String[] args) {
        Thread[] t = new Thread[4];
        for (int i = 0; i < 4; i++) {
            t[i] = new Thread(new MyRunnable(i));
            t[i].start(); // 启动新线程
        }

    }
}

class MyRunnable implements Runnable {
    private int index;

    MyRunnable() {
    }

    MyRunnable(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        while (!Count.isEnough()) {
            System.out.println("station: " + (index + 1) + " number: " + Count.add());
        }
    }
}

class Count {
    private static int count = 0;

    public static synchronized int add() {
        count++;
        return count;
    }

    public static boolean isEnough() {
        return count >= 100;
    }
}