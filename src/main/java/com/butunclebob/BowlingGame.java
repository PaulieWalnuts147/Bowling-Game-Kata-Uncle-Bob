package com.butunclebob;

public class BowlingGame {

    int rolls[] = new int [21];
    int currentRolls = 0;

    public void roll(int pinsKnockedOver) {
        rolls[currentRolls++] = pinsKnockedOver;
    }

    public int getScore() {
        int score = 0;
        int i = 0;
        for (int frame = 0; frame < 10; frame ++) {
            if (isStrike(i)) {
                score += 10 + getStrikeBonus(i);
                i++;
            }
            else if (isSpare(i)) {
                score += 10 + getSpareBonus(i);
                i += 2;
            } else {
                score += getTotalFrameScore(i);
                i += 2;
            }
        }
        return score;
    }

    private boolean isSpare(int i) {
        return getTotalFrameScore(i) == 10;
    }

    private boolean isStrike(int i) {
        return getFirstRollOfFrameScore(i) == 10;
    }


    private int getFirstRollOfFrameScore(int i) {
        return rolls[i];
    }

    private int getTotalFrameScore(int i) {
        return rolls[i] + rolls[i + 1];
    }

    private int getStrikeBonus(int i) {
        return rolls[i + 1] + rolls[i + 2];
    }

    private int getSpareBonus(int i) {
        return rolls[i + 2];
    }

}
