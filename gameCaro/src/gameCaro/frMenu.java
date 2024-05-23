package gameCaro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frMenu extends JFrame implements ActionListener {
    private JButton btnPlay;
    private JButton btnPlays;

    public frMenu(String title) {
        super(title);
        initUI();
    }

    public static void main(String[] args) {
        new frMenu("GAME CARO 3x3").setVisible(true);
    }

    private void initUI() {
        this.setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setResizable(false);

        btnPlay = new JButton("Player vs Bot");
        btnPlays = new JButton("Player vs Player");
        btnPlay.setActionCommand("1");
        btnPlays.setActionCommand("2");
        btnPlay.addActionListener(this);
        btnPlays.addActionListener(this);
        btnPlay.setForeground(Color.BLUE);
        btnPlays.setForeground(Color.BLUE);
        btnPlay.setPreferredSize(new Dimension(200, 30));
        btnPlays.setPreferredSize(new Dimension(200, 30));
        JPanel pnBtn = new JPanel(new FlowLayout());
        pnBtn.add(btnPlay);
        pnBtn.add(btnPlays);
        ImageIcon icon = new ImageIcon("src/gameCaro/img/xo.png", "gameXO");
        JPanel pnND = new JPanel(new BorderLayout());
        JLabel lbIcon = new JLabel(icon, JLabel.CENTER);
        JPanel pnIcon = new JPanel();
        pnIcon.add(lbIcon);
        pnND.add(pnBtn, BorderLayout.NORTH);
        pnND.add(pnIcon, BorderLayout.CENTER);
        this.add(pnND);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(btnPlay.getActionCommand())) {
            Caro1 k = new Caro1("GAME CARO 3x3", 0, 0);
            if (Math.random() >= 0.5) {
                k.timer.start();
                k.icon = "O";
            } else
                k.icon = "X";
            this.dispose();
        } else {
            new Caro2("GAME CARO 3x3").setVisible(true);
            this.dispose();
        }
    }
}
