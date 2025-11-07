package lesson05.quiz;

import lombok.Data;

@Data
public class Team implements Markable{
    private String name;
    private int score = 0;

    @Override
    public void mark(boolean isCorrect) {
        if(isCorrect)
            score++;
    }
}
