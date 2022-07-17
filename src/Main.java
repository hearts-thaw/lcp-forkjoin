import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("techie delight", "tech", "techie",
                "technology", "technical");

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        LcpRecursiveTask recursiveTask = new LcpRecursiveTask(words);
        String result = forkJoinPool.invoke(recursiveTask);

        System.out.println("The longest common prefix is " + result);
    }
}