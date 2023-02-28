import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame{

    JPanel main;
    int screenHeight;
    int screenWidth;

    JPanel topPnl;
    JLabel title;
    ImageIcon image;

    JPanel displayPnl;
    JTextArea txtArea;
    JScrollPane scroller;

    JPanel controlPnl;
    JButton readBtn;
    JButton quitBtn;

    int i = -1;
    int randIndex;
    Random rnd;


    public FortuneTellerFrame(){
        main = new JPanel();
        main.setLayout(new BorderLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(main);
        main.setBackground(new Color(255, 255, 255));

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        screenHeight = screenSize.height;
        screenWidth = screenSize.width;
        setSize(3 * (screenWidth / 4), 3 * (screenHeight / 4));

        FortuneTellerLabel();
        main.add(topPnl, BorderLayout.NORTH);

        FortuneDisplay();
        main.add(displayPnl, BorderLayout.CENTER);

        ControlPanel();
        main.add(controlPnl, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void FortuneTellerLabel() {
        topPnl = new JPanel();
        topPnl.setBackground(new Color(255, 255, 255));

        ImageIcon icon = new ImageIcon("src/fortune-teller.png");
        Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);

        title = new JLabel("FORTUNE TELLER", scaledIcon, JLabel.CENTER);
        title.setFont(new Font("Dialog", Font.BOLD, 48));
        title.setForeground(new Color(50, 107, 250));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.BOTTOM);

        topPnl.add(title);
    }


    private void FortuneDisplay(){
        displayPnl = new JPanel();
        displayPnl.setBackground(new Color(255, 255, 255));
        txtArea = new JTextArea(20, 60);
        txtArea.setFont(new Font("SansSerif", Font.ITALIC, 12));
        scroller = new JScrollPane(txtArea);
        displayPnl.add(scroller);
    }

    private void ControlPanel(){
        controlPnl = new JPanel();
        controlPnl.setBackground(new Color(255, 255, 255));
        controlPnl.setLayout(new GridLayout(1, 2));

        ArrayList<String> fortuneList = new ArrayList<>();
        fortuneList.add("Your next meal will be delicious, but you'll still find room for dessert.");
        fortuneList.add("You will discover a hidden talent for making terrible puns.");
        fortuneList.add("A cat will cross your path, but it will only bring you good luck.");
        fortuneList.add("You will find the perfect pair of socks to wear with sandals.");
        fortuneList.add("Your karaoke skills will astound even the toughest critics.)");
        fortuneList.add("You will soon have an encounter with a magical unicorn (or maybe just a really cute horse).");
        fortuneList.add("You will win a staring contest with a goldfish.");
        fortuneList.add("Your dance moves will be the highlight of the party.");
        fortuneList.add("Your phone will never run out of battery at the most inconvenient times.");
        fortuneList.add("You will always have the perfect amount of milk left for your cereal.");
        fortuneList.add("Your internet connection will always be strong enough to stream your favorite show without buffering.");
        fortuneList.add("You will discover a hidden talent for perfectly timing your microwave popcorn.");

        readBtn = new JButton("Read my Fortune!");
        readBtn.addActionListener((ActionEvent ae) ->{
            rnd = new Random();
            do{
                randIndex = rnd.nextInt(11);
            }while(randIndex == i);
            String fortune = fortuneList.get(randIndex);
            i = randIndex;
            txtArea.append("Your fortune: " + fortune + "\n");
        });
        readBtn.setFont(new Font("Monospaced", Font.PLAIN, 14));

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        quitBtn.setFont(new Font("Monospaced", Font.PLAIN, 14));

        controlPnl.add(readBtn);
        controlPnl.add(quitBtn);
    }
}