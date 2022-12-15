import java.util.ArrayList;

public class BishopMoves {
    public static void addBishopMoves(int xTile, int yTile, ArrayList<Integer> possibleXMoves,
            ArrayList<Integer> possibleYMoves,
            boolean colour, int pieceNum) {
        // add bishop possible moves
        for (int j = xTile + 1, k = yTile + 1; j <= 7 && k <= 7; j++, k++) {
            for (int i = 0; i < Main.pieces.size(); i++) {
                if (Main.pieces.get(i).xTile == j && Main.pieces.get(i).yTile == k) {
                    if (Main.pieces.get(i).colour != colour) {
                        possibleXMoves.add(j);
                        possibleYMoves.add(k);
                        if (colour == true) {
                            Piece.allPossibleXMovesWhite.add(j);
                            Piece.allPossibleYMovesWhite.add(k);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        } else {
                            Piece.allPossibleXMovesBlack.add(j);
                            Piece.allPossibleYMovesBlack.add(k);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                    i = Main.pieces.size();
                    j = 8;
                    k = 8;
                } else if (i == Main.pieces.size() - 1) {
                    possibleXMoves.add(j);
                    possibleYMoves.add(k);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(j);
                        Piece.allPossibleYMovesWhite.add(k);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(j);
                        Piece.allPossibleYMovesBlack.add(k);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
            }
        }
        for (int j = xTile - 1, k = yTile - 1; j >= 0 && k >= 0; j--, k--) {
            for (int i = 0; i < Main.pieces.size(); i++) {
                if (Main.pieces.get(i).xTile == j && Main.pieces.get(i).yTile == k) {
                    if (Main.pieces.get(i).colour != colour) {
                        possibleXMoves.add(j);
                        possibleYMoves.add(k);
                        if (colour == true) {
                            Piece.allPossibleXMovesWhite.add(j);
                            Piece.allPossibleYMovesWhite.add(k);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        } else {
                            Piece.allPossibleXMovesBlack.add(j);
                            Piece.allPossibleYMovesBlack.add(k);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                    i = Main.pieces.size();
                    j = -1;
                    k = -1;
                } else if (i == Main.pieces.size() - 1) {
                    possibleXMoves.add(j);
                    possibleYMoves.add(k);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(j);
                        Piece.allPossibleYMovesWhite.add(k);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(j);
                        Piece.allPossibleYMovesBlack.add(k);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
            }
        }
        for (int j = xTile + 1, k = yTile - 1; j <= 7 && k >= 0; j++, k--) {
            for (int i = 0; i < Main.pieces.size(); i++) {
                if (Main.pieces.get(i).xTile == j && Main.pieces.get(i).yTile == k) {
                    if (Main.pieces.get(i).colour != colour) {
                        possibleXMoves.add(j);
                        possibleYMoves.add(k);
                        if (colour == true) {
                            Piece.allPossibleXMovesWhite.add(j);
                            Piece.allPossibleYMovesWhite.add(k);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        } else {
                            Piece.allPossibleXMovesBlack.add(j);
                            Piece.allPossibleYMovesBlack.add(k);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                    i = Main.pieces.size();
                    j = 8;
                    k = -1;
                } else if (i == Main.pieces.size() - 1) {
                    possibleXMoves.add(j);
                    possibleYMoves.add(k);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(j);
                        Piece.allPossibleYMovesWhite.add(k);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(j);
                        Piece.allPossibleYMovesBlack.add(k);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
            }
        }
        for (int j = xTile - 1, k = yTile + 1; j >= 0 && k <= 7; j--, k++) {
            for (int i = 0; i < Main.pieces.size(); i++) {
                if (Main.pieces.get(i).xTile == j && Main.pieces.get(i).yTile == k) {
                    if (Main.pieces.get(i).colour != colour) {
                        possibleXMoves.add(j);
                        possibleYMoves.add(k);
                        if (colour == true) {
                            Piece.allPossibleXMovesWhite.add(j);
                            Piece.allPossibleYMovesWhite.add(k);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        } else {
                            Piece.allPossibleXMovesBlack.add(j);
                            Piece.allPossibleYMovesBlack.add(k);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                    i = Main.pieces.size();
                    j = -1;
                    k = 8;
                } else if (i == Main.pieces.size() - 1) {
                    possibleXMoves.add(j);
                    possibleYMoves.add(k);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(j);
                        Piece.allPossibleYMovesWhite.add(k);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(j);
                        Piece.allPossibleYMovesBlack.add(k);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
            }
        }
    }
}
