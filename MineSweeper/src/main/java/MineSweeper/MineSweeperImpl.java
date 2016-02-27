package MineSweeper;

/**
 * Created by Piotr Dorman on 2016-02-27.
 */
public class MineSweeperImpl implements MineSweeper{
    private int N,M;
    private String[] mineFieldTab;
    String mineField;
    public void setMineField(String mineField)
    {
        this.mineField=mineField;
        if(mineField.matches("[.*\n]+")) {
            N = (mineField.length() - mineField.replace("\n", "").length()) + 1;
            mineFieldTab = mineField.split("\\n");
            M = mineFieldTab[0].length();
            for(int i=1;i<N;i++)
            {
                if(mineFieldTab[i].length()!=M)
                    throw new IllegalArgumentException();
            }
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
    public String getHintField()
    {
        if(mineField==null)
            throw new IllegalStateException();
        StringBuilder tmp=new StringBuilder();
        int hint=-1;
        for(int i=0;i<N;i++) {
            for (int j = 0; j < M; j++) {
                if (mineFieldTab[i].charAt(j) != '*') {
                    hint = getHint(j, i, mineFieldTab);
                    tmp.append(Integer.toString(hint));
                } else {
                    tmp.append("*");
                }
            }
            if(i!=N-1)
            tmp.append("\\n");
        }
        return tmp.toString();
    }

    private int getHint(int i, int j, String[] mineFieldTab)
    {
        int tmp_i=i;
        int tmp_j=j;
        if(tmp_i!=0)
            tmp_i=i-1;
        if(tmp_j!=0)
            tmp_j=j-1;
        int mines = 0;
        for(int k=tmp_j;k<j+2;k++)
        {
            if(k>=N)
                break;
            for(int l=tmp_i;l<i+2;l++)
            {
                if(l>=M)
                    break;
                if(mineFieldTab[k].charAt(l)=='*')
                    mines++;
            }
        }
        return mines;
    }
}
