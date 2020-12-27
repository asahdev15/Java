package multithreading.synchronization;

public class LivelockCommonResource {
    private LivelockWorker owner;

    public LivelockCommonResource(LivelockWorker d) {
        owner = d;
    }

    public LivelockWorker getOwner () {
        return owner;
    }

    public synchronized void setOwner (LivelockWorker d) {
        owner = d;
    }
}