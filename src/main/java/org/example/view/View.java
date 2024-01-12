package org.example.view;

import org.example.controller.Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class View extends javax.swing.JFrame {
    Timer mytime = new Timer();
    Controller controller = new Controller();
    private int clock;
    //TODO setTimeQuantum
    private int timeQuantum = 5;
    private javax.swing.JButton jButtonAddProcess;
    private javax.swing.JButton jButtonEndTask;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonAddIoMonitor;
    private javax.swing.JButton jButtonAddIoUsb;
    private javax.swing.JButton jButtonEndIoMonitor;
    private javax.swing.JButton jButtonEndIoUsb;
    private javax.swing.JLabel jLabelCpu;
    private javax.swing.JLabel jLabelClock;
    private javax.swing.JLabel jLabelClockTime;
    private javax.swing.JLabel jLabelClockMs;
    private javax.swing.JLabel jLabelFcfs;
    private javax.swing.JLabel jLabelIoQUsb;
    private javax.swing.JLabel jLabelIoQueue;
    private javax.swing.JLabel jLabelIoMonitor;
    private javax.swing.JLabel jLabelJobQueue;
    private javax.swing.JLabel jLabelRr;
    private javax.swing.JLabel jLabelTqTime;
    private javax.swing.JLabel jLabelTimeQuantum;
    private javax.swing.JLabel jLabelTimeTurnaround;
    private javax.swing.JLabel jLabelTotalProcess;
    private javax.swing.JLabel jLabelAvgWaitingTime;
    private javax.swing.JLabel jLabelAvgTime;
    private javax.swing.JLabel jLabelAvgMs;
    private javax.swing.JLabel jLabelMultilevelQueue;
    private javax.swing.JLabel jLabelProcessTotal;
    private javax.swing.JLabel jLabelTerminate;
    private javax.swing.JLabel jLabelTurnaroundMs;
    private javax.swing.JLabel jLabelTurnaround;
    private javax.swing.JPanel jPanelAddEndIo;
    private javax.swing.JPanel jPanelAllButton;
    private javax.swing.JPanel jPanelAllTime;
    private javax.swing.JPanel jPanelIoQUsb;
    private javax.swing.JPanel jPanelIoMonitor;
    private javax.swing.JPanel jPanelIoQueue;
    private javax.swing.JPanel jPanelJobQueue;
    private javax.swing.JPanel jPanelRrFcfs;
    private javax.swing.JPanel jPanelShowSys;
    private javax.swing.JPanel jPanelTerminate;
    private javax.swing.JScrollPane jScrollPane_CPU;
    private javax.swing.JScrollPane jScrollPaneFcfs;
    private javax.swing.JScrollPane jScrollPaneIoQUsb;
    private javax.swing.JScrollPane jScrollPaneIoMonitor;
    private javax.swing.JScrollPane jScrollPaneJobQueue;
    private javax.swing.JScrollPane jScrollPanePCpu;
    private javax.swing.JScrollPane jScrollPaneRr;
    private javax.swing.JScrollPane jScrollPaneMonitor;
    private javax.swing.JScrollPane jScrollPaneTerminate;
    private javax.swing.JTable jTableCpu;
    private javax.swing.JTable jTableFcfs;
    private javax.swing.JTable jTableIoQUsb;
    private javax.swing.JTable jTableIoMonitor;
    private javax.swing.JTable jTableJobQueue;
    private javax.swing.JTable jTableRr;
    private javax.swing.JTable jTableUsb;
    private javax.swing.JTable jTableMonitor;
    private javax.swing.JTable jTableTerminate;

    public View() {
        //TODO setDisButton
        initComponents();
        jButtonAddProcess.setEnabled(false);
        jButtonEndTask.setEnabled(false);
        jButtonAddIoMonitor.setEnabled(false);
        jButtonEndIoMonitor.setEnabled(false);
        jButtonAddIoUsb.setEnabled(false);
        jButtonEndIoUsb.setEnabled(false);
        jButtonReset.setEnabled(false);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // End of variables declaration
    private void initComponents() {

        jPanelAllTime = new JPanel();
        jLabelClock = new JLabel();
        jLabelClockTime = new JLabel();
        jLabelClockMs = new JLabel();
        jLabelAvgWaitingTime = new JLabel();
        jLabelTimeTurnaround = new JLabel();
        jLabelTurnaroundMs = new JLabel();
        jLabelTurnaround = new JLabel();
        jLabelAvgTime = new JLabel();
        jLabelAvgMs = new JLabel();
        jPanelJobQueue = new JPanel();
        jScrollPaneJobQueue = new JScrollPane();
        jTableJobQueue = new JTable();
        jLabelJobQueue = new JLabel();
        jPanelRrFcfs = new JPanel();
        jLabelRr = new JLabel();
        jScrollPaneRr = new JScrollPane();
        jTableRr = new JTable();
        jScrollPaneFcfs = new JScrollPane();
        jTableFcfs = new JTable();
        jLabelFcfs = new JLabel();
        jPanelAllButton = new JPanel();
        jButtonAddProcess = new JButton();
        jButtonReset = new JButton();
        jButtonEndTask = new JButton();
        jButtonStart = new JButton();
        jLabelTimeQuantum = new JLabel();
        jLabelTqTime = new JLabel();
        jPanelIoQueue = new JPanel();
        jLabelIoQueue = new JLabel();
        jPanelIoQUsb = new JPanel();
        jScrollPaneIoQUsb = new JScrollPane();
        jTableIoQUsb = new JTable();
        jLabelIoQUsb = new JLabel();
        jScrollPanePCpu = new JScrollPane();
        jTableCpu = new JTable();
        jLabelCpu = new JLabel();
        jPanelIoMonitor = new JPanel();
        jScrollPaneIoMonitor = new JScrollPane();
        jTableIoMonitor = new JTable();
        jLabelIoMonitor = new JLabel();
        jPanelAddEndIo = new JPanel();
        jScrollPaneMonitor = new JScrollPane();
        jTableMonitor = new JTable();
        jButtonAddIoMonitor = new JButton();
        jButtonEndIoMonitor = new JButton();
        jButtonAddIoUsb = new JButton();
        jButtonEndIoUsb = new JButton();
        jScrollPane_CPU = new JScrollPane();
        jTableUsb = new JTable();
        jLabelMultilevelQueue = new JLabel();
        jPanelTerminate = new JPanel();
        jScrollPaneTerminate = new JScrollPane();
        jTableTerminate = new JTable();
        jLabelTerminate = new JLabel();
        jPanelShowSys = new JPanel();
        jLabelProcessTotal = new JLabel();
        jLabelTotalProcess = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabelClock.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jLabelClock.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelClock.setText("Clock");

        jLabelClockTime.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jLabelClockTime.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelClockTime.setText("--");

        jLabelClockMs.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jLabelClockMs.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelClockMs.setText("ms");

        jLabelAvgWaitingTime.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jLabelAvgWaitingTime.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelAvgWaitingTime.setText("AVG Waiting Time");

        jLabelTimeTurnaround.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jLabelTimeTurnaround.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTimeTurnaround.setText("--");

        jLabelTurnaroundMs.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jLabelTurnaroundMs.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTurnaroundMs.setText("ms");

        jLabelTurnaround.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jLabelTurnaround.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTurnaround.setText("AVG Turnaround Time");

        jLabelAvgTime.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jLabelAvgTime.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelAvgTime.setText("--");

        jLabelAvgMs.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jLabelAvgMs.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelAvgMs.setText("ms");

        GroupLayout jPanel_AllTimeLayout = new GroupLayout(jPanelAllTime);
        jPanelAllTime.setLayout(jPanel_AllTimeLayout);
        jPanel_AllTimeLayout.setHorizontalGroup(
                jPanel_AllTimeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_AllTimeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelClock, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelClockTime, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelClockMs, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabelAvgWaitingTime, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAvgTime, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAvgMs, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTurnaround)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTimeTurnaround, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelTurnaroundMs, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel_AllTimeLayout.setVerticalGroup(
                jPanel_AllTimeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_AllTimeLayout.createSequentialGroup()
                                .addContainerGap(8, Short.MAX_VALUE)
                                .addGroup(jPanel_AllTimeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelClock)
                                        .addComponent(jLabelClockTime)
                                        .addComponent(jLabelClockMs)
                                        .addComponent(jLabelAvgWaitingTime)
                                        .addComponent(jLabelTimeTurnaround)
                                        .addComponent(jLabelTurnaroundMs)
                                        .addComponent(jLabelTurnaround)
                                        .addComponent(jLabelAvgTime)
                                        .addComponent(jLabelAvgMs))
                                .addContainerGap())
        );

        jPanelJobQueue.setBackground(new Color(255, 0, 94));
        jPanelJobQueue.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        jTableJobQueue.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTableJobQueue.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jTableJobQueue.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "PID", "Status", "Arrival Time", "Burst Time", "Waiting Time", "I/O Time", "Queue"
                }
        ));
        jTableJobQueue.setRowHeight(25);
        jTableJobQueue.setRowMargin(1);
        jScrollPaneJobQueue.setViewportView(jTableJobQueue);

        jLabelJobQueue.setFont(new Font("ROG Fonts", 0, 20)); // NOI18N
        jLabelJobQueue.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelJobQueue.setText("JOBQUEUE");

        GroupLayout jPanel_JobQueueLayout = new GroupLayout(jPanelJobQueue);
        jPanelJobQueue.setLayout(jPanel_JobQueueLayout);
        jPanel_JobQueueLayout.setHorizontalGroup(
                jPanel_JobQueueLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_JobQueueLayout.createSequentialGroup()
                                .addGroup(jPanel_JobQueueLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel_JobQueueLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPaneJobQueue, GroupLayout.PREFERRED_SIZE, 843, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel_JobQueueLayout.createSequentialGroup()
                                                .addGap(317, 317, 317)
                                                .addComponent(jLabelJobQueue, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel_JobQueueLayout.setVerticalGroup(
                jPanel_JobQueueLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_JobQueueLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelJobQueue)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneJobQueue, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRrFcfs.setBackground(new Color(0, 148, 255));
        jPanelRrFcfs.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        jLabelRr.setFont(new Font("ROG Fonts", 0, 20)); // NOI18N
        jLabelRr.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelRr.setText("RoundRobin ( Queue 1 )");

        jTableRr.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTableRr.setFont(new Font("Leelawadee UI", 1, 16));// NOI18N
        jTableRr.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "PID", "Status", "Arrival Time", "Burst Time", "Waiting Time"
                }
        ));
        jTableRr.setRowHeight(25);
        jTableRr.setRowMargin(1);
        jScrollPaneRr.setViewportView(jTableRr);

        jTableFcfs.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTableFcfs.setFont(new Font("Leelawadee UI", 1, 16));// NOI18N
        jTableFcfs.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "PID", "Status", "Arrival Time", "Burst Time", "Waiting Time"
                }
        ));
        jTableFcfs.setRowHeight(25);
        jTableFcfs.setRowMargin(1);
        jScrollPaneFcfs.setViewportView(jTableFcfs);

        jLabelFcfs.setFont(new Font("ROG Fonts", 0, 20)); // NOI18N
        jLabelFcfs.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelFcfs.setText("FCFS ( QUEUE 2 )");

        GroupLayout jPanel_RR_FCFSLayout = new GroupLayout(jPanelRrFcfs);
        jPanelRrFcfs.setLayout(jPanel_RR_FCFSLayout);
        jPanel_RR_FCFSLayout.setHorizontalGroup(
                jPanel_RR_FCFSLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_RR_FCFSLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel_RR_FCFSLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_RR_FCFSLayout.createSequentialGroup()
                                                .addComponent(jLabelRr, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_RR_FCFSLayout.createSequentialGroup()
                                                .addComponent(jScrollPaneRr, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_RR_FCFSLayout.createSequentialGroup()
                                                .addComponent(jLabelFcfs, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                                                .addGap(88, 88, 88))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_RR_FCFSLayout.createSequentialGroup()
                                                .addComponent(jScrollPaneFcfs, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        jPanel_RR_FCFSLayout.setVerticalGroup(
                jPanel_RR_FCFSLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_RR_FCFSLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelRr)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPaneRr, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelFcfs)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneFcfs, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelAllButton.setBackground(new Color(153, 153, 153));
        jPanelAllButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        jButtonAddProcess.setBackground(new Color(255, 200, 11));
        jButtonAddProcess.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jButtonAddProcess.setText("Add Process");
        jButtonAddProcess.setBorder(null);
        jButtonAddProcess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonAddProcessActionPerformed(evt);
            }
        });

        jButtonReset.setBackground(new Color(255, 14, 131));
        jButtonReset.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jButtonReset.setText("RESET");
        jButtonReset.setBorder(null);
        jButtonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jButtonEndTask.setBackground(new Color(255, 3, 81));
        jButtonEndTask.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jButtonEndTask.setText("End Task");
        jButtonEndTask.setBorder(null);
        jButtonEndTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonEndTaskActionPerformed(evt);
            }
        });

        jButtonStart.setBackground(new Color(51, 255, 0));
        jButtonStart.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jButtonStart.setText("Start");
        jButtonStart.setToolTipText("");
        jButtonStart.setBorder(null);
        jButtonStart.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jButtonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jLabelTimeQuantum.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jLabelTimeQuantum.setText("TimeQuantum");

        jLabelTqTime.setFont(new Font("Leelawadee UI", 1, 20)); // NOI18N
        jLabelTqTime.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTqTime.setText("--");

        GroupLayout jPanel_AllButtonLayout = new GroupLayout(jPanelAllButton);
        jPanelAllButton.setLayout(jPanel_AllButtonLayout);
        jPanel_AllButtonLayout.setHorizontalGroup(
                jPanel_AllButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_AllButtonLayout.createSequentialGroup()
                                .addGroup(jPanel_AllButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel_AllButtonLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jButtonAddProcess, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonReset, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel_AllButtonLayout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabelTimeQuantum)
                                                .addGap(38, 38, 38)
                                                .addComponent(jLabelTqTime, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_AllButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButtonEndTask, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                        .addComponent(jButtonStart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel_AllButtonLayout.setVerticalGroup(
                jPanel_AllButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_AllButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel_AllButtonLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonAddProcess, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonReset, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonEndTask, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_AllButtonLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonStart, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelTimeQuantum)
                                        .addComponent(jLabelTqTime))
                                .addContainerGap())
        );

        jPanelIoQueue.setBackground(new Color(153, 153, 153));
        jPanelIoQueue.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        jLabelIoQueue.setFont(new Font("Leelawadee UI", 1, 20)); // NOI18N
        jLabelIoQueue.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelIoQueue.setText("I/O QUEUE");

        jPanelIoQUsb.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

        jTableIoQUsb.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTableIoQUsb.setFont(new Font("Leelawadee UI", 1, 16));// NOI18N
        jTableIoQUsb.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "PID", "Status", "Waiting Time"
                }
        ));
        jTableIoQUsb.setRowHeight(25);
        jTableIoQUsb.setRowMargin(1);
        jScrollPaneIoQUsb.setViewportView(jTableIoQUsb);

        jLabelIoQUsb.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jLabelIoQUsb.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelIoQUsb.setText("USB");

        GroupLayout jPanel_IOQ_usbLayout = new GroupLayout(jPanelIoQUsb);
        jPanelIoQUsb.setLayout(jPanel_IOQ_usbLayout);
        jPanel_IOQ_usbLayout.setHorizontalGroup(
                jPanel_IOQ_usbLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_IOQ_usbLayout.createSequentialGroup()
                                .addGroup(jPanel_IOQ_usbLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel_IOQ_usbLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPaneIoQUsb, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel_IOQ_usbLayout.createSequentialGroup()
                                                .addGap(163, 163, 163)
                                                .addComponent(jLabelIoQUsb, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_IOQ_usbLayout.setVerticalGroup(
                jPanel_IOQ_usbLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_IOQ_usbLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelIoQUsb)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneIoQUsb, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableCpu.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTableCpu.setFont(new Font("Leelawadee UI", 1, 20));// NOI18N
        jTableCpu.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "PID", "Status", "Queue"
                }
        ));
        jTableCpu.setRowHeight(42);
        jScrollPanePCpu.setViewportView(jTableCpu);

        jLabelCpu.setFont(new Font("Leelawadee UI", 1, 20)); // NOI18N
        jLabelCpu.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelCpu.setText("CPU");

        jPanelIoMonitor.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        jTableIoMonitor.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTableIoMonitor.setFont(new Font("Leelawadee UI", 1, 16));// NOI18N
        jTableIoMonitor.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "PID", "Status", "Waiting Time"
                }
        ));
        jTableIoMonitor.setRowHeight(25);
        jTableIoMonitor.setRowMargin(1);
        jScrollPaneIoMonitor.setViewportView(jTableIoMonitor);

        jLabelIoMonitor.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jLabelIoMonitor.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelIoMonitor.setText("MONITOR");

        GroupLayout jPanel_IO_MonitorLayout = new GroupLayout(jPanelIoMonitor);
        jPanelIoMonitor.setLayout(jPanel_IO_MonitorLayout);
        jPanel_IO_MonitorLayout.setHorizontalGroup(
                jPanel_IO_MonitorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_IO_MonitorLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPaneIoMonitor, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(jPanel_IO_MonitorLayout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jLabelIoMonitor, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_IO_MonitorLayout.setVerticalGroup(
                jPanel_IO_MonitorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_IO_MonitorLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelIoMonitor)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneIoMonitor, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout jPanel_IO_QUEUELayout = new GroupLayout(jPanelIoQueue);
        jPanelIoQueue.setLayout(jPanel_IO_QUEUELayout);
        jPanel_IO_QUEUELayout.setHorizontalGroup(
                jPanel_IO_QUEUELayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_IO_QUEUELayout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(jLabelIoQueue, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel_IO_QUEUELayout.createSequentialGroup()
                                .addGroup(jPanel_IO_QUEUELayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel_IO_QUEUELayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel_IO_QUEUELayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPanePCpu, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addComponent(jPanelIoQUsb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel_IO_QUEUELayout.createSequentialGroup()
                                                .addGap(170, 170, 170)
                                                .addComponent(jLabelCpu, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_IO_QUEUELayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanelIoMonitor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel_IO_QUEUELayout.setVerticalGroup(
                jPanel_IO_QUEUELayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_IO_QUEUELayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelCpu)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPanePCpu, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelIoQueue, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanelIoMonitor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelIoQUsb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jPanelAddEndIo.setBackground(new Color(153, 153, 153));
        jPanelAddEndIo.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        jTableMonitor.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTableMonitor.setFont(new Font("Leelawadee UI", 1, 16));// NOI18N
        jTableMonitor.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "PID", "Status", "I/O Time"
                }
        ));
        jTableMonitor.setRowHeight(25);
        jTableMonitor.setRowMargin(1);
        jScrollPaneMonitor.setViewportView(jTableMonitor);

        jButtonAddIoMonitor.setBackground(new Color(0, 255, 6));
        jButtonAddIoMonitor.setFont(new Font("Leelawadee UI", 1, 13)); // NOI18N
        jButtonAddIoMonitor.setText("ADD MONITOR");
        jButtonAddIoMonitor.setToolTipText("");
        jButtonAddIoMonitor.setBorder(null);
        jButtonAddIoMonitor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonAddIoMonitorActionPerformed(evt);
            }
        });

        jButtonEndIoMonitor.setBackground(new Color(255, 3, 59));
        jButtonEndIoMonitor.setFont(new Font("Leelawadee UI", 1, 13)); // NOI18N
        jButtonEndIoMonitor.setText("End I/O");
        jButtonEndIoMonitor.setBorder(null);
        jButtonEndIoMonitor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonEndIoMonitorActionPerformed(evt);
            }
        });

        jButtonAddIoUsb.setBackground(new Color(0, 255, 0));
        jButtonAddIoUsb.setFont(new Font("Leelawadee UI", 1, 13)); // NOI18N
        jButtonAddIoUsb.setText("ADD USB");
        jButtonAddIoUsb.setToolTipText("");
        jButtonAddIoUsb.setBorder(null);
        jButtonAddIoUsb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonAddIoUsbActionPerformed(evt);
            }
        });

        jButtonEndIoUsb.setBackground(new Color(255, 3, 59));
        jButtonEndIoUsb.setFont(new Font("Leelawadee UI", 1, 13)); // NOI18N
        jButtonEndIoUsb.setText("End I/O");
        jButtonEndIoUsb.setBorder(null);
        jButtonEndIoUsb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonEndIoUsbActionPerformed(evt);
            }
        });

        jTableUsb.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTableUsb.setFont(new Font("Leelawadee UI", 1, 16));// NOI18N
        jTableUsb.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "PID", "Status", "I/O Time"
                }
        ));
        jTableUsb.setRowHeight(25);
        jTableUsb.setRowMargin(1);
        jScrollPane_CPU.setViewportView(jTableUsb);

        GroupLayout jPanel_Add_End_IOLayout = new GroupLayout(jPanelAddEndIo);
        jPanelAddEndIo.setLayout(jPanel_Add_End_IOLayout);
        jPanel_Add_End_IOLayout.setHorizontalGroup(
                jPanel_Add_End_IOLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_Add_End_IOLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel_Add_End_IOLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel_Add_End_IOLayout.createSequentialGroup()
                                                .addComponent(jButtonAddIoUsb, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButtonEndIoUsb, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane_CPU, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                                        .addComponent(jScrollPaneMonitor, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel_Add_End_IOLayout.createSequentialGroup()
                                                .addComponent(jButtonAddIoMonitor, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButtonEndIoMonitor, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel_Add_End_IOLayout.setVerticalGroup(
                jPanel_Add_End_IOLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_Add_End_IOLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPaneMonitor, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_Add_End_IOLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButtonAddIoMonitor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonEndIoMonitor, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane_CPU, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_Add_End_IOLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonAddIoUsb, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                        .addComponent(jButtonEndIoUsb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        jLabelMultilevelQueue.setBackground(new Color(0, 0, 0));
        jLabelMultilevelQueue.setFont(new Font("ROG Fonts", 1, 25)); // NOI18N
        jLabelMultilevelQueue.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelMultilevelQueue.setText("multilevel  Queue");

        jPanelTerminate.setBackground(new Color(153, 153, 153));
        jPanelTerminate.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        jTableTerminate.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jTableTerminate.setFont(new Font("Leelawadee UI", 1, 16));// NOI18N
        jTableTerminate.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "PID", "Status", "Waiting Time", "Turnaround Time"
                }
        ));
        jTableTerminate.setRowHeight(25);
        jTableTerminate.setRowMargin(1);
        jScrollPaneTerminate.setViewportView(jTableTerminate);

        jLabelTerminate.setFont(new Font("Leelawadee UI", 1, 16)); // NOI18N
        jLabelTerminate.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTerminate.setText("TERMINATE");

        GroupLayout jPanel_terminateLayout = new GroupLayout(jPanelTerminate);
        jPanelTerminate.setLayout(jPanel_terminateLayout);
        jPanel_terminateLayout.setHorizontalGroup(
                jPanel_terminateLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_terminateLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPaneTerminate, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_terminateLayout.createSequentialGroup()
                                .addContainerGap(147, Short.MAX_VALUE)
                                .addComponent(jLabelTerminate, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                .addGap(146, 146, 146))
        );
        jPanel_terminateLayout.setVerticalGroup(
                jPanel_terminateLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_terminateLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTerminate)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneTerminate, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPanelShowSys.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

        jLabelProcessTotal.setFont(new Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabelProcessTotal.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelProcessTotal.setText("Process Total");

        jLabelTotalProcess.setBackground(new Color(204, 204, 204));
        jLabelTotalProcess.setFont(new Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabelTotalProcess.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTotalProcess.setText("--");

        GroupLayout jPanel_showSysLayout = new GroupLayout(jPanelShowSys);
        jPanelShowSys.setLayout(jPanel_showSysLayout);
        jPanel_showSysLayout.setHorizontalGroup(
                jPanel_showSysLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_showSysLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelProcessTotal)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTotalProcess, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel_showSysLayout.setVerticalGroup(
                jPanel_showSysLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_showSysLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel_showSysLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelProcessTotal)
                                        .addComponent(jLabelTotalProcess))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(95, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jPanelJobQueue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanelRrFcfs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jPanelAddEndIo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jPanelTerminate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jPanelIoQueue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jPanelAllButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(105, 105, 105))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabelMultilevelQueue)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanelAllTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanelShowSys, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanelShowSys, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanelAllTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(jLabelMultilevelQueue)
                                                .addGap(11, 11, 11)))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanelJobQueue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jPanelRrFcfs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanelAddEndIo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanelTerminate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanelAllButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanelIoQueue, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                .addContainerGap(205, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jButtonAddProcessActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO addProcess
        controller.addProcess(clock, timeQuantum);
    }

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO:resetActionPerformed
        controller.reset();
        clock = 0;
    }

    private void jButtonEndTaskActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO :EndTaskActionPerformed
        controller.removeQueue(clock);
    }

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO StartActionPerformed
        jButtonAddProcess.setEnabled(true);
        jButtonStart.setEnabled(false);
        jButtonReset.setEnabled(true);
        clockTime();
    }

    private void jButtonAddIoMonitorActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO Add_IOMActionPerformed
        controller.addMonitorQueue();
    }

    private void jButtonEndIoMonitorActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO End_IOMActionPerformed
        controller.endMonitorQueue();
    }

    private void jButtonAddIoUsbActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO Add_IOUActionPerformed
        controller.addUsbQueue();
    }

    private void jButtonEndIoUsbActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO End_IOUActionPerformed
        controller.endUsbQueue();
    }

    //TODO All Function
    public void setButtonAddIO() {
        if (jTableCpu.getRowCount() == 0) {
            jButtonAddIoMonitor.setEnabled(false);
            jButtonAddIoUsb.setEnabled(false);
        } else {
            jButtonAddIoMonitor.setEnabled(true);
            jButtonAddIoUsb.setEnabled(true);
        }

    }

    public void setButtonEndTask() {
        if (jTableCpu.getRowCount() == 0) {
            jButtonEndTask.setEnabled(false);
        } else {
            jButtonEndTask.setEnabled(true);
        }
    }

    public void setButtonEndIo() {
        if (jTableMonitor.getRowCount() == 0) {
            jButtonEndIoMonitor.setEnabled(false);
        } else {
            jButtonEndIoMonitor.setEnabled(true);
        }
        if (jTableUsb.getRowCount() == 0) {
            jButtonEndIoUsb.setEnabled(false);
        } else {
            jButtonEndIoUsb.setEnabled(true);
        }
    }

    public void clockTime() {
        TimerTask task = new TimerTask() {
            public void run() {
                //TODO run
                //ตัวแปร count ในส่วนนี้ คือส่วนที่จะไปแสดง บนหน้า View ที่เราเห็นกันคือ นับเวลา Clock หรือ CPU Time
                clock++;
                jLabelClockTime.setText(Integer.toString(clock));
                jLabelTqTime.setText(Integer.toString(timeQuantum));
                jLabelTotalProcess.setText(Integer.toString(controller.getCountProcess()));
                jLabelAvgTime.setText(controller.getAvgWaitingTime());
                jLabelTimeTurnaround.setText(controller.getAvgTurnaroundTime());
                setButtonAddIO();
                setButtonEndTask();
                setButtonEndIo();

                showJob(controller.showJobQueue());
                showJobFcfs(controller.showFirstComeFirstServedQueue());
                showJobRr(controller.showRoundRobinQueue());
                showJobTerminateQueue(controller.showTerminateQueue());
                showJobCPU(controller.showCPU());
                showJobMonitor(controller.showMonitor());
                showJobMonitorQueue(controller.showMonitorQueue());
                showJobUSB(controller.showUsb());
                showJobUsbQueue(controller.showUsbQueue());

//                controller.resetTimeQuantum(timeQuantum);
                controller.randomRunning();
                controller.waitingTime();
                controller.waitingTimeMonitorQueue();
                controller.waitingTimeUsbQueue();
                controller.monitorQueue();
                controller.usbQueue();
            }
        };
        mytime.scheduleAtFixedRate(task, 1000, 1000);
    }

    public void showJob(String text) {
        try {
            DefaultTableModel model1 = (DefaultTableModel) jTableJobQueue.getModel();

            int rowCount = model1.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            String[] textTable2 = text.split(",");
            for (int index = 0; index < textTable2.length; index++) {
                String[] textTable1 = textTable2[index].split(" ");
                model1.addRow(new Object[]{textTable1[0], textTable1[1], textTable1[2], textTable1[3], textTable1[4], textTable1[5], textTable1[6]});
                System.out.println(textTable1[1]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

    }

    public void showJobFcfs(String text) {
        try {
            DefaultTableModel model1 = (DefaultTableModel) jTableFcfs.getModel();
            int index1 = controller.setIndexFcfs();
            int rowCount = model1.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            String[] textTable2 = text.split(",");
            for (int index = index1; index < textTable2.length; index++) {
                String[] textTable1 = textTable2[index].split(" ");
                model1.addRow(new Object[]{textTable1[0], textTable1[1], textTable1[2], textTable1[3], textTable1[4]});
                System.out.println(textTable1[1]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    public void showJobRr(String text) {
        try {
            DefaultTableModel model1 = (DefaultTableModel) jTableRr.getModel();
            int index1 = controller.setIndexRr();
            int rowCount = model1.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            String[] textTable2 = text.split(",");
            for (int index = index1; index < textTable2.length; index++) {
                String[] textTable1 = textTable2[index].split(" ");
                model1.addRow(new Object[]{textTable1[0], textTable1[1], textTable1[2], textTable1[3], textTable1[4]});
                System.out.println(textTable1[1]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

    }

    public void showJobTerminateQueue(String text) {
        try {
            DefaultTableModel model1 = (DefaultTableModel) jTableTerminate.getModel();

            int rowCount = model1.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            String[] textTable2 = text.split(",");
            for (int index = 0; index < textTable2.length; index++) {
                String[] textTable1 = textTable2[index].split(" ");
                model1.addRow(new Object[]{textTable1[0], textTable1[1], textTable1[2], textTable1[3]});
                System.out.println(textTable1[1]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

    }

    public void showJobCPU(String text) {
        try {
            DefaultTableModel model1 = (DefaultTableModel) jTableCpu.getModel();

            int rowCount = model1.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            String[] textTable2 = text.split(",");
            for (int index = 0; index < textTable2.length; index++) {
                String[] textTable1 = textTable2[index].split(" ");
                model1.addRow(new Object[]{textTable1[0], textTable1[1], textTable1[2]});
                System.out.println(textTable1[1]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

    }

    public void showJobMonitor(String text) {
        try {
            DefaultTableModel model1 = (DefaultTableModel) jTableMonitor.getModel();

            int rowCount = model1.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            String[] textTable2 = text.split(",");
            for (int index = 0; index < 1; index++) {
                String[] textTable1 = textTable2[index].split(" ");
                model1.addRow(new Object[]{textTable1[0], textTable1[1], textTable1[2]});
                System.out.println(textTable1[1]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

    }

    public void showJobMonitorQueue(String text) {
        try {
            DefaultTableModel model1 = (DefaultTableModel) jTableIoMonitor.getModel();

            int rowCount = model1.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            String[] textTable2 = text.split(",");
            for (int index = 1; index < textTable2.length; index++) {
                String[] textTable1 = textTable2[index].split(" ");
                model1.addRow(new Object[]{textTable1[0], textTable1[1], textTable1[2]});
                System.out.println(textTable1[1]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

    }

    public void showJobUSB(String text) {
        try {
            DefaultTableModel model1 = (DefaultTableModel) jTableUsb.getModel();
            int rowCount = model1.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            String[] textTable2 = text.split(",");
            for (int index = 0; index < 1; index++) {
                String[] textTable1 = textTable2[index].split(" ");
                model1.addRow(new Object[]{textTable1[0], textTable1[1], textTable1[2]});
                System.out.println(textTable1[1]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

    }

    public void showJobUsbQueue(String text) {
        try {
            DefaultTableModel model1 = (DefaultTableModel) jTableIoQUsb.getModel();

            int rowCount = model1.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            String[] textTable2 = text.split(",");
            for (int index = 1; index < textTable2.length; index++) {
                String[] textTable1 = textTable2[index].split(" ");
                model1.addRow(new Object[]{textTable1[0], textTable1[1], textTable1[2]});
                System.out.println(textTable1[1]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

    }
}