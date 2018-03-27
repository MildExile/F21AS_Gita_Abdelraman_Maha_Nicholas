package F21AS_Gita_Abdelraman_Maha_Nicholas;

public interface FSubject {
    /**
     * Register an observer with this subject
     */
    public void registerFObserver(FObserver obs);

    /**
     * De-register an observer with this subject
     */
    public void removeFObserver(FObserver obs);

    /**
     * Inform all registered observers that there's been an update
     */
    public void notifyFObservers();
}
