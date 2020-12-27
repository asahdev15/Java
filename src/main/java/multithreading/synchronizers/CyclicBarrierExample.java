package multithreading.synchronizers;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    private static final int THREAD_COUNT = 4;
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT);
        JFrame frame = createFrame();
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        for (int i = 1; i <= THREAD_COUNT; i++) {
            ProgressThreadCyclkicBarrier progressThread = new ProgressThreadCyclkicBarrier(barrier, i * 10);
            frame.add(progressThread.getProgressComponent());
            progressThread.start();
        }
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JFrame createFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("Java CyclicBarrier Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(ProgressThreadCyclkicBarrier.PROGRESS_WIDTH, 170));
        return frame;
    }

}