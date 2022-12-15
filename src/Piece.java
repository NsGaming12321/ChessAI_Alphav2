import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Piece {
	// basic piece variables
	public int xTile;
	public int yTile;
	public int xPos;
	public int yPos;
	public boolean colour; // white true, black false
	public int type;
	public int cost;
	public int imageNum; // 0 is rook, 1 is knight, 2 is bishop, 3 is queen, 4 is king, 5 is pawn
	// showing shows the red circles
	public int pieceNum;
	public boolean showing = false;
	public boolean holding = false;
	// a temp variable to allow some fancy drag and drop stuff
	public boolean doNotShow = false;
	public boolean designated = false;

	// create images for the pieces
	Image wrImage;
	Image wnImage;
	Image wbImage;
	Image wqImage;
	Image wkImage;
	Image wpImage;
	Image brImage;
	Image bnImage;
	Image bbImage;
	Image bqImage;
	Image bkImage;
	Image bpImage;
	// get the urls to the images
	String wrURL = "whiteRook.png";
	String wnURL = "whiteKnight.png";
	String wbURL = "whiteBishop.png";
	String wqURL = "whiteQueen.png";
	String wkURL = "whiteKing.png";
	String wpURL = "whitePawn.png";
	String brURL = "blackRook.png";
	String bnURL = "blackKnight.png";
	String bbURL = "blackBishop.png";
	String bqURL = "blackQueen.png";
	String bkURL = "blackKing.png";
	String bpURL = "blackPawn.png";
	// arraylist that stores the possible moves
	static ArrayList<Integer> currentPossibleXMoves = new ArrayList<Integer>();
	static ArrayList<Integer> currentPossibleYMoves = new ArrayList<Integer>();
	// all possible moves
	static ArrayList<Integer> allPossibleXMovesWhite = new ArrayList<Integer>();
	static ArrayList<Integer> allPossibleYMovesWhite = new ArrayList<Integer>();
	static ArrayList<Integer> allPossibleXMovesBlack = new ArrayList<Integer>();
	static ArrayList<Integer> allPossibleYMovesBlack = new ArrayList<Integer>();

	static ArrayList<Integer> allPossibleMovePieceNumsWhite = new ArrayList<Integer>();
	static ArrayList<Integer> allPossibleMovePieceNumsBlack = new ArrayList<Integer>();
	// arraylist that stores the images
	ArrayList<Image> images = new ArrayList<Image>();
	// a temperary variable to add the possible moves to the possibleMoves

	// constructor
	public Piece(int xTile, int yTile, boolean colour, int type, int imageNum, int pieceNum, int cost) {
		// making it easier to define where a piece starts and what type it is
		this.xTile = xTile;
		this.yTile = yTile;
		this.colour = colour;
		this.type = type;
		this.imageNum = imageNum;
		this.pieceNum = pieceNum;
		this.cost = cost;
		// initializing the images
		wrImage = Toolkit.getDefaultToolkit().getImage(wrURL);
		wnImage = Toolkit.getDefaultToolkit().getImage(wnURL);
		wbImage = Toolkit.getDefaultToolkit().getImage(wbURL);
		wqImage = Toolkit.getDefaultToolkit().getImage(wqURL);
		wkImage = Toolkit.getDefaultToolkit().getImage(wkURL);
		wpImage = Toolkit.getDefaultToolkit().getImage(wpURL);
		brImage = Toolkit.getDefaultToolkit().getImage(brURL);
		bnImage = Toolkit.getDefaultToolkit().getImage(bnURL);
		bbImage = Toolkit.getDefaultToolkit().getImage(bbURL);
		bqImage = Toolkit.getDefaultToolkit().getImage(bqURL);
		bkImage = Toolkit.getDefaultToolkit().getImage(bkURL);
		bpImage = Toolkit.getDefaultToolkit().getImage(bpURL);
		// adding the images to the array of images
		images.add(wrImage);
		images.add(wnImage);
		images.add(wbImage);
		images.add(wqImage);
		images.add(wkImage);
		images.add(brImage);
		images.add(bnImage);
		images.add(bbImage);
		images.add(bqImage);
		images.add(bkImage);
		images.add(wpImage);
		images.add(bpImage);
	}

	// draws the pieces
	public void drawPiece(Graphics g) {
		g.drawImage(images.get(imageNum), xPos + 5, yPos + 5, 90, 90, null);
	}

	// adds the moves
	public void showOptions(Graphics g) {
		// checking if a piece is selected
		if (showing == true) {
			// checking if its the correct pieces turn
			if (colour == true && Main.turn == true || colour == false && Main.turn == false) {
				// actually drawing the possible moves
				for (int j = 0; j < currentPossibleXMoves.size(); j++) {
					g.setColor(Color.RED);
					g.fillOval(currentPossibleXMoves.get(j) * 100 + 25, currentPossibleYMoves.get(j) * 100 + 25, 50,
							50);
				}
			}
		}
	}

	public void loadMoves() {
		if (type == 0) {
			RookMoves.addRookMoves(xTile, yTile, currentPossibleXMoves, currentPossibleYMoves, colour, pieceNum);
		} else if (type == 1) {
			KnightMoves.addKnightMoves(xTile, yTile, currentPossibleXMoves, currentPossibleYMoves, colour, pieceNum);
		} else if (type == 2) {
			BishopMoves.addBishopMoves(xTile, yTile, currentPossibleXMoves, currentPossibleYMoves, colour, pieceNum);
		} else if (type == 3) {
			RookMoves.addRookMoves(xTile, yTile, currentPossibleXMoves, currentPossibleYMoves, colour, pieceNum);
			BishopMoves.addBishopMoves(xTile, yTile, currentPossibleXMoves, currentPossibleYMoves, colour, pieceNum);
		} else if (type == 4) {
			if (xTile + 1 <= 7) {
				KingMoves.addKingMoves(xTile, yTile, currentPossibleXMoves, currentPossibleYMoves, colour, 1, 0,
						pieceNum);
			}
			if (xTile - 1 >= 0) {
				KingMoves.addKingMoves(xTile, yTile, currentPossibleXMoves, currentPossibleYMoves, colour, -1, 0,
						pieceNum);
			}
			if (yTile + 1 <= 7) {
				KingMoves.addKingMoves(xTile, yTile, currentPossibleXMoves, currentPossibleYMoves, colour, 0, 1,
						pieceNum);
			}
			if (yTile - 1 >= 0) {
				KingMoves.addKingMoves(xTile, yTile, currentPossibleXMoves, currentPossibleYMoves, colour, 0, -1,
						pieceNum);
			}
			if (xTile + 1 <= 7 && yTile + 1 <= 7) {
				KingMoves.addKingMoves(xTile, yTile, currentPossibleXMoves, currentPossibleYMoves, colour, 1, 1,
						pieceNum);
			}
			if (xTile + 1 <= 7 && yTile - 1 >= 0) {
				KingMoves.addKingMoves(xTile, yTile, currentPossibleXMoves, currentPossibleYMoves, colour, 1, -1,
						pieceNum);
			}
			if (xTile - 1 >= 0 && yTile + 1 <= 7) {
				KingMoves.addKingMoves(xTile, yTile, currentPossibleXMoves, currentPossibleYMoves, colour, -1, 1,
						pieceNum);
			}
			if (xTile - 1 >= 0 && yTile - 1 >= 0) {
				KingMoves.addKingMoves(xTile, yTile, currentPossibleXMoves, currentPossibleYMoves, colour, -1, -1,
						pieceNum);
			}
		} else if (type == 5) {
			PawnMoves.addPawnMoves(xTile, yTile, currentPossibleXMoves, currentPossibleYMoves, colour, pieceNum);
		}
		// reverse the temp variable
	}

}
