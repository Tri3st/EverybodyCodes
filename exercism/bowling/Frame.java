package exercism.bowling;

public class Frame {
    private Roll[] rolls = new Roll[2];
    private int rollIndex;
    private FrameType type = FrameType.NONE;
    private int score;

    public Frame(){
        this.rolls[0] = new Roll();
        this.rolls[1] = new Roll();
        this.score = 0;
        this.rollIndex = 0;
    }

    public void roll(int pins){
        if (this.rollIndex == 0) {
            if (pins == 10) this.type = FrameType.STRIKE;
            this.rolls[0].roll(pins);
            this.score += pins;
            this.rollIndex++;
            return;
        } else if (this.rollIndex == 1){
            if (this.rolls[0].getRoll() + pins == 10) this.type = FrameType.SPARE;
            this.rolls[1].roll(pins);
            this.score += pins;
            this.rollIndex++;
        }
        return;
    }

    public FrameType getType() {
        return type;
    }

    public void setType(FrameType type) {
        this.type = type;
    }

    public int getStrikeScore(){
        return this.rolls[0].getRoll() + this.rolls[1].getRoll();
    }

    public int getSpareScore(){
        return this.rolls[0].getRoll();
    }

    public int getScore() {
        return score;
    }

    public void calcScore(Frame nextFrame){
        if (this.type == FrameType.STRIKE){
            this.score += nextFrame.getStrikeScore();
        } else if (this.type == FrameType.SPARE) {
            this.score += nextFrame.getSpareScore();
        }
    }

    public boolean isDone(){
        return this.rollIndex > 1;
    }

    @Override
    public String toString() {
        return "%s | %s | %d".formatted(this.getDisplayRoll1(), this.getDisplayRoll2(), this.score);
    }

    public String getDisplayRoll1() {
        int first = this.rolls[0].getRoll();
        if (first == 10) {
            return FrameType.STRIKE.toString();
        }
        return String.valueOf(first);
    }

    public String getDisplayRoll2() {
        int first = this.rolls[0].getRoll();
        int second = this.rolls[1].getRoll();
        if (first == 10) {
            return FrameType.NONE.toString();
        }
        if (first + second == 10) {
            return FrameType.SPARE.toString();
        }
        return String.valueOf(second);
    }
}
