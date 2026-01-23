package exercism.bowling;

import java.util.ArrayList;

public class BowlingGame {
    private ArrayList<Frame> frames;
    private Frame extraFrame;
    private int score = 0;
    private int currentFrameIndex = 0;

    public BowlingGame() {
        this.frames = new ArrayList<Frame>(10);
        this.extraFrame = new Frame();
        for (int i = 0; i < 10; i++) {
            this.frames.add(new Frame());
        }
    }
    public void roll(int pins){
        Frame currentFrame = this.frames.get(this.currentFrameIndex);
        currentFrame.roll(pins);

        if (currentFrame.isDone() && this.currentFrameIndex < 10) {
            this.currentFrameIndex++;
        }
    }

    public int score(){
        for (int i = 0; i < 10; i++){
            Frame f = this.frames.get(i);
            if (i == 9){
                f.calcScore(this.extraFrame);
            } else {
                f.calcScore(this.frames.get(i+1));
            }
            this.score += f.getScore();
        }
        return this.score;
    }

    public String toString(){
        StringBuilder rollsLine = new StringBuilder();
        StringBuilder scoresLine = new StringBuilder();
        for (Frame f: this.frames){
            rollsLine.append(f.getDisplayRoll1()).append(" : ").append(f.getDisplayRoll2()).append(" | ");
        }
        return rollsLine + System.lineSeparator() + scoresLine;
    }
    
}
