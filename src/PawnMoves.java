import java.util.ArrayList;

public class PawnMoves {
    public static void addPawnMoves(int xTile, int yTile, ArrayList<Integer> possibleXMoves,
            ArrayList<Integer> possibleYMoves, boolean colour, int pieceNum) {
        if (colour == true) {
            if (yTile == 6) {
                for (int j = yTile - 1; j >= yTile - 2; j--) {
                    for (int i = 0; i < Main.pieces.size(); i++) {
                        if (Main.pieces.get(i).xTile == xTile && Main.pieces.get(i).yTile == j) {
                            i = Main.pieces.size();
                            j = -10;
                        } else if (i == Main.pieces.size() - 1) {
                            possibleXMoves.add(xTile);
                            possibleYMoves.add(j);
                            Piece.allPossibleXMovesWhite.add(xTile);
                            Piece.allPossibleYMovesWhite.add(j);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        }
                    }
                }
            } else {
                if (yTile - 1 >= 0) {
                    for (int i = 0; i < Main.pieces.size(); i++) {
                        if (Main.pieces.get(i).xTile == xTile && Main.pieces.get(i).yTile == yTile - 1) {
                            i = Main.pieces.size();
                        } else if (i == Main.pieces.size() - 1) {
                            possibleXMoves.add(xTile);
                            possibleYMoves.add(yTile - 1);
                            Piece.allPossibleXMovesWhite.add(xTile);
                            Piece.allPossibleYMovesWhite.add(yTile - 1);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        }
                    }
                }
            }
            if (xTile - 1 >= 0 && yTile - 1 >= 0) {
                for (int i = 0; i < Main.pieces.size(); i++) {
                    if (Main.pieces.get(i).xTile == xTile - 1 && Main.pieces.get(i).yTile == yTile - 1) {
                        if (Main.pieces.get(i).colour != colour) {
                            possibleXMoves.add(xTile - 1);
                            possibleYMoves.add(yTile - 1);
                            Piece.allPossibleXMovesWhite.add(xTile - 1);
                            Piece.allPossibleYMovesWhite.add(yTile - 1);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        }
                        i = Main.pieces.size();
                    }
                }
            }
            if (xTile + 1 >= 0 && yTile - 1 >= 0) {
                for (int i = 0; i < Main.pieces.size(); i++) {
                    if (Main.pieces.get(i).xTile == xTile + 1 && Main.pieces.get(i).yTile == yTile - 1) {
                        if (Main.pieces.get(i).colour != colour) {
                            possibleXMoves.add(xTile + 1);
                            possibleYMoves.add(yTile - 1);
                            Piece.allPossibleXMovesWhite.add(xTile + 1);
                            Piece.allPossibleYMovesWhite.add(yTile - 1);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        }
                        i = Main.pieces.size();
                    }
                }
            }
        } else if (colour == false) {
            if (yTile == 1) {
                for (int j = yTile + 1; j <= yTile + 2; j++) {
                    for (int i = 0; i < Main.pieces.size(); i++) {
                        if (Main.pieces.get(i).xTile == xTile && Main.pieces.get(i).yTile == j) {
                            i = Main.pieces.size();
                            j = 8;
                        } else if (i == Main.pieces.size() - 1) {
                            possibleXMoves.add(xTile);
                            possibleYMoves.add(j);
                            Piece.allPossibleXMovesBlack.add(xTile);
                            Piece.allPossibleYMovesBlack.add(j);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                }
            } else {
                if (yTile + 1 <= 7) {
                    for (int i = 0; i < Main.pieces.size(); i++) {
                        if (Main.pieces.get(i).xTile == xTile && Main.pieces.get(i).yTile == yTile + 1) {
                            i = Main.pieces.size();
                        } else if (i == Main.pieces.size() - 1) {
                            possibleXMoves.add(xTile);
                            possibleYMoves.add(yTile + 1);
                            Piece.allPossibleXMovesBlack.add(xTile);
                            Piece.allPossibleYMovesBlack.add(yTile + 1);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                }
            }
            if (xTile - 1 >= 0 && yTile + 1 >= 0) {
                for (int i = 0; i < Main.pieces.size(); i++) {
                    if (Main.pieces.get(i).xTile == xTile - 1 && Main.pieces.get(i).yTile == yTile + 1) {
                        if (Main.pieces.get(i).colour != colour) {
                            possibleXMoves.add(xTile - 1);
                            possibleYMoves.add(yTile + 1);
                            Piece.allPossibleXMovesBlack.add(xTile - 1);
                            Piece.allPossibleYMovesBlack.add(yTile + 1);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                        i = Main.pieces.size();
                    }
                }
            }
            if (xTile + 1 >= 0 && yTile + 1 >= 0) {
                for (int i = 0; i < Main.pieces.size(); i++) {
                    if (Main.pieces.get(i).xTile == xTile + 1 && Main.pieces.get(i).yTile == yTile + 1) {
                        if (Main.pieces.get(i).colour != colour) {
                            possibleXMoves.add(xTile + 1);
                            possibleYMoves.add(yTile + 1);
                            Piece.allPossibleXMovesBlack.add(xTile + 1);
                            Piece.allPossibleYMovesBlack.add(yTile + 1);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                        i = Main.pieces.size();
                    }
                }
            }
        }
    }
}
