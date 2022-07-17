import java.util.*;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class LcpRecursiveTask extends RecursiveTask<String> {

    private final List<String> words;

    public LcpRecursiveTask(List<String> words) {
        this.words = words;
    }

    @Override
    protected String compute() {
        if (words.size() > 2) {
            return ForkJoinTask.invokeAll(createSubtasks())
                    .stream()
                    .map(ForkJoinTask::join)
                    .min(Comparator.comparing(String::length))
                    .orElse("");
        } else {
            return processing(words);
        }
    }

    private Collection<LcpRecursiveTask> createSubtasks() {
        List<LcpRecursiveTask> dividedTasks = new ArrayList<>();
        int mid = words.size() / 2;
        dividedTasks.add(new LcpRecursiveTask(words.subList(0, mid)));
        dividedTasks.add(new LcpRecursiveTask(words.subList(mid, words.size())));
        return dividedTasks;
    }

    private String processing(List<String> words) {
        if (words.size() <= 1) {
            return words.get(0);
        }
        return lcp(words.get(0), words.get(1));
    }

    private String lcp(String s1, String s2) {
        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()) {

            if (s1.charAt(i) != s2.charAt(j)) break;

            i++;
            j++;
        }

        return s1.substring(0, i);
    }
}
