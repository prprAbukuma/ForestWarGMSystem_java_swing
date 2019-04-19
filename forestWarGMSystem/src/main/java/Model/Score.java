package Model;

public class Score {
    private int id;
    private int uid;
    private int totalCount;
    private int winCount;

    public Score(int id, int uid, int totalCount, int winCount) {
        this.id = id;
        this.uid = uid;
        this.totalCount = totalCount;
        this.winCount = winCount;
    }

    public int getId() {
        return id;
    }

    public int getUid() {
        return uid;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getWinCount() {
        return winCount;
    }
}
