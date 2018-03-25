package F21AS_Gita_Abdelraman_Maha_Nicholas;

public interface CSubject {
    /**
     * Register an observer with this subject
     */
    public void registerCObserver(CObserver obs);

    /**
     * De-register an observer with this subject
     */
    public void removeCObserver(CObserver obs);

    /**
     * Inform all registered observers that there's been an update
     */
    public void notifyCObservers();
}
