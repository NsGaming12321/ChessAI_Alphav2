import java.util.ArrayList;

public class KingMoves {
    public static boolean okok = true;

    public static void addKingMoves(int xTile, int yTile, ArrayList<Integer> possibleXMoves,
            ArrayList<Integer> possibleYMoves, boolean colour, int plusX, int plusY, int pieceNum) {
        okok = true;
        // add king moves
        for (int i = 0; i < Main.pieces.size(); i++) {
            if (Main.pieces.get(i).xTile == xTile + plusX && Main.pieces.get(i).yTile == yTile + plusY) {
                if (Main.pieces.get(i).colour != colour) {
                    possibleXMoves.add(xTile + plusX);
                    possibleYMoves.add(yTile + plusY);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(xTile + plusX);
                        Piece.allPossibleYMovesWhite.add(yTile + plusY);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(xTile + plusX);
                        Piece.allPossibleYMovesBlack.add(yTile + plusY);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
                i = Main.pieces.size();
            } else if (i == Main.pieces.size() - 1) {
                if (colour == false) {
                    for (int j = 0; j < Piece.allPossibleXMovesWhite.size(); j++) {
                        if (xTile + plusX == Piece.allPossibleXMovesWhite.get(j)
                                && yTile + plusY == Piece.allPossibleYMovesWhite.get(j)) {
                            okok = false;
                        }
                    }
                } else {
                    for (int j = 0; j < Piece.allPossibleXMovesBlack.size(); j++) {
                        if (xTile + plusX == Piece.allPossibleXMovesBlack.get(j)
                                && yTile + plusY == Piece.allPossibleYMovesBlack.get(j)) {
                            okok = false;
                        }
                    }
                }
                if (okok == true) {
                    possibleXMoves.add(xTile + plusX);
                    possibleYMoves.add(yTile + plusY);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(xTile + plusX);
                        Piece.allPossibleYMovesWhite.add(yTile + plusY);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(xTile + plusX);
                        Piece.allPossibleYMovesBlack.add(yTile + plusY);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
            }
        }
    }
}
