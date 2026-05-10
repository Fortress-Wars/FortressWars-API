package net.fortresswars.core.services;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FortressWarsExecutorService {

    private final ExecutorService executor;

    public FortressWarsExecutorService() {
        this.executor = Executors.newSingleThreadExecutor();
    }

    public <T> CompletableFuture<T> supplyAsync(Callable<T> task) {
        final CompletableFuture<T> future = new CompletableFuture<>();
        executor.submit(() -> {
            try {
                final T result = task.call();
                future.complete(result);
            } catch (Exception e) {
                future.completeExceptionally(e);
            }
        });
        return future;
    }

    public void shutdown() {
        executor.shutdown();
    }
}
