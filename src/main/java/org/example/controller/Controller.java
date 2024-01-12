package org.example.controller;

import org.example.model.Model;

import java.util.ArrayList;

public class Controller {
    Model model = new Model();
    ArrayList<Model> jobQueue = new ArrayList<Model>();
    ArrayList<Model> terminateQueue = new ArrayList<Model>();
    ArrayList<Model> roundRobinQueue = new ArrayList<Model>();
    ArrayList<Model> firstComeFirstServedQueue = new ArrayList<Model>();
    ArrayList<Model> monitorQueue = new ArrayList<Model>();
    ArrayList<Model> usbQueue = new ArrayList<Model>();
    int pId = 1;  //ProcessID กําหนดให้เริ่มต้นที่ ProcessID = 1
    int timeQuantum = 0; //ตัวแปลไว้เก็บค่า timeQuantum จากฝั่ง View
    int burstTime = 0; //ค่า burstTime
    int resetTimeQuantum;// ตัวแปลที่ใช่ดึงค่า timeQuantum เพื่อโยนค่าให้กับตัว Process แต่ละตัวให้ทํางานตาม timeQuantum
    int waitingTime = 0; // ใช้เก็บค่า WaitingTime
    int bTFcfs = 0;  // ใช้ แทน burstTime ใน  firstComeFirstServedQueue
    int countProcess = 0; // ใช้ นับจำนวน process ทั้งหมด
    int timeRunning = 0; // ใช้ กำหนดช่วงเวลาทำงานของ process
    int ioTime = 0;  // ใช้ กำหนดช่วงเวลาทำงานของ IO
    double avgWaitingTime = 0;
    double avgTurnaroundTime = 0;

    public Controller() {
    }

    ////////////////////////////////////////addProcess////////////////////////////////////////////////////////////////////////////
    //method ปุ่ม addProcess คือมี paramiter อยู่ 2 ตัว รับมาจากฝั่ง View คือตัวแปล clock timeQuantum Method นี้จะถูกนําไปเรียกใช้ในฝั่ง View
    public void addProcess(int clock, int timeQuantum) {
        model = new Model(pId, 0, clock);
        resetTimeQuantum = timeQuantum;
        pId++;
        countProcess++;
        jobQueue.add(model);
        select();
    }

    //Method เลือกว่าจะให้ Process เข้าไป รอเข้าทำงานที่ FCFS or RR ด้วยการสุ่ม
    public void select() {
        //TODO select
        for (int i = countProcess - 1; i < jobQueue.size(); i++) {
            if (jobQueue.get(i).getCountPercent() == 0) {
                roundRobinQueue.add(model);
                for (int j = roundRobinQueue.size() - 1; j < roundRobinQueue.size(); j++) {
                    roundRobinQueue.get(j).setTimeQuantum(resetTimeQuantum);
                }

                System.out.println(model);
            } else {
                firstComeFirstServedQueue.add(model);
                System.out.println(model);
            }
        }
    }

    public void reset() {
        jobQueue.removeAll(jobQueue);
        roundRobinQueue.removeAll(roundRobinQueue);
        firstComeFirstServedQueue.removeAll(firstComeFirstServedQueue);
        terminateQueue.removeAll(terminateQueue);
        monitorQueue.removeAll(monitorQueue);
        usbQueue.removeAll(usbQueue);
        countProcess = 0;
        avgWaitingTime = 0;
        pId = 1;
        avgTurnaroundTime = 0;
    }

    ////////////////////////////////////////process////////////////////////////////////////////////////////////////////////////
    // Method firstComeFirstServedQueue จะทำการกำหนดค่าต่างๆ การทํางานต่างๆ ในกรณีที่เข้าไปใช้งาน CPU
    public void firstComeFirstServedQueue() {
        //TODO firstComeFirstServed
        try {
            for (int i = 0; i < jobQueue.size(); i++) { //Loop ถ้า i = 0 เช็คว่า i < jobQueue.size ก็จะเพื่มค่า i ครั้งละ 1
                if (firstComeFirstServedQueue.get(0) == jobQueue.get(i)) { // ถ้า firstComeFirstServedQueue ตําแหน่งที่ 0 เท่ากับ jobQueue ตําแหน่งที่ i
                    jobQueue.get(i).setStatus(2); // ก็จะเซ็ตค่าเป็น Running
                    bTFcfs = jobQueue.get(i).getBurstTime();   //โดย get ค่า jQ Process นั้นมา ให้มีค่าเท่ากับ burstTime
                    bTFcfs++;  //และเพิ่มค่า jQ ขึ้นที่ละ 1
                    jobQueue.get(i).setBurstTime(bTFcfs); //โดยนําค่า jQ มาเก็บยัง setBurstTime ของ Process นั้น
                } else if (jobQueue.get(i).getStatus() != "Waiting") {
                    jobQueue.get(i).setStatus(1);
                }
            }
        } catch (java.lang.IndexOutOfBoundsException e) {

        }
    }

    //TODO roundRobinQueue

    // Method roundRobinQueue จะทำการกำหนดค่าต่างๆ การทํางานต่างๆ ในกรณีที่เข้าไปใช้งาน CPU
    public void roundRobinQueue() {
        try {
            for (int i = 0; i < jobQueue.size(); i++) { //Loop ถ้า i = 0 เช็คว่า i < jobQueue.size ก็จะเพื่มค่า i ครั้งละ 1
                if (roundRobinQueue.get(0) == jobQueue.get(i)) {  // ถ้า roundRobinQueue ตําแหน่งที่ 0 เท่ากับ jobQueue ตําแหน่งที่ i
                    timeQuantum = jobQueue.get(i).getTimeQuantum(); //โดย get ค่า TimeQuantum มาใช้งาน
                    timeQuantum--;  //โดยให้ค่า  timeQuantum ลดค่าลงครั้งละ 1 จนถึง 0 จึงจะสามารถเข้าไปใช้งาน if ถัดไป
                    jobQueue.get(i).setTimeQuantum(timeQuantum); //โดยนําค่า timeQuantum มาเซ็ตค่าให้กับ setQuantumTime ของ Process นั้น
                    System.out.println("TQT Running" + timeQuantum);

                    burstTime = jobQueue.get(i).getBurstTime();  //โดย get ค่า burstTime Process นั้นมา ให้มีค่าเท่ากับ burstTime
                    burstTime++;  //และเพิ่มค่า burstTime ขึ้นที่ละ 1
                    jobQueue.get(i).setBurstTime(burstTime);//โดยนําค่า burstTime มาเก็บยัง setBurstTime ของ Process นั้น
                    jobQueue.get(i).setStatus(2);  // ก็จะเซ็ตค่าเป็น Running

                    if (jobQueue.get(i).getTimeQuantum() == 0) {  // นําค่า getQuantumTime() ของ Process นั้น มาเทียบค่าว่า มีค่า เท่ากับ 0 หรือไม่ ถ้าเท่ากันก็จะเข้าเงื่อนไขเป็นจริง
                        jobQueue.get(i).setStatus(1);  //โดยถ้าเป็น 0 ก็จะเซ็ตให้ Process นั้น มีค่าสถานะเป็น Ready
                        roundRobinQueue.add(jobQueue.get(i)); //และทําการ Add Process นั้นเข้าไปรอใน roundRobinQueue เพื่อรอเข้าใช้งาน Cpu ต่อไป
                        roundRobinQueue.remove(0); //และ Remove roundRobinQueue ตําแหน่งที่ 0 ออกมาเพื่อเอา Process นั้นไปใช้งาน Cpu ต่อโดยจะไปเช็คเงื่อนไข if ด้านบนสุด
                        jobQueue.get(i).setTimeQuantum(resetTimeQuantum); //และนําค่า resetTimeQuantum ที่เรานํามาจากฝั่ง View เช็ตค่าให้กับ QuantumTime นั้นไปใช้งาน
                    }
                } else if (jobQueue.get(i).getStatus() != "Waiting") {
                    jobQueue.get(i).setStatus(1);
                }
            }
        } catch (java.lang.IndexOutOfBoundsException e) {

        }
    }

    public int getCountProcess() {
        return countProcess;
    }

    // Method สำหรับกำหนดให้ process ไหนจะได้้เข้าไปทำงานใน CPU
    public void randomRunning() {
        //TODO randomRunning
        try {
            if (!jobQueue.isEmpty()) {
                if (firstComeFirstServedQueue.isEmpty()) {
                    roundRobinQueue();
                    timeRunning = 0;
                } else if (roundRobinQueue.isEmpty()) {
                    firstComeFirstServedQueue();
                    timeRunning = 0;
                } else if (!firstComeFirstServedQueue.isEmpty() && !roundRobinQueue.isEmpty()) {
                    if (timeRunning < 80) {//ถ้า timeRunning อยู่ระหว่าง 0-79 Process ที่อยู่ใน roundRobinQueue จะได้เข้าไปทำงานที่ CPU
                        roundRobinQueue();
                        timeRunning = ++timeRunning % 100;
                    } else if (timeRunning > 79) { //ถ้า timeRunning อยู่ระหว่าง 80-99 Process ที่อยู่ใน firstComeFirstServedQueue จะได้เข้าไปทำงานที่ CPU
                        firstComeFirstServedQueue();
                        timeRunning = ++timeRunning % 100;
                    }
                }
            }
            System.out.println("timeRunning = " + timeRunning);
        } catch (java.lang.IndexOutOfBoundsException e) {

        }
    }

    // Method removeQueue จะทำการลบ Process เมื่อมีการกดปุุม End Task
    public void removeQueue(int clock) {
        try {
            for (int i = 0; i < jobQueue.size(); i++) { //Loop ถ้า i = 0 เช็คว่า i < jobQueue.size ก็จะเพื่มค่า i ครั้งละ 1
                if (!roundRobinQueue.isEmpty()) {
                    if (roundRobinQueue.get(0).getStatus() == "Running") {
                        if (roundRobinQueue.get(0) == jobQueue.get(i)) { // ถ้า roundRobinQueue ตําแหน่งที่ 0 เท่ากับ jobQueue ตําแหน่งที่ i
                            jobQueue.get(i).setStatus(4);  // ก็จะเซ็ตค่าเป็น Terminate
                            jobQueue.get(i).setTurnaroundTime(clock);
                            avgTurnaroundTime(jobQueue.get(i).getTurnaroundTime());
                            terminateQueue.add(jobQueue.get(i)); //เซ็ตค่า terminateQueue ตาม  jobQueue ตําแหน่งที่ i
                            avgWaitingTime(jobQueue.get(i).getWaitingTime());
                            jobQueue.remove(i);// ลบ  jobQueue ตําแหน่งที่ i
                            roundRobinQueue.remove(0); // ลบ  roundRobinQueue ตําแหน่งที่ 0
                            countProcess--; //ลดค่า countProcess ลงทีละ 1
                            break;
                        }
                    }
                }
                if (!firstComeFirstServedQueue.isEmpty()) {
                    if (firstComeFirstServedQueue.get(0).getStatus() == "Running") {
                        if (firstComeFirstServedQueue.get(0) == jobQueue.get(i)) {
                            jobQueue.get(i).setStatus(4);
                            jobQueue.get(i).setTurnaroundTime(clock);
                            avgTurnaroundTime(jobQueue.get(i).getTurnaroundTime());
                            terminateQueue.add(jobQueue.get(i));
                            avgWaitingTime(jobQueue.get(i).getWaitingTime());
                            jobQueue.remove(i);
                            firstComeFirstServedQueue.remove(0);
                            countProcess--;
                            break;
                        }
                    }
                }
            }
        } catch (java.lang.IndexOutOfBoundsException e) { //

        }
    }

    public void waitingTime() {
        for (int i = 0; i < jobQueue.size(); i++) { //Loop ถ้า i = 0 เช็คว่า i < jobQueue.size ก็จะเพื่มค่า i ครั้งละ 1
            if (jobQueue.get(i).getStatus() == "Ready") {  // ถ้า jobQueue ตําแหน่งที่ i เท่ากับ "Ready"
                waitingTime = jobQueue.get(i).getWaitingTime();  //โดย get ค่า waitingTime มาใช้งาน
                waitingTime++; //เพิ่มค่า waitingTime ขึ้นทีละ 1
                jobQueue.get(i).setWaitingTime(waitingTime);//โดยนําค่า waitingTime มาเก็บยัง setBurstTime ของ Process นั้น

            }
        }
    }

    public void avgWaitingTime(int waitingTime) {
        this.avgWaitingTime = this.avgWaitingTime + waitingTime;
    }

    public String getAvgWaitingTime() {
        if (terminateQueue.isEmpty()) {
            return "0";
        } else
            return String.format("%.2f", avgWaitingTime / terminateQueue.size());
    }

    public void avgTurnaroundTime(int turnaroundTime) {
        this.avgTurnaroundTime = this.avgTurnaroundTime + turnaroundTime;
    }

    public String getAvgTurnaroundTime() {
        if (terminateQueue.isEmpty()) {
            return "0";
        } else
            return String.format("%.2f", avgTurnaroundTime / terminateQueue.size());
    }

    /////////////////////////////////////////////IO///////////////////////////////////////////////////////////////
    //Method set การทำงานของ monitor
    public void monitorQueue() {
        try {
            ioTime = monitorQueue.get(0).getIoTime();
            ioTime++;
            monitorQueue.get(0).setIoTime(ioTime);
        } catch (java.lang.IndexOutOfBoundsException e) {

        }
    }

    //Method Add Process ไปยัง monitorQueue มาจาก roundRobinQueue หรือ firstComeFirstServedQueue
    public void addMonitorQueue() {
        try {
            if (!roundRobinQueue.isEmpty()) {
                for (int i = 0; i < roundRobinQueue.size(); i++) {
                    if (roundRobinQueue.get(i).getStatus() == "Running") {
                        roundRobinQueue.get(i).setStatus(3);
                        monitorQueue.add(roundRobinQueue.get(i));
                        roundRobinQueue.remove(i);
                        break;
                    }
                }
            }
            if (!firstComeFirstServedQueue.isEmpty()) {
                for (int i = 0; i < firstComeFirstServedQueue.size(); i++) {
                    if (firstComeFirstServedQueue.get(i).getStatus() == "Running") {
                        firstComeFirstServedQueue.get(i).setStatus(3);
                        monitorQueue.add(firstComeFirstServedQueue.get(i));
                        firstComeFirstServedQueue.remove(i);
                        break;
                    }
                }

            }
        } catch (java.lang.IndexOutOfBoundsException e) {

        }
    }

    //Method End MonitorQueue กลับไปยัง roundRobinQueue หรือ firstComeFirstServedQueue
    public void endMonitorQueue() {
        try {
            if (monitorQueue.get(0).getCountPercent() == 0) {
                monitorQueue.get(0).setStatus(1);
                roundRobinQueue.add(monitorQueue.get(0));
                monitorQueue.remove(0);
            } else {
                monitorQueue.get(0).setStatus(1);
                firstComeFirstServedQueue.add(monitorQueue.get(0));
                monitorQueue.remove(0);
            }
        } catch (java.lang.IndexOutOfBoundsException e) {

        }
    }

    public void waitingTimeMonitorQueue() {
        for (int i = 1; i < monitorQueue.size(); i++) { //Loop ถ้า i = 1 เช็คว่า i < monitorQueue.size ก็จะเพื่มค่า i ครั้งละ 1
            if (monitorQueue.get(i).getStatus() == "Waiting") {  // ถ้า monitorQueue ตําแหน่งที่ i เท่ากับ "Waiting"
                waitingTime = monitorQueue.get(i).getWaitingTime();  //โดย get ค่า waitingTime มาใช้งาน
                waitingTime++; //เพิ่มค่า waitingTime ขึ้นทีละ 1
                monitorQueue.get(i).setWaitingTime(waitingTime);//โดยนําค่า waitingTime มาเก็บยัง setBurstTime ของ Process นั้น

            }
        }
    }

    //Method set การทำงานของ USB
    public void usbQueue() {
        try {
            ioTime = usbQueue.get(0).getIoTime();
            ioTime++;
            usbQueue.get(0).setIoTime(ioTime);
        } catch (java.lang.IndexOutOfBoundsException e) {

        }
    }

    //Method Add Process ไปยัง usbQueue มาจาก roundRobinQueue หรือ firstComeFirstServedQueue
    public void addUsbQueue() {
        try {
            if (!roundRobinQueue.isEmpty()) {
                for (int i = 0; i < roundRobinQueue.size(); i++) {
                    if (roundRobinQueue.get(i).getStatus() == "Running") {
                        roundRobinQueue.get(i).setStatus(3);
                        usbQueue.add(roundRobinQueue.get(i));
                        roundRobinQueue.remove(i);
                        break;
                    }
                }
            }
            if (!firstComeFirstServedQueue.isEmpty()) {
                for (int i = 0; i < firstComeFirstServedQueue.size(); i++) {
                    if (firstComeFirstServedQueue.get(i).getStatus() == "Running") {
                        firstComeFirstServedQueue.get(i).setStatus(3);
                        usbQueue.add(firstComeFirstServedQueue.get(i));
                        firstComeFirstServedQueue.remove(i);
                        break;
                    }
                }

            }
        } catch (java.lang.IndexOutOfBoundsException e) {

        }
    }

    //Method End usbQueue กลับไปยัง roundRobinQueue หรือ firstComeFirstServedQueue
    public void endUsbQueue() {
        try {
            if (usbQueue.get(0).getCountPercent() == 0) {
                usbQueue.get(0).setStatus(1);
                roundRobinQueue.add(usbQueue.get(0));
                usbQueue.remove(0);
            } else {
                usbQueue.get(0).setStatus(1);
                firstComeFirstServedQueue.add(usbQueue.get(0));
                usbQueue.remove(0);
            }
        } catch (java.lang.IndexOutOfBoundsException e) {

        }
    }

    public void waitingTimeUsbQueue() {
        for (int i = 1; i < usbQueue.size(); i++) { //Loop ถ้า i = 1 เช็คว่า i < monitorQueue.size ก็จะเพื่มค่า i ครั้งละ 1
            if (usbQueue.get(i).getStatus() == "Waiting") {  // ถ้า monitorQueue ตําแหน่งที่ i เท่ากับ "Waiting"
                waitingTime = usbQueue.get(i).getWaitingTime();  //โดย get ค่า waitingTime มาใช้งาน
                waitingTime++; //เพิ่มค่า waitingTime ขึ้นทีละ 1
                usbQueue.get(i).setWaitingTime(waitingTime);//โดยนําค่า waitingTime มาเก็บยัง setBurstTime ของ Process นั้น

            }
        }
    }

    ////////////////////////////////////////Show////////////////////////////////////////////////////////////////////////////
    //Method สำหรับ set ค่าเริ่มต้นให้กับ index ฝั่ง view
    public int setIndexRr() {
        int index = 0;
        if (!roundRobinQueue.isEmpty())
            if (roundRobinQueue.get(0).getStatus() == "Running") {
                index = 1;
            } else {
                index = 0;
            }

        return index;
    }

    public int setIndexFcfs() {
        int index = 0;
        if (!firstComeFirstServedQueue.isEmpty()) {
            if (firstComeFirstServedQueue.get(0).getStatus() == "Running") {
                index = 1;
            } else {
                index = 0;
            }
        }
        return index;
    }

    //Method showJobQueue  จะทำการเอาค่าตัวแปรมาเก็บไว้ในตัวแปรที่ชื่อว่า text แล้วจะนำไปเรียกใช้ที่ฝั่ง View
    //Method ที่ชื่อว่า Show โดยทั้งหมดแล้วจะถูกเรียกใช้ที่ฝั่ง View เหมือนกัน
    public String showJobQueue() {
        String text = "";
        for (int index = 0; index < jobQueue.size(); index++) {
            text = text + jobQueue.get(index).getProcessID() + " ";
            text = text + jobQueue.get(index).getStatus() + " ";
            text = text + jobQueue.get(index).getArrivalTime() + " ";
            text = text + jobQueue.get(index).getBurstTime() + " ";
            text = text + jobQueue.get(index).getWaitingTime() + " ";
            text = text + jobQueue.get(index).getIoTime() + " ";
            text = text + (jobQueue.get(index).getCountPercent() + 1) + " ";
            text = text + ",";
        }
        return text;
    }

    public String showFirstComeFirstServedQueue() {
        String text = "";
        for (int index = 0; index < firstComeFirstServedQueue.size(); index++) {
            text = text + firstComeFirstServedQueue.get(index).getProcessID() + " ";
            text = text + firstComeFirstServedQueue.get(index).getStatus() + " ";
            text = text + firstComeFirstServedQueue.get(index).getArrivalTime() + " ";
            text = text + firstComeFirstServedQueue.get(index).getBurstTime() + " ";
            text = text + firstComeFirstServedQueue.get(index).getWaitingTime() + " ";
            text = text + ",";
        }
        return text;
    }

    public String showRoundRobinQueue() {
        String text = "";
        for (int index = 0; index < roundRobinQueue.size(); index++) {
            text = text + roundRobinQueue.get(index).getProcessID() + " ";
            text = text + roundRobinQueue.get(index).getStatus() + " ";
            text = text + roundRobinQueue.get(index).getArrivalTime() + " ";
            text = text + roundRobinQueue.get(index).getBurstTime() + " ";
            text = text + roundRobinQueue.get(index).getWaitingTime() + " ";
            text = text + ",";
        }
        return text;
    }

    public String showTerminateQueue() {
        String text = "";
        for (int index = 0; index < terminateQueue.size(); index++) {
            text = text + terminateQueue.get(index).getProcessID() + " ";
            text = text + terminateQueue.get(index).getStatus() + " ";
            text = text + terminateQueue.get(index).getWaitingTime() + " ";
            text = text + terminateQueue.get(index).getTurnaroundTime() + " ";
            text = text + ",";
        }
        return text;
    }

    public String showCPU() {
        String text = "";
        for (int index = 0; index < jobQueue.size(); index++) {
            if (jobQueue.get(index).getStatus() == "Running") {
                text = text + jobQueue.get(index).getProcessID() + " ";
                text = text + jobQueue.get(index).getStatus() + " ";
                text = text + (jobQueue.get(index).getCountPercent() + 1) + " ";
                text = text + ",";
            }

        }
        return text;
    }

    public String showMonitor() {
        String text = "";
        for (int index = 0; index < monitorQueue.size(); index++) {
            text = text + monitorQueue.get(0).getProcessID() + " ";
            text = text + monitorQueue.get(0).getStatus() + " ";
            text = text + monitorQueue.get(0).getIoTime() + " ";
            text = text + ",";
        }
        return text;
    }

    public String showMonitorQueue() {
        String text = "";
        for (int index = 0; index < monitorQueue.size(); index++) {
            text = text + monitorQueue.get(index).getProcessID() + " ";
            text = text + monitorQueue.get(index).getStatus() + " ";
            text = text + monitorQueue.get(index).getWaitingTime() + " ";
            text = text + ",";
        }
        return text;
    }

    public String showUsb() {
        String text = "";
        for (int index = 0; index < usbQueue.size(); index++) {
            text = text + usbQueue.get(0).getProcessID() + " ";
            text = text + usbQueue.get(0).getStatus() + " ";
            text = text + usbQueue.get(0).getIoTime() + " ";
            text = text + ",";
        }
        return text;
    }

    public String showUsbQueue() {
        String text = "";
        for (int index = 0; index < usbQueue.size(); index++) {
            text = text + usbQueue.get(index).getProcessID() + " ";
            text = text + usbQueue.get(index).getStatus() + " ";
            text = text + usbQueue.get(index).getWaitingTime() + " ";
            text = text + ",";
        }
        return text;
    }

}