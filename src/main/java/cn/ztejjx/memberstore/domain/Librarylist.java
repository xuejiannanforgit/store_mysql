package cn.ztejjx.memberstore.domain;

public class Librarylist {

    private String  content;

    private int score;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Librarylist{" +
                "content='" + content + '\'' +
                ", score=" + score +
                '}';
    }
}
