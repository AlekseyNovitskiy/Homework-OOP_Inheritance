package transport;

public interface Competing {
    void pitStop();

    int getBestLapTime();

    int getMaxSpeed();
}
