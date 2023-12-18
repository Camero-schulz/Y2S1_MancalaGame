package ui;

import java.io.IOException;
import java.io.FileNotFoundException;

import mancala.InvalidMoveException;
import mancala.PitNotFoundException;
import mancala.NoSuchPlayerException;
import mancala.GameNotOverException;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.time.LocalDateTime;

import mancala.MancalaGame;
import mancala.GameRules;
import mancala.KalahRules;
import mancala.AyoRules;
import mancala.Player;
import mancala.Saver;
import mancala.UserProfile;

//import files.FileFormatException;
//import files.FileReader;
//import files.FileWriter;

public class GUI extends JFrame {
    private MancalaGame mancalaGame;
    private Player playerOne;
    private Player playerTwo;
    private JPanel pitsPanel;

    public GUI(String windowTitle, int width, int height) {

        super();
        setTitle(windowTitle);
        setSize(width, height);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        pitsPanel = new JPanel(); // Create a JPanel to hold the pit buttons
        pitsPanel.setLayout(null); // Set the layout to null to position buttons manually
        pitsPanel.setBounds(0, 0, 900, 500); // Set the bounds for the pitsPanel

        playerOne = new Player("one");
        playerTwo = new Player("two");
        mancalaGame = new MancalaGame();
        mancalaGame.setBoard(new KalahRules());

        mainMenu();
        setupMenuBar();

        show();
        startGame();
    }

    private void startGame() {
        mancalaGame.setPlayers(playerOne, playerTwo);
        mancalaGame.setCurrentPlayer(playerOne);
        mancalaGame.getBoard().registerPlayers(playerOne, playerTwo);
        displayBoard();
    //    displayStores();
     //   playGame();
    }

    private void playGame(int startPit) {

        Player currentPlayer = mancalaGame.getCurrentPlayer();

        try {
            int stonesLeft = mancalaGame.move(startPit);
        } catch (InvalidMoveException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERROR: Invalid move", JOptionPane.ERROR_MESSAGE);
        }

        if (mancalaGame.isGameOver()) {
            endGame();
            
        }

        removeAllPits();
        displayBoard();

        
    }

    private void endGame() {
        Player winner = null;
        try {
            winner = mancalaGame.getWinner();
            if (winner != null) {
                JOptionPane.showMessageDialog(this, "Winner! " + winner.getName(), "Game Over", 1);
            } else {
                JOptionPane.showMessageDialog(this, "Tie!", "Game Over", 1);
            }
        } catch (GameNotOverException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Game is not over yet.", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mainMenu() {
        //       JPanel actionPanel = new JPanel();
        //       actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.PAGE_AXIS))

        PositionAwareButton startAGame = new PositionAwareButton("New Game");
        startAGame.setAcross(20);
        startAGame.setDown(30);
        startAGame.setBounds(startAGame.getAcross(), startAGame.getDown(), 150, 30);

       // PositionAwareButton loadAFile = new PositionAwareButton("Load Player");
       // loadAFile.setAcross(20);
       // loadAFile.setDown(60);
       // loadAFile.setBounds(loadAFile.getAcross(), loadAFile.getDown(), 150, 30);

       // PositionAwareButton CreateAFile = new PositionAwareButton("Create New Player");
       // CreateAFile.setAcross(20);
       // CreateAFile.setDown(90);
       // CreateAFile.setBounds(CreateAFile.getAcross(), CreateAFile.getDown(), 150, 30);

        setLayout(null);    // to use position set
        getContentPane().add(startAGame);
       // getContentPane().add(loadAFile);
      //  getContentPane().add(CreateAFile);

      //  loadAFile.addActionListener(event -> loadFile());
        startAGame.addActionListener(event -> setupNewGame());
    }

    private void setupNewGame() {
        mancalaGame.setCurrentPlayer(playerOne);
        mancalaGame.startNewGame();  
        removeAllPits();
        displayBoard();
    //    playGame();
    }

    private void removeAllPits() {
        pitsPanel.removeAll();
        pitsPanel.revalidate();
        pitsPanel.repaint();
    }

    private void displayBoard() {

        try {
            PositionAwareButton pit1 = new PositionAwareButton(String.valueOf(mancalaGame.getNumStones(1)));
            pit1.setAcross(600);
            pit1.setDown(150);
            pit1.setBounds(pit1.getAcross(), pit1.getDown(), 60, 30);
            pit1.addActionListener(event -> playGame(1));
            pitsPanel.add(pit1);

            PositionAwareButton pit2 = new PositionAwareButton(String.valueOf(mancalaGame.getNumStones(2)));
            pit2.setAcross(540);
            pit2.setDown(150);
            pit2.setBounds(pit2.getAcross(), pit2.getDown(), 60, 30);
            pit2.addActionListener(event -> playGame(2));
            pitsPanel.add(pit2);

            PositionAwareButton pit3 = new PositionAwareButton(String.valueOf(mancalaGame.getNumStones(3)));
            pit3.setAcross(480);
            pit3.setDown(150);
            pit3.setBounds(pit3.getAcross(), pit3.getDown(), 60, 30);
            pit3.addActionListener(event -> playGame(3));
            pitsPanel.add(pit3);

            PositionAwareButton pit4 = new PositionAwareButton(String.valueOf(mancalaGame.getNumStones(4)));
            pit4.setAcross(420);
            pit4.setDown(150);
            pit4.setBounds(pit4.getAcross(), pit4.getDown(), 60, 30);
            pit4.addActionListener(event -> playGame(4));
            pitsPanel.add(pit4);

            PositionAwareButton pit5 = new PositionAwareButton(String.valueOf(mancalaGame.getNumStones(5)));
            pit5.setAcross(360);
            pit5.setDown(150);
            pit5.setBounds(pit5.getAcross(), pit5.getDown(), 60, 30);
            pit5.addActionListener(event -> playGame(5));
            pitsPanel.add(pit5);

            PositionAwareButton pit6 = new PositionAwareButton(String.valueOf(mancalaGame.getNumStones(6)));
            pit6.setAcross(300);
            pit6.setDown(150);
            pit6.setBounds(pit6.getAcross(), pit6.getDown(), 60, 30);
            pit6.addActionListener(event -> playGame(6));
            pitsPanel.add(pit6);

            PositionAwareButton pit7 = new PositionAwareButton(String.valueOf(mancalaGame.getNumStones(7)));
            pit7.setAcross(300);
            pit7.setDown(180);
            pit7.setBounds(pit7.getAcross(), pit7.getDown(), 60, 30);
            pit7.addActionListener(event -> playGame(7));
            pitsPanel.add(pit7);

            PositionAwareButton pit8 = new PositionAwareButton(String.valueOf(mancalaGame.getNumStones(8)));
            pit8.setAcross(360);
            pit8.setDown(180);
            pit8.setBounds(pit8.getAcross(), pit8.getDown(), 60, 30);
            pit8.addActionListener(event -> playGame(8));
            pitsPanel.add(pit8);

            PositionAwareButton pit9 = new PositionAwareButton(String.valueOf(mancalaGame.getNumStones(9)));
            pit9.setAcross(420);
            pit9.setDown(180);
            pit9.setBounds(pit9.getAcross(), pit9.getDown(), 60, 30);
            pit9.addActionListener(event -> playGame(9));
            pitsPanel.add(pit9);

            PositionAwareButton pit10 = new PositionAwareButton(String.valueOf(mancalaGame.getNumStones(10)));
            pit10.setAcross(480);
            pit10.setDown(180);
            pit10.setBounds(pit10.getAcross(), pit10.getDown(), 60, 30);
            pit10.addActionListener(event -> playGame(10));
            pitsPanel.add(pit10);

            PositionAwareButton pit11 = new PositionAwareButton(String.valueOf(mancalaGame.getNumStones(11)));
            pit11.setAcross(540);
            pit11.setDown(180);
            pit11.setBounds(pit11.getAcross(), pit11.getDown(), 60, 30);
            pit11.addActionListener(event -> playGame(11));
            pitsPanel.add(pit11);

            PositionAwareButton pit12 = new PositionAwareButton(String.valueOf(mancalaGame.getNumStones(12)));
            pit12.setAcross(600);
            pit12.setDown(180);
            pit12.setBounds(pit12.getAcross(), pit12.getDown(), 60, 30);
            pit12.addActionListener(event -> playGame(12));
            pitsPanel.add(pit12);

            PositionAwareButton store1 = new PositionAwareButton(String.valueOf(mancalaGame.getStoreCount(playerOne)));
            store1.setAcross(240);
            store1.setDown(150);
            store1.setBounds(store1.getAcross(), store1.getDown(), 60, 60);
            pitsPanel.add(store1);

            PositionAwareButton store2 = new PositionAwareButton(String.valueOf(mancalaGame.getStoreCount(playerTwo)));
            store2.setAcross(660);
            store2.setDown(150);
            store2.setBounds(store2.getAcross(), store2.getDown(), 60, 60);
            pitsPanel.add(store2);


            getContentPane().add(pitsPanel); // Add the pitsPanel to the content pan

        } catch (PitNotFoundException err) {
            JOptionPane.showMessageDialog(this, err.getMessage(), "ERROR: Pit not found", JOptionPane.ERROR_MESSAGE);
        } catch (NoSuchPlayerException err) {
            JOptionPane.showMessageDialog(this, err.getMessage(), "ERROR: Player doesn't exist", JOptionPane.ERROR_MESSAGE);
        }

        // Repaint the frame to update the UI
        revalidate();
        repaint();
    }
 
    private void gameType(GameRules theBoard) {
        mancalaGame.setBoard(theBoard);
        JOptionPane.showMessageDialog(this, mancalaGame.getBoardName() + " is loaded", "Game type loaded", 1);
        mancalaGame.startNewGame();  
        startGame();
       // setupNewGame();
    }

    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Game Type");

        JMenuItem kalah = new JMenuItem("Kalah Rules");
        kalah.addActionListener(event -> gameType(new KalahRules()));
        fileMenu.add(kalah);

        JMenuItem ayo = new JMenuItem("Ayo Rules");
        ayo.addActionListener(event -> gameType(new AyoRules()));
        fileMenu.add(ayo);

        //JMenu fileMenu = new JMenu("File");

        //JMenuItem loadList = new JMenuItem("Load");
        //loadList.addActionListener(event -> loadFile());
       // fileMenu.add(loadList);

       // JMenuItem saveList = new JMenuItem("Save");
       // saveList.addActionListener(event -> saveFile(this.list));
       // fileMenu.add(saveList);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);
    }

    private void loadFile() {

        try {
            String saveFileName = JOptionPane.showInputDialog("Enter file name to load from");
            Saver saver = new Saver();
            UserProfile loadProfile = (UserProfile) saver.loadObject(saveFileName);
            playerOne.setName(loadProfile);
            JOptionPane.showMessageDialog(this, "Player 1 is loaded", "Hello, " + playerOne.getName(), 1);
        } catch (FileNotFoundException err) {
            JOptionPane.showMessageDialog(this, err.getMessage(), "ERROR: Cannot Find File Name", JOptionPane.ERROR_MESSAGE);
        }

        //refreshListPanel();
        
       /* 
        try {
            
            FileReader fr = new FileReader(saveFileName);

            String listTitle = fr.readLine();

            TodoList newList = new TodoList(listTitle);

            int numItems = fr.readInt();
            for (int i = 0; i < numItems; i++) {
                String itemTitle = fr.readLine();
                String itemDesc = fr.readLine();
                LocalDateTime dueDate = fr.readDateTime();
                int priority = fr.readInt();
                boolean completed = fr.readBoolean();

                newList.addItem(itemTitle, itemDesc, dueDate, priority);

                if (completed) {
                    newList.completeItem(newList.getIndexByTitle(itemTitle));
                }

            }

            this.list = newList;
            refreshListPanel();

            //System.out.println("List loaded from file '" + fr.getFilePath() + "'");

        } catch (FileFormatException err) {
            //System.out.println(err.getMessage());
            JOptionPane.showMessageDialog(this, err.getMessage(), "File Format Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception err) {
            //System.out.println(err);
            JOptionPane.showMessageDialog(this, err.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        } */

    }


    public static void main(String[] args) {
        new GUI("Mancala Game", 900, 500);
    }
}