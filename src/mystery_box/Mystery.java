package mystery_box;

/*
  The String class in Java is my favourite example of
   good adherence to the SRP

  String encapsulates a design decision,
   namely: what should the low-level representation of string be?

  And makes it so that nobody else has to think about that ever.
 */

public class Mystery {
    String s =" łðªσ→œ";
    // What does this method do?
    int scoreBowlingSeries(int[] l) {
        int totalScore = 0;
        int currentRoll = 0;
        for (int currentFrame = 0; currentFrame < 10; currentFrame++) {
            if (isStrike(l[currentRoll])) {
                totalScore += 10 + (l[currentRoll + 1] + l[currentRoll + 2]);
                currentRoll += 1;
            } else if (l[currentRoll] + l[currentRoll + 1] == 10) {
                totalScore += 10 + l[currentRoll + 2];
                currentRoll += 2;
            } else {
                totalScore += l[currentRoll] + l[currentRoll + 1];
                currentRoll += 2;
            }
        }
        return totalScore;
    }

    boolean isStrike(int pinsFelled) { return pinsFelled == 10; }
}