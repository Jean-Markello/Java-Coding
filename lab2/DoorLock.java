public class DoorLock {
    // Constant.
    public static final int MAX_NUMBER_OF_ATTEMPTS = 3;

    // Instance variables.
    private Combination combination;
    private boolean open;
    private boolean activated;
    private int numberOfAttempts;

    // Constructor.
    public DoorLock( Combination combination ) {
        this.combination=combination;
        activated=true;
        open=false;
        numberOfAttempts=0;
    }

    public boolean isOpen() {
        if (open==true) {
            open=true;
        } else{
            open=false;
        }
        return open;
    }

    public boolean isActivated() {
        if (activated==true) {
            activated=true;
        } else {
            activated=false;
        }
        return activated;
    }

    public boolean open( Combination combination ) {
        if (this.combination.equals(combination) && activated==true) {
            open=true;
            numberOfAttempts=0;
            return true;
        } else {
            numberOfAttempts += 1;
            if (numberOfAttempts == MAX_NUMBER_OF_ATTEMPTS) {
                activated = false;
                numberOfAttempts=0;
            }
        } return false;
    }

    public void activate( Combination c ) {
        if (c.equals(combination)){
            activated=true;
        }
    }
}
