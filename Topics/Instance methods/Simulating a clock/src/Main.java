class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        if (hours == 12 && minutes == 59) {
            this.hours = 1;
            this.minutes = 0;
        } else if (hours != 12 && minutes == 59) {
            this.hours++;
            this.minutes = 0;
        } else {
            this.minutes++;
        }
    }
}

