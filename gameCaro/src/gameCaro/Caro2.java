package gameCaro;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Caro2 extends JFrame implements ActionListener {
    boolean win = false;
    Color background_cl = Color.white;
    Color x_cl = Color.red;
    Color y_cl = Color.blue;
    int column = 3, row = 3, count = 0;
    int xUndo[] = new int[column * row];
    int yUndo[] = new int[column * row];
    boolean tick[][] = new boolean[column + 2][row + 2];
    int Size = 0;
    Container cn;
    JPanel pn, pn2;
    JLabel lb;
    JButton newGame_bt, undo_bt, exit_bt;
    private JButton b[][] = new JButton[column + 2][row + 2];

    public Caro2(String s) {
        super(s);
        cn = this.getContentPane();
        pn = new JPanel();
        pn.setLayout(new GridLayout(column, row));
        for (int i = 0; i <= column + 1; i++)
            for (int j = 0; j <= row + 1; j++) {
                b[i][j] = new JButton(" ");
                b[i][j].setActionCommand(i + " " + j);
                b[i][j].setBackground(background_cl);
                b[i][j].setFont(new Font("Antique", 1, 120));
                b[i][j].addActionListener(this);
                tick[i][j] = true;
            }
        for (int i = 1; i <= column; i++)
            for (int j = 1; j <= row; j++)
                pn.add(b[i][j]);
        lb = new JLabel("X Đánh Trước");
        newGame_bt = new JButton("New Game");
        undo_bt = new JButton("Undo");
        exit_bt = new JButton("Exit");
        newGame_bt.addActionListener(this);
        undo_bt.addActionListener(this);
        exit_bt.addActionListener(this);
        exit_bt.setForeground(x_cl);
        cn.add(pn);
        pn2 = new JPanel();
        pn2.setLayout(new FlowLayout());
        pn2.add(lb);
        pn2.add(newGame_bt);
        pn2.add(undo_bt);
        pn2.add(exit_bt);
        cn.add(pn2, "North");
        this.setVisible(true);
        this.setSize(500, 570);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        undo_bt.setEnabled(false);
    }

    public void ledCheo(int k) {
        File file = new File("src/gameCaro/audio/winner.wav");
        URL url = null;
        if (file.canRead()) {
            try {
                url = file.toURI().toURL();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(url);
        AudioClip clip = Applet.newAudioClip(url);
        clip.play();
        System.out.println("audio start!");
        Timer t = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int l = 1; l <= row; l++) {
                    for (int m = 1; m <= column; m++) {
                        if ((l == m) && (k == 1)) {
                            if (b[l][m].getBackground() == Color.green) {
                                b[l][m].setBackground(Color.white);
                            } else {
                                b[l][m].setBackground(Color.green);
                            }
                        } else if (((l == 2 && m == 2) || ((l - m) == 2 || (m - l) == 2)) && (k == 2)) {
                            if (b[l][m].getBackground() == Color.green) {
                                b[l][m].setBackground(Color.white);
                            } else {
                                b[l][m].setBackground(Color.green);
                            }
                        }
                    }
                }
            }
        });
        Timer ts = new Timer(3200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.stop();
            }
        });
        t.start();
        ts.start();

    }

    public void ledHangCot(int i1, int i2, int j1, int j2) {
        File file = new File("src/gameCaro/audio/winner.wav");
        URL url = null;
        if (file.canRead()) {
            try {
                url = file.toURI().toURL();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(url);
        AudioClip clip = Applet.newAudioClip(url);
        clip.play();
        System.out.println("audio start!");
        Timer t = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int ii = i1; ii <= i2; ii++) {
                    for (int jj = j1; jj <= j2; jj++) {
                        if (b[ii][jj].getBackground() == Color.green) {
                            b[ii][jj].setBackground(Color.white);
                        } else {
                            b[ii][jj].setBackground(Color.green);
                        }
                    }
                }
            }
        });
        Timer ts = new Timer(3200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.stop();
            }
        });
        t.start();
        ts.start();

    }

    public boolean checkWin(int i, int j) {
        int d = 0, k = i, h;
        // kiểm tra hàng
        while (b[k][j].getText() == b[i][j].getText()) {
            // Hàng dưới
            d++;
            k++;
        }
        int k2 = k;
        k = i - 1;
        while (b[k][j].getText() == b[i][j].getText()) {
            // Hàng trên
            d++;
            k--;
        }
        int k1 = k;
        if (d > 2) { // đủ 3x hoặc 3o
            if (k2 > i && k1 < (i - 1)) {
                ledHangCot(k1, k2, j, j);
            } else if (k2 > (i + 1)) {
                ledHangCot(i, k2, j, j);
            } else if (k1 < (i - 1)) {
                ledHangCot(k1, i, j, j);
            }
            return true;
        }
        d = 0;
        h = j;
        // kiểm tra cột
        while (b[i][h].getText() == b[i][j].getText()) {
            // Cột phải
            d++;
            h++;
        }
        k2 = h;
        h = j - 1;
        while (b[i][h].getText() == b[i][j].getText()) {
            // Cột trái
            d++;
            h--;
        }
        k1 = h;
        if (d > 2) { // đủ 3x hoặc 3o
            if (k2 > j && k1 < (j - 1)) {
                ledHangCot(i, i, k1, k2);
            } else if (k2 > (j + 1)) {
                ledHangCot(i, i, j, k2);
            } else if (k1 < (j - 1)) {
                ledHangCot(i, i, k1, j);
            }
            return true;
        }
        // kiểm tra đường chéo 1
        h = i;
        k = j;
        d = 0;
        while (b[i][j].getText() == b[h][k].getText()) {
            // Đường chéo dưới phải
            d++;
            h++;
            k++;
        }
        h = i - 1;
        k = j - 1;
        while (b[i][j].getText() == b[h][k].getText()) {
            // Dường chéo trên trái
            d++;
            h--;
            k--;
        }
        if (d > 2) { // đủ 3x hoặc 3o
            ledCheo(1);
            return true;
        }
        // kiểm tra đường chéo 2
        h = i;
        k = j;
        d = 0;
        while (b[i][j].getText() == b[h][k].getText()) {
            // Đường chéo dưới trái
            d++;
            h++;
            k--;
        }
        h = i - 1;
        k = j + 1;
        while (b[i][j].getText() == b[h][k].getText()) {
            // Đường chéo trên phải
            d++;
            h--;
            k++;
        }
        if (d > 2) { // đủ 3x hoặc 3o
            ledCheo(2);
            return true;
        }
        // nếu không đương chéo nào thỏa mãn thì trả về false.
        return false;
    }

    public void undo() {
        if (Size > 0) {
            b[xUndo[Size - 1]][yUndo[Size - 1]].setText(" ");
            b[xUndo[Size - 1]][yUndo[Size - 1]].setActionCommand(xUndo[Size - 1] + " " + yUndo[Size - 1]);
            b[xUndo[Size - 1]][yUndo[Size - 1]].setBackground(background_cl);
            tick[xUndo[Size - 1]][yUndo[Size - 1]] = true;
            count--;
            if (count % 2 == 0) lb.setText("Lượt Của X");
            else lb.setText("Lượt Của O");
            Size--;
            if (Size == 0)
                undo_bt.setEnabled(false);
        }
    }

    public void addPoint(int i, int j) {
        if (Size > 0)
            b[xUndo[Size - 1]][yUndo[Size - 1]].setBackground(background_cl);
        xUndo[Size] = i;
        yUndo[Size] = j;
        Size++;
        if (count % 2 == 0) {
            b[i][j].setText("X");
            b[i][j].setForeground(x_cl);
            lb.setText("Lượt Của O");
        } else {
            b[i][j].setText("O");
            b[i][j].setForeground(y_cl);
            lb.setText("Lượt Của X");
        }
        tick[i][j] = false;
        count = 1 - count;
        // b[i][j].setBackground(Color.GRAY);
        undo_bt.setEnabled(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "New Game") {
            new Caro2("GAME CARO 3x3");
            this.dispose();
        } else if (e.getActionCommand() == "Undo") {
            undo();
        } else if (e.getActionCommand() == "Exit") {
            //System.exit(0);
            new frMenu("GAME CARO 3x3").setVisible(true);
            this.dispose();
        } else {
            String s = e.getActionCommand();
            int i = Integer.parseInt(s.substring(0, 1));
            int j = Integer.parseInt(s.substring(2, s.length()));
            if (!win) {
                // Nếu btn đã click thì ngăn click (tich[i][j]=false)
                if (tick[i][j]) {
                    addPoint(i, j);
                    if (!checkWin(i, j)) {
                        int demHoa = 0;
                        for (int k = 1; k <= row; k++) {
                            for (int l = 1; l <= column; l++) {
                                if (!tick[k][l]) {
                                    demHoa++;
                                }
                            }
                        }
                        if (demHoa == 9) {
                            JOptionPane.showMessageDialog(rootPane, "Hòa");
                            lb.setText("Tỷ số hòa");
                        }

                    }
                }
                if (checkWin(i, j)) {
                    win = true;
                    lb.setBackground(Color.MAGENTA);
                    lb.setText(b[i][j].getText() + " WIN");
                    JOptionPane.showMessageDialog(rootPane, lb.getText());
                    undo_bt.setEnabled(false);
                    newGame_bt.setBackground(Color.YELLOW);
                }
            }
        }
    }
}