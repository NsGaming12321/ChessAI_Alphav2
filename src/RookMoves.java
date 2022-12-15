import java.util.ArrayList;

public class RookMoves {
    public static void addRookMoves(int xTile, int yTile, ArrayList<Integer> possibleXMoves,
            ArrayList<Integer> possibleYMoves, boolean colour, int pieceNum) {
        // adding rooks possible moves
        for (int j = xTile + 1; j <= 7; j++) {
            for (int i = 0; i < Main.pieces.size(); i++) {
                if (Main.pieces.get(i).xTile == j && Main.pieces.get(i).yTile == yTile) {
                    if (Main.pieces.get(i).colour != colour) {
                        possibleXMoves.add(j);
                        possibleYMoves.add(yTile);
                        if (colour == true) {
                            Piece.allPossibleXMovesWhite.add(j);
                            Piece.allPossibleYMovesWhite.add(yTile);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        } else {
                            Piece.allPossibleXMovesBlack.add(j);
                            Piece.allPossibleYMovesBlack.add(yTile);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                    i = Main.pieces.size();
                    j = 8;
                } else if (i == Main.pieces.size() - 1) {
                    possibleXMoves.add(j);
                    possibleYMoves.add(yTile);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(j);
                        Piece.allPossibleYMovesWhite.add(yTile);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(j);
                        Piece.allPossibleYMovesBlack.add(yTile);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
            }
        }
        for (int j = xTile - 1; j >= 0; j--) {
            for (int i = 0; i < Main.pieces.size(); i++) {
                if (Main.pieces.get(i).xTile == j && Main.pieces.get(i).yTile == yTile) {
                    if (Main.pieces.get(i).colour != colour) {
                        possibleXMoves.add(j);
                        possibleYMoves.add(yTile);
                        if (colour == true) {
                            Piece.allPossibleXMovesWhite.add(j);
                            Piece.allPossibleYMovesWhite.add(yTile);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        } else {
                            Piece.allPossibleXMovesBlack.add(j);
                            Piece.allPossibleYMovesBlack.add(yTile);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                    i = Main.pieces.size();
                    j = -1;
                } else if (i == Main.pieces.size() - 1) {
                    possibleXMoves.add(j);
                    possibleYMoves.add(yTile);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(j);
                        Piece.allPossibleYMovesWhite.add(yTile);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(j);
                        Piece.allPossibleYMovesBlack.add(yTile);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
            }
        }
        for (int j = yTile + 1; j <= 7; j++) {
            for (int i = 0; i < Main.pieces.size(); i++) {
                if (Main.pieces.get(i).xTile == xTile && Main.pieces.get(i).yTile == j) {
                    if (Main.pieces.get(i).colour != colour) {
                        possibleXMoves.add(xTile);
                        possibleYMoves.add(j);
                        if (colour == true) {
                            Piece.allPossibleXMovesWhite.add(xTile);
                            Piece.allPossibleYMovesWhite.add(j);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        } else {
                            Piece.allPossibleXMovesBlack.add(xTile);
                            Piece.allPossibleYMovesBlack.add(j);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                    i = Main.pieces.size();
                    j = 8;
                } else if (i == Main.pieces.size() - 1) {
                    possibleXMoves.add(xTile);
                    possibleYMoves.add(j);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(xTile);
                        Piece.allPossibleYMovesWhite.add(j);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(xTile);
                        Piece.allPossibleYMovesBlack.add(j);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
            }
        }
        for (int j = yTile - 1; j >= 0; j--) {
            for (int i = 0; i < Main.pieces.size(); i++) {
                if (Main.pieces.get(i).xTile == xTile && Main.pieces.get(i).yTile == j) {
                    if (Main.pieces.get(i).colour != colour) {
                        possibleXMoves.add(xTile);
                        possibleYMoves.add(j);
                        if (colour == true) {
                            Piece.allPossibleXMovesWhite.add(xTile);
                            Piece.allPossibleYMovesWhite.add(j);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        } else {
                            Piece.allPossibleXMovesBlack.add(xTile);
                            Piece.allPossibleYMovesBlack.add(j);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                    i = Main.pieces.size();
                    j = -1;
                } else if (i == Main.pieces.size() - 1) {
                    possibleXMoves.add(xTile);
                    possibleYMoves.add(j);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(xTile);
                        Piece.allPossibleYMovesWhite.add(j);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(xTile);
                        Piece.allPossibleYMovesBlack.add(j);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
            }
        }
    }
}