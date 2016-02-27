import MineSweeper.*;

/**
 * Created by Piotr Dorman on 2016-02-27.
 */
public class Main {
    public static void main(String [] args)
    {
        MineSweeper m = new MineSweeperImpl();
        String mineField = "*...\n..*.\n....";
        m.setMineField(mineField);
        System.out.println(m.getHintField());
    }
}
