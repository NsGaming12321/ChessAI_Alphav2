import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.util.ArrayList;
import java.util.Random;
//import java.awt.Color;

import javax.swing.JPanel;

/*
 * 
 * Generate mulitple moves into the future
 * Castling
 * En passant
 * Pawn Promotion
 * Checks and checkmate
 * 
 * Enhance Visuals
 */

//"main" class
public class Main extends JPanel implements Runnable {
    // serial version uid cuz it wanted me too
    private static final long serialVersionUID = 1L;

    Random rand = new Random();
    // parameters for the window
    private static final int width = 800;
    private static final int height = 800;
    // basic chess booleans
    public static boolean turn = true;
    public static boolean checkCheck = true;
    public static boolean whiteCheck = false;
    public static boolean blackCheck = false;
    public static int chosenOne;
    public static int chosenMove;
    public static int resetMove = 0;
    public static boolean gameOver = false;
    public static boolean winner = true;
    // second thread for game class
    Thread thread;
    // variables for the game loop
    boolean running;
    double updateRate = 1.0d / 60.0d;
    long nextStatTime;
    // gameloop statistics
    int fps;
    int ups;
    // board object
    Board board = new Board();
    // pieces
    Piece wr1 = new Piece(0, 7, true, 0, 0, 0, 5);
    Piece wr2 = new Piece(7, 7, true, 0, 0, 1, 5);
    Piece wn1 = new Piece(1, 7, true, 1, 1, 2, 3);
    Piece wn2 = new Piece(6, 7, true, 1, 1, 3, 3);
    Piece wb1 = new Piece(2, 7, true, 2, 2, 4, 3);
    Piece wb2 = new Piece(5, 7, true, 2, 2, 5, 3);
    Piece wk = new Piece(4, 7, true, 4, 4, 6, 1001);
    Piece wq = new Piece(3, 7, true, 3, 3, 7, 9);
    Piece br1 = new Piece(0, 0, false, 0, 5, 8, 5);
    Piece br2 = new Piece(7, 0, false, 0, 5, 9, 5);
    Piece bn1 = new Piece(1, 0, false, 1, 6, 10, 3);
    Piece bn2 = new Piece(6, 0, false, 1, 6, 11, 3);
    Piece bb1 = new Piece(2, 0, false, 2, 7, 12, 3);
    Piece bb2 = new Piece(5, 0, false, 2, 7, 13, 3);
    Piece bk = new Piece(4, 0, false, 4, 9, 14, 1000);
    Piece bq = new Piece(3, 0, false, 3, 8, 15, 9);
    // lots of pawns
    Piece wp1 = new Piece(0, 6, true, 5, 10, 16, 1);
    Piece wp2 = new Piece(1, 6, true, 5, 10, 17, 1);
    Piece wp3 = new Piece(2, 6, true, 5, 10, 18, 1);
    Piece wp4 = new Piece(3, 6, true, 5, 10, 19, 1);
    Piece wp5 = new Piece(4, 6, true, 5, 10, 20, 1);
    Piece wp6 = new Piece(5, 6, true, 5, 10, 21, 1);
    Piece wp7 = new Piece(6, 6, true, 5, 10, 22, 1);
    Piece wp8 = new Piece(7, 6, true, 5, 10, 23, 1);
    Piece bp1 = new Piece(0, 1, false, 5, 11, 24, 1);
    Piece bp2 = new Piece(1, 1, false, 5, 11, 25, 1);
    Piece bp3 = new Piece(2, 1, false, 5, 11, 26, 1);
    Piece bp4 = new Piece(3, 1, false, 5, 11, 27, 1);
    Piece bp5 = new Piece(4, 1, false, 5, 11, 28, 1);
    Piece bp6 = new Piece(5, 1, false, 5, 11, 29, 1);
    Piece bp7 = new Piece(6, 1, false, 5, 11, 30, 1);
    Piece bp8 = new Piece(7, 1, false, 5, 11, 31, 1);
    // arraylist for the pieces
    static ArrayList<Piece> pieces = new ArrayList<Piece>();

    // constructor
    public Main() {
        // add the pieces to the arraylist
        pieces.add(wr1);
        pieces.add(wr2);
        pieces.add(wn1);
        pieces.add(wn2);
        pieces.add(wb1);
        pieces.add(wb2);
        pieces.add(wq);
        pieces.add(wk);
        pieces.add(br1);
        pieces.add(br2);
        pieces.add(bn1);
        pieces.add(bn2);
        pieces.add(bb1);
        pieces.add(bb2);
        pieces.add(bq);
        pieces.add(bk);
        pieces.add(wp1);
        pieces.add(wp2);
        pieces.add(wp3);
        pieces.add(wp4);
        pieces.add(wp5);
        pieces.add(wp6);
        pieces.add(wp7);
        pieces.add(wp8);
        pieces.add(bp1);
        pieces.add(bp2);
        pieces.add(bp3);
        pieces.add(bp4);
        pieces.add(bp5);
        pieces.add(bp6);
        pieces.add(bp7);
        pieces.add(bp8);
        // set some parameters for the window
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        // start the method with the thread
        thread = new Thread(this);
        // start the thread
        thread.start();
        loadAllPossibleMoves();
    }

    // gameloop
    public void run() {
        running = true;
        double accumulator = 0;
        long currentTime = System.currentTimeMillis();
        long lastUpdate = System.currentTimeMillis();
        double lastRenderTimeInSeconds = currentTime - lastUpdate;
        nextStatTime = System.currentTimeMillis() + 1000;

        while (running) {
            currentTime = System.currentTimeMillis();
            lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderTimeInSeconds;
            lastUpdate = currentTime;

            while (accumulator > updateRate) {
                update();
                accumulator -= updateRate;
            }
            repaint();
            if (System.currentTimeMillis() > nextStatTime) {
                // System.out.println(ups);
                // System.out.println(fps);
                fps = 0;
                ups = 0;
                nextStatTime = System.currentTimeMillis() + 1000;
            }
        }
    }

    public void loadAllPossibleMoves() {
        Piece.allPossibleXMovesWhite.clear();
        Piece.allPossibleYMovesWhite.clear();
        Piece.allPossibleXMovesBlack.clear();
        Piece.allPossibleYMovesBlack.clear();
        Piece.allPossibleMovePieceNumsWhite.clear();
        Piece.allPossibleMovePieceNumsBlack.clear();
        for (int i = 0; i < Main.pieces.size(); i++) {
            Main.pieces.get(i).loadMoves();
        }
        Piece.currentPossibleXMoves.clear();
        Piece.currentPossibleYMoves.clear();
        if (Piece.allPossibleXMovesBlack.size() == 0 && Main.turn == false) {
            Main.gameOver = true;
            Main.winner = true;
        }
        // check for checks, mate
        /*
         * for (int i = 0; i < Piece.allPossibleXMovesBlack.size(); i++) {
         * if (wk.xTile == Piece.allPossibleXMovesBlack.get(i)
         * && wk.yTile == Piece.allPossibleYMovesBlack.get(i)) {
         * System.out.println("WHITE CHECK");
         * // whiteCheck = true;
         * }
         * }
         * for (int i = 0; i < Piece.allPossibleXMovesWhite.size(); i++) {
         * if (bk.xTile == Piece.allPossibleXMovesWhite.get(i)
         * && bk.yTile == Piece.allPossibleYMovesWhite.get(i)) {
         * System.out.println("BLACK CHECK");
         * // blackCheck = true;
         * }
         * }
         */
        /*
         * if (whiteCheck == true && Main.turn == true) {
         * Piece.allPossibleXMovesWhite.clear();
         * Piece.allPossibleYMovesWhite.clear();
         * Piece.allPossibleXMovesBlack.clear();
         * Piece.allPossibleYMovesBlack.clear();
         * wk.loadMoves();
         * wk.designated = true;
         * 
         * for (int i = 0; i < Piece.allPossibleXMovesBlack.size(); i++) {
         * 
         * }
         * }
         */
    }

    // main draw function
    public void paintComponent(Graphics g) {
        fps++;
        super.paintComponent(g);
        // draw board
        board.drawBoard(g);
        // draw all the pieces
        for (int i = 0; i < pieces.size(); i++) {
            pieces.get(i).drawPiece(g);
        }
        // draws the options for the pieces second
        for (int i = 0; i < pieces.size(); i++) {
            pieces.get(i).showOptions(g);
        }
        /*
         * for (int i = 0; i < Piece.allPossibleXMovesBlack.size(); i++) {
         * g.setColor(Color.GREEN);
         * g.fillOval(Piece.allPossibleXMovesBlack.get(i) * 100 + 25,
         * Piece.allPossibleYMovesBlack.get(i) * 100 + 25,
         * 50, 50);
         * }
         */

        if (gameOver == true) {
            if (winner == true) {
                g.drawString("WHITE WINS", 400, 400);
            } else {
                g.drawString("BLACK WINS", 400, 400);
            }

        }
    }

    public void update() {
        ups++;
        if (Piece.allPossibleXMovesBlack.size() != Piece.allPossibleYMovesBlack
                .size() || Piece.allPossibleXMovesBlack.size() != Piece.allPossibleMovePieceNumsBlack.size()) {
            System.out.println(Piece.allPossibleXMovesBlack.size());
            System.out.println(Piece.allPossibleYMovesBlack.size());
            System.out.println(Piece.allPossibleMovePieceNumsBlack.size());
            System.out.println(Piece.allPossibleXMovesBlack);
            System.out.println(Piece.allPossibleYMovesBlack);
            System.out.println(Piece.allPossibleMovePieceNumsBlack);
            System.out.println("FUCK");
            System.exit(ABORT);
        }
        // checking to see if you are holding a piece
        // if so make the piece follow your cursor
        // if not snap the piece back in place
        for (int i = 0; i < pieces.size(); i++) {
            // check if holding
            if (pieces.get(i).holding == false) {
                // snap the piece back in place
                pieces.get(i).xPos = pieces.get(i).xTile * Board.tileSize;
                pieces.get(i).yPos = pieces.get(i).yTile * Board.tileSize;

            } else if (pieces.get(i).holding == true) {
                // follow the cursor
                pieces.get(i).xPos = (int) MouseInfo.getPointerInfo().getLocation().getX() - 368;
                pieces.get(i).yPos = (int) MouseInfo.getPointerInfo().getLocation().getY() - 100;
            }
        }
        if (turn == false && gameOver == false) {
            MyMouseListener.AIMove();
        }
    }
}
