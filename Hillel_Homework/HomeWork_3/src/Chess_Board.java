public class Chess_Board {
    public static void main(String[] args) {

        char[][] board = new char[8][8];
        for (int i = 0; i <= board[0].length - 1; i++) {

            for (int j = 0; j <= board[1].length - 1; j++) {

                if ((i + j) % 2 == 0) {
                    board[i][j] = 'W';
                }else{
                    board[i][j] = 'B';
                }
                System.out.print( " " + board[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

}
