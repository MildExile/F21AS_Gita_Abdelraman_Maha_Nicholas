package F21AS_Gita_Abdelraman_Maha_Nicholas;

public interface QSubject {
    /**
     * Register an observer with this subject
     */
    public void registerQObserver(QObserver obs);

    /**
     * De-register an observer with this subject
     */
    public void removeQObserver(QObserver obs);

    /**
     * Inform all registered observers that there's been an update
     */
    public void notifyQObservers();
}
