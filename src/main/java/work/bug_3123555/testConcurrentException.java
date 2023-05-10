package work.bug_3123555;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class testConcurrentException {

    public static void main(String[] args) {

        final ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> {
            while (true) {
                String a = "a";
                if ("a".equals(a)) {
                    throw new NullPointerException();
                }
                System.out.println("thread finish");
            }
        });
        System.out.println("finish");
    }
}
