package exercism.bowling;

public class Frame {
    private Roll[] rolls = new Roll[2];
    private boolean done = false;
    private FrameType type = FrameType.NONE;
    private int score;

    public Frame(){
        this.rolls[0] = new Roll();
        this.rolls[1] = new Roll();
        this.score = 0;
    }

    public void roll(int pins){
        if (!this.done) {
            this.rolls[0].roll(pins);
            this.score += pins;
        } else {
            this.rolls[1].roll(pins);
            this.done = true;
            this.score += pins;
        }
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

    public boolean isDone(){
        return this.done;
    }
}
