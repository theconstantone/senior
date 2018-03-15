public class Knight extends Piece {
    public Knight(Board board, Player player) {
        super(board, player);
    }

    public String toString() {//u0482
    	 String cc2 = "1F438";
    	 String text2 = String.valueOf(Character.toChars(Integer.parseInt(cc2, 16)));
    	 String cc1 = "1F439";
    	 String text1 = String.valueOf(Character.toChars(Integer.parseInt(cc1, 16)));
        return getPlayer() == Player.WHITE ? text2 : text1;
    }

    // ------------------------------------------------------------------------
    // Movement
    // ------------------------------------------------------------------------

    /**
     * A knight can move in an `L` shape - two squares horizontally and one square
     * vertically, or one square horizontally and two squares vertically. A knight
     * may not be obstructed by another piece.
     *
     * @param from The source (current) tile.
     * @param to   The destination tile.
     * @return true if the move is valid, false otherwise
     */
    @Override
    public boolean canMove(Tile from, Tile to) {
        int d1 = Math.abs(from.getRank() - to.getRank());
        int d2 = Math.abs(from.getFile() - to.getFile());

        return canMoveOrCapture(to) && ((d1 == 1 && d2 == 0) || ((d1 == 0 && d2 == 1) || (d1 == 3 && d2 == 0) || (d1 == 0 && d2 == 3) ));
    }
}
