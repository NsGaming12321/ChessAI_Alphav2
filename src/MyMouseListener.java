import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MyMouseListener implements MouseListener {

	Game game = new Game();

	public static int storedRemoverIndex;
	public static boolean removePiece = false;
	public static int storedRemoverIndex2;
	public static boolean removePiece2 = false;

	static Random rand = new Random();

	public MyMouseListener() {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	// mouse is pressed
	public void mousePressed(MouseEvent e) {
		// check for every piece
		for (int i = 0; i < Main.pieces.size(); i++) {
			if (Main.turn == true && Main.pieces.get(i).colour == true
					|| Main.turn == false && Main.pieces.get(i).colour == false) {
				// if click a piece
				if (Math.floor(e.getX() / 100) == Main.pieces.get(i).xTile
						&& Math.floor(e.getY() / 100) == Main.pieces.get(i).yTile
						&& Main.pieces.get(i).showing == false) {
					// set all pieces to not show (to have only 1 selected)

					for (int s = 0; s < Main.pieces.size(); s++) {
						Main.pieces.get(s).showing = false;
					}
					Piece.currentPossibleXMoves.clear();
					Piece.currentPossibleYMoves.clear();
					if (Main.whiteCheck == false && Main.blackCheck == false) {
						Main.pieces.get(i).loadMoves();
					} else {
						for (int s = 0; s < Main.pieces.size(); s++) {
							if (Main.pieces.get(s).designated == true) {
								Main.pieces.get(s).loadMoves();
							}
						}
					}
					for (int k = 0; k < Piece.currentPossibleXMoves.size(); k++) {
						if (Main.pieces.get(i).colour == true) {
							Piece.allPossibleXMovesWhite.remove(Piece.allPossibleXMovesWhite.size() - 1);
							Piece.allPossibleYMovesWhite.remove(Piece.allPossibleYMovesWhite.size() - 1);
							Piece.allPossibleMovePieceNumsWhite.remove(Piece.allPossibleMovePieceNumsWhite.size() - 1);
						} else {
							Piece.allPossibleXMovesBlack.remove(Piece.allPossibleXMovesBlack.size() - 1);
							Piece.allPossibleYMovesBlack.remove(Piece.allPossibleYMovesBlack.size() - 1);
							Piece.allPossibleMovePieceNumsBlack.remove(Piece.allPossibleMovePieceNumsBlack.size() - 1);
						}

					}

					// show the piece, hold the piece
					Main.pieces.get(i).showing = true;
					Main.pieces.get(i).holding = true;
					// for fancy stuff
					Main.pieces.get(i).doNotShow = false;
					// if click on piece and showing is true
				} else if (Math.floor(e.getX() / 100) == Main.pieces.get(i).xTile
						&& Math.floor(e.getY() / 100) == Main.pieces.get(i).yTile
						&& Main.pieces.get(i).showing == true) {
					// set all pieces to not show
					for (int s = 0; s < Main.pieces.size(); s++) {
						Main.pieces.get(s).showing = false;
					}
					// show the piece and hold
					Main.pieces.get(i).showing = true;
					Main.pieces.get(i).holding = true;
					// fancy stuff
					Main.pieces.get(i).doNotShow = true;
				}
			}
		}
	}

	// if mouse released
	public void mouseReleased(MouseEvent e) {
		// repeat for every piece

		for (int i = 0; i < Main.pieces.size(); i++) {
			if (Main.turn == true && Main.pieces.get(i).colour == true
					|| Main.turn == false && Main.pieces.get(i).colour == false) {
				// if let go of piece
				if (Math.floor(e.getX() / 100) == Main.pieces.get(i).xTile
						&& Math.floor(e.getY() / 100) == Main.pieces.get(i).yTile
						&& Main.pieces.get(i).doNotShow == false) {
					// set piece holding to false, etc
					Main.pieces.get(i).holding = false;
					Main.pieces.get(i).showing = true;
					Main.pieces.get(i).doNotShow = true;
					// completely disselect piece
				} else if (Math.floor(e.getX() / 100) == Main.pieces.get(i).xTile
						&& Math.floor(e.getY() / 100) == Main.pieces.get(i).yTile && Main.pieces.get(i).showing == true
						&& Main.pieces.get(i).doNotShow == true) {
					// holding, showing false
					Main.pieces.get(i).holding = false;
					Main.pieces.get(i).showing = false;
					Main.pieces.get(i).doNotShow = true;
					// clear possible moves
					Piece.currentPossibleXMoves.clear();
					Piece.currentPossibleYMoves.clear();
					// if you didnt disselect on a piece
				} else {
					// snap the piece back in place
					Main.pieces.get(i).holding = false;
				}
				// repeat for every possible move
				for (int j = 0; j < Piece.currentPossibleXMoves.size(); j++) {
					// if piece is showing
					if (Main.pieces.get(i).showing == true) {
						// if you release on one of the possible moves
						if (Math.floor(e.getX() / 100) == Piece.currentPossibleXMoves.get(j)
								&& Math.floor(e.getY() / 100) == Piece.currentPossibleYMoves.get(j)) {
							// remove the piece that was previously there
							for (int k = 0; k < Main.pieces.size(); k++) {
								if (Main.pieces.get(k).xTile == Piece.currentPossibleXMoves.get(j)
										&& Main.pieces.get(k).yTile == Piece.currentPossibleYMoves.get(j)) {
									storedRemoverIndex = k;
									removePiece = true;
									k = Main.pieces.size();
								}
							}
							// set the new pieces position
							Main.pieces.get(i).xTile = Piece.currentPossibleXMoves.get(j);
							Main.pieces.get(i).yTile = Piece.currentPossibleYMoves.get(j);
							// clear possible moves
							Piece.currentPossibleXMoves.clear();
							Piece.currentPossibleYMoves.clear();
							// set stuff to default
							Main.pieces.get(i).holding = false;
							Main.pieces.get(i).showing = false;
							// flip turn
							Main.turn = !Main.turn;

							Main.whiteCheck = false;
							Main.blackCheck = false;
							if (removePiece == false) {
								Game.main.loadAllPossibleMoves();
							}

							for (int s = 0; s < Main.pieces.size(); s++) {
								if (Main.pieces.get(s).colour == !Main.turn) {
									Main.pieces.get(s).showing = false;
									Main.pieces.get(s).holding = false;
								}
							}
							// if you release not on a possible move
						} else {
							// disselect piece
							Main.pieces.get(i).holding = false;
							for (int s = 0; s < Main.pieces.size(); s++) {
								Main.pieces.get(s).showing = false;
							}
							Main.pieces.get(i).showing = true;
						}
					}
				}
			}
		}
		if (removePiece == true) {
			removePiece();
		}
	}

	public static void removePiece() {
		Main.pieces.remove(storedRemoverIndex);
		storedRemoverIndex = -1;
		removePiece = false;
	}

	public static void setAIMove() {
		for (int i = 0; i < Piece.allPossibleXMovesBlack.size(); i++) {

		}
		// fix this
		Main.chosenOne = rand.nextInt(0, Main.pieces.size());
		Main.chosenMove = rand.nextInt(0, Piece.allPossibleXMovesBlack.size());
		while (Piece.allPossibleMovePieceNumsBlack.contains(Main.pieces.get(Main.chosenOne).pieceNum) == false) {
			Main.chosenOne = rand.nextInt(0, Main.pieces.size());
			System.out.println("dole moment");
		}
		while (Main.pieces.get(Main.chosenOne).pieceNum != Piece.allPossibleMovePieceNumsBlack
				.get(Main.chosenMove)) {
			Main.chosenMove = rand.nextInt(0, Piece.allPossibleXMovesBlack.size());
			System.out.println("fuck");
		}
	}

	public static void AIMove() {
		Game.main.loadAllPossibleMoves();
		setAIMove();
		if (storedRemoverIndex2 != -1) {
			while (Main.pieces.get(storedRemoverIndex2).cost < Main.pieces.get(Main.chosenOne).cost) {
				setAIMove();
			}
		}
		// remove the piece that was previously there
		for (int k = 0; k < Main.pieces.size(); k++) {
			if (Main.pieces.get(k).xTile == Piece.allPossibleXMovesBlack.get(Main.chosenMove)
					&& Main.pieces.get(k).yTile == Piece.allPossibleYMovesBlack.get(Main.chosenMove)) {
				storedRemoverIndex2 = k;
				removePiece2 = true;
				k = Main.pieces.size();
			}
		}

		Main.pieces.get(Main.chosenOne).xTile = Piece.allPossibleXMovesBlack.get(Main.chosenMove);
		Main.pieces.get(Main.chosenOne).yTile = Piece.allPossibleYMovesBlack.get(Main.chosenMove);
		// clear possible moves
		Piece.currentPossibleXMoves.clear();
		Piece.currentPossibleYMoves.clear();
		// set stuff to default
		Main.pieces.get(Main.chosenOne).holding = false;
		Main.pieces.get(Main.chosenOne).showing = false;
		// flip turn
		Main.turn = !Main.turn;
		Main.whiteCheck = false;
		Main.blackCheck = false;

		for (int s = 0; s < Main.pieces.size(); s++) {
			if (Main.pieces.get(s).colour == !Main.turn) {
				Main.pieces.get(s).showing = false;
				Main.pieces.get(s).holding = false;
			}
		}
		if (removePiece2 == true) {
			removePiece2();
		}
		Main.resetMove = 0;
	}

	public static void removePiece2() {
		Main.pieces.remove(storedRemoverIndex2);
		storedRemoverIndex2 = -1;
		Game.main.loadAllPossibleMoves();
		removePiece2 = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
