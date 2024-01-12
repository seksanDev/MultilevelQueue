package org.example.model;

import lombok.Data;

@Data
public class Model {

    String status[] = {"New", "Ready", "Running", "Waiting", "Terminate"};
    private int processID;
    private int arrivalTime;
    private int waitingTime;
    private int ioTime;
    private int burstTime;
    private int countPercent;
    private int timeQuantum;
    private int index;
    private int turnaroundTime;

    public Model(int processID, int index, int arrivalTime) {
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.countPercent = rd();
        this.index = index;
    }

    public Model() {

    }

    public int rd() {
        if (Math.random() > 0.5) {
            return 1;
        } else
            return 0;
    }

    public String getStatus() {

        return status[index];
    }

    public void setStatus(int index) {

        this.index = index;
    }
}