package net.fortresswars.respawn;

public record RespawnTimes(int low, int medium, int high) {

    public RespawnTimes(int low, int medium, int high) {
        this.low = low;
        this.medium = medium;
        this.high = high;
        validate();
    }

    void validate() throws IllegalArgumentException {
        if (low > medium) throw new IllegalArgumentException("low time can't be higher than medium time");
        if (medium > high) throw new IllegalArgumentException("medium time can't be higher than high time");
        if (low < 0) throw new IllegalArgumentException("low time can't be lower than 0");
    }
}
