package domain;

import exceptions.PerformanceException;

public interface Performer {

    public void perform() throws PerformanceException;
}