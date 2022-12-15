
import java.util.ArrayList;

public class KnightMoves {
    public static void addKnightMoves(int xTile, int yTile, ArrayList<Integer> possibleXMoves,
            ArrayList<Integer> possibleYMoves, boolean colour, int pieceNum) {
        // add knight moves
        if (xTile + 2 <= 7 && yTile + 1 <= 7) {
            for (int i = 0; i < Main.pieces.size(); i++) {
                if (Main.pieces.get(i).xTile == xTile + 2 && Main.pieces.get(i).yTile == yTile + 1) {
                    if (Main.pieces.get(i).colour != colour) {
                        possibleXMoves.add(xTile + 2);
                        possibleYMoves.add(yTile + 1);
                        if (colour == true) {
                            Piece.allPossibleXMovesWhite.add(xTile + 2);
                            Piece.allPossibleYMovesWhite.add(yTile + 1);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        } else {
                            Piece.allPossibleXMovesBlack.add(xTile + 2);
                            Piece.allPossibleYMovesBlack.add(yTile + 1);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                    i = Main.pieces.size();
                } else if (i == Main.pieces.size() - 1) {
                    possibleXMoves.add(xTile + 2);
                    possibleYMoves.add(yTile + 1);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(xTile + 2);
                        Piece.allPossibleYMovesWhite.add(yTile + 1);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(xTile + 2);
                        Piece.allPossibleYMovesBlack.add(yTile + 1);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
            }
        }
        if (xTile + 2 <= 7 && yTile - 1 >= 0) {
            for (int i = 0; i < Main.pieces.size(); i++) {
                if (Main.pieces.get(i).xTile == xTile + 2 && Main.pieces.get(i).yTile == yTile - 1) {
                    if (Main.pieces.get(i).colour != colour) {
                        possibleXMoves.add(xTile + 2);
                        possibleYMoves.add(yTile - 1);
                        if (colour == true) {
                            Piece.allPossibleXMovesWhite.add(xTile + 2);
                            Piece.allPossibleYMovesWhite.add(yTile - 1);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        } else {
                            Piece.allPossibleXMovesBlack.add(xTile + 2);
                            Piece.allPossibleYMovesBlack.add(yTile - 1);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                    i = Main.pieces.size();
                } else if (i == Main.pieces.size() - 1) {
                    possibleXMoves.add(xTile + 2);
                    possibleYMoves.add(yTile - 1);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(xTile + 2);
                        Piece.allPossibleYMovesWhite.add(yTile - 1);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(xTile + 2);
                        Piece.allPossibleYMovesBlack.add(yTile - 1);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
            }
        }
        if (xTile - 2 >= 0 && yTile + 1 <= 7) {
            for (int i = 0; i < Main.pieces.size(); i++) {
                if (Main.pieces.get(i).xTile == xTile - 2 && Main.pieces.get(i).yTile == yTile + 1) {
                    if (Main.pieces.get(i).colour != colour) {
                        possibleXMoves.add(xTile - 2);
                        possibleYMoves.add(yTile + 1);
                        if (colour == true) {
                            Piece.allPossibleXMovesWhite.add(xTile - 2);
                            Piece.allPossibleYMovesWhite.add(yTile + 1);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        } else {
                            Piece.allPossibleXMovesBlack.add(xTile - 2);
                            Piece.allPossibleYMovesBlack.add(yTile + 1);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                    i = Main.pieces.size();
                } else if (i == Main.pieces.size() - 1) {
                    possibleXMoves.add(xTile - 2);
                    possibleYMoves.add(yTile + 1);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(xTile - 2);
                        Piece.allPossibleYMovesWhite.add(yTile + 1);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(xTile - 2);
                        Piece.allPossibleYMovesBlack.add(yTile + 1);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
            }
        }
        if (xTile - 2 >= 0 && yTile - 1 >= 0) {
            for (int i = 0; i < Main.pieces.size(); i++) {
                if (Main.pieces.get(i).xTile == xTile - 2 && Main.pieces.get(i).yTile == yTile - 1) {
                    if (Main.pieces.get(i).colour != colour) {
                        possibleXMoves.add(xTile - 2);
                        possibleYMoves.add(yTile - 1);
                        if (colour == true) {
                            Piece.allPossibleXMovesWhite.add(xTile - 2);
                            Piece.allPossibleYMovesWhite.add(yTile - 1);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        } else {
                            Piece.allPossibleXMovesBlack.add(xTile - 2);
                            Piece.allPossibleYMovesBlack.add(yTile - 1);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                    i = Main.pieces.size();
                } else if (i == Main.pieces.size() - 1) {
                    possibleXMoves.add(xTile - 2);
                    possibleYMoves.add(yTile - 1);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(xTile - 2);
                        Piece.allPossibleYMovesWhite.add(yTile - 1);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(xTile - 2);
                        Piece.allPossibleYMovesBlack.add(yTile - 1);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
            }
        }
        if (xTile + 1 <= 7 && yTile + 2 <= 7) {
            for (int i = 0; i < Main.pieces.size(); i++) {
                if (Main.pieces.get(i).xTile == xTile + 1 && Main.pieces.get(i).yTile == yTile + 2) {
                    if (Main.pieces.get(i).colour != colour) {
                        possibleXMoves.add(xTile + 1);
                        possibleYMoves.add(yTile + 2);
                        if (colour == true) {
                            Piece.allPossibleXMovesWhite.add(xTile + 1);
                            Piece.allPossibleYMovesWhite.add(yTile + 2);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        } else {
                            Piece.allPossibleXMovesBlack.add(xTile + 1);
                            Piece.allPossibleYMovesBlack.add(yTile + 2);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                    i = Main.pieces.size();
                } else if (i == Main.pieces.size() - 1) {
                    possibleXMoves.add(xTile + 1);
                    possibleYMoves.add(yTile + 2);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(xTile + 1);
                        Piece.allPossibleYMovesWhite.add(yTile + 2);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(xTile + 1);
                        Piece.allPossibleYMovesBlack.add(yTile + 2);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
            }
        }
        if (xTile + 1 <= 7 && yTile - 2 >= 0) {
            for (int i = 0; i < Main.pieces.size(); i++) {
                if (Main.pieces.get(i).xTile == xTile + 1 && Main.pieces.get(i).yTile == yTile - 2) {
                    if (Main.pieces.get(i).colour != colour) {
                        possibleXMoves.add(xTile + 1);
                        possibleYMoves.add(yTile - 2);
                        if (colour == true) {
                            Piece.allPossibleXMovesWhite.add(xTile + 1);
                            Piece.allPossibleYMovesWhite.add(yTile - 2);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        } else {
                            Piece.allPossibleXMovesBlack.add(xTile + 1);
                            Piece.allPossibleYMovesBlack.add(yTile - 2);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                    i = Main.pieces.size();
                } else if (i == Main.pieces.size() - 1) {
                    possibleXMoves.add(xTile + 1);
                    possibleYMoves.add(yTile - 2);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(xTile + 1);
                        Piece.allPossibleYMovesWhite.add(yTile - 2);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(xTile + 1);
                        Piece.allPossibleYMovesBlack.add(yTile - 2);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
            }
        }
        if (xTile - 1 >= 0 && yTile + 2 <= 7) {
            for (int i = 0; i < Main.pieces.size(); i++) {
                if (Main.pieces.get(i).xTile == xTile - 1 && Main.pieces.get(i).yTile == yTile + 2) {
                    if (Main.pieces.get(i).colour != colour) {
                        possibleXMoves.add(xTile - 1);
                        possibleYMoves.add(yTile + 2);
                        if (colour == true) {
                            Piece.allPossibleXMovesWhite.add(xTile - 1);
                            Piece.allPossibleYMovesWhite.add(yTile + 2);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        } else {
                            Piece.allPossibleXMovesBlack.add(xTile - 1);
                            Piece.allPossibleYMovesBlack.add(yTile + 2);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                    i = Main.pieces.size();
                } else if (i == Main.pieces.size() - 1) {
                    possibleXMoves.add(xTile - 1);
                    possibleYMoves.add(yTile + 2);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(xTile - 1);
                        Piece.allPossibleYMovesWhite.add(yTile + 2);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(xTile - 1);
                        Piece.allPossibleYMovesBlack.add(yTile + 2);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
            }
        }
        if (xTile - 1 >= 0 && yTile - 2 >= 0) {
            for (int i = 0; i < Main.pieces.size(); i++) {
                if (Main.pieces.get(i).xTile == xTile - 1 && Main.pieces.get(i).yTile == yTile - 2) {
                    if (Main.pieces.get(i).colour != colour) {
                        possibleXMoves.add(xTile - 1);
                        possibleYMoves.add(yTile - 2);
                        if (colour == true) {
                            Piece.allPossibleXMovesWhite.add(xTile - 1);
                            Piece.allPossibleYMovesWhite.add(yTile - 2);
                            Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                        } else {
                            Piece.allPossibleXMovesBlack.add(xTile - 1);
                            Piece.allPossibleYMovesBlack.add(yTile - 2);
                            Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                        }
                    }
                    i = Main.pieces.size();
                } else if (i == Main.pieces.size() - 1) {
                    possibleXMoves.add(xTile - 1);
                    possibleYMoves.add(yTile - 2);
                    if (colour == true) {
                        Piece.allPossibleXMovesWhite.add(xTile - 1);
                        Piece.allPossibleYMovesWhite.add(yTile - 2);
                        Piece.allPossibleMovePieceNumsWhite.add(pieceNum);
                    } else {
                        Piece.allPossibleXMovesBlack.add(xTile - 1);
                        Piece.allPossibleYMovesBlack.add(yTile - 2);
                        Piece.allPossibleMovePieceNumsBlack.add(pieceNum);
                    }
                }
            }
        }
    }
}
