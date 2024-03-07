package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    @Test
    public void setCurrentStationRegularFlow() {
        Radio radio = new Radio();

        radio.setCurrentStation(8);

        int expected = 8;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setCurrentStationOverMaximum() {
        Radio radio = new Radio();

        radio.setCurrentStation(8);
        radio.setCurrentStation(15);

        int expected = 8;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setCurrentStationUnderMinimum() {
        Radio radio = new Radio();

        radio.setCurrentStation(8);
        radio.setCurrentStation(-5);

        int expected = 8;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextStationIfUnder9() {
        Radio radio = new Radio();

        radio.setCurrentStation(8);
        radio.nextStation();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextStationIf9() {
        Radio radio = new Radio();

        radio.setCurrentStation(9);
        radio.nextStation();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void prevStationIfOver0() {
        Radio radio = new Radio();

        radio.setCurrentStation(8);
        radio.prevStation();

        int expected = 7;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void prevStationIf0() {
        Radio radio = new Radio();

        radio.setCurrentStation(0);
        radio.prevStation();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeUnder100() {
        Radio radio = new Radio();

        for (int i = 0; i < 2; i++) {
            radio.increaseVolume();
        }

        int expected = 2;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeOver100() {
        Radio radio = new Radio();

        for (int i = 0; i < 200; i++) {
            radio.increaseVolume();
        }

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void decreaseVolumeUnder0() {
        Radio radio = new Radio();

        for (int i = 0; i < 2; i++) {
            radio.decreaseVolume();
        }

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void decreaseVolumeUnder100() {
        Radio radio = new Radio();

        for (int i = 0; i < 30; i++) {
            radio.increaseVolume();
        }
        for (int i = 0; i < 5; i++) {
            radio.decreaseVolume();
        }

        int expected = 25;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}