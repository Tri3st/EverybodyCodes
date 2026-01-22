package exercism.bowling;

import java.util.ArrayList;

public class BowlingGame {
    private ArrayList<Frame> frames;
    private int score = 0;
    private int currentFrameIndex = 0;

    public BowlingGame() {
        this.frames = new ArrayList<Frame>(11);
        for (int i = 0; i < 11; i++) {
            this.frames.add(new Frame());
        }
    }
    public void roll(int pins){
        Frame currentFrame = this.frames.get(this.currentFrameIndex);
        currentFrame.roll(pins);
        this.score += pins;

        if (currentFrame.isDone() && this.currentFrameIndex < 10) {
            this.currentFrameIndex++;
        }
    }

    public int score(){
        return this.score;
    }
    
}
