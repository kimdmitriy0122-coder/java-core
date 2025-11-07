package lesson05.quiz;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Data
public class Quiz {
    private List<Team> teamList = new ArrayList<>();
    private List<Question> questionList = new ArrayList<>();
    private Map<Question, Map<Team, Boolean>> questionMap = new HashMap<>();

    public void addTeam(Team team) {
        teamList.add(team);
    }

    public void addQuestion(Question question) {
        questionList.add(question);
    }

    public void addQuestion(String question, String answer) {
        Question q = new Question();
        q.setQuestion(question);
        q.setAnswer(answer);
        questionList.add(q);
    }

    public void launchQuiz(){
        Scanner scanner = new Scanner(System.in);
        if(teamList.isEmpty())
            throw new NullPointerException("Team list is empty");
        if(questionList.isEmpty())
            throw new NullPointerException("Question list is empty");
        for(Question q : questionList){
            Map<Team, Boolean> map = new HashMap<>();
            System.out.println("внимание, вопрос. " + q.getQuestion());
            for(Team t : teamList){
                System.out.println("введите ответ для команды " + t.getName());
                q.setAnswer(scanner.nextLine());
                map.put(t, isCorrect(q));
            }
            questionMap.put(q, map);
        }
    }

    public boolean isCorrect(Question q){
        return q.getAnswer().equals(q.getAnswer());
    }

    public Team getWinner(){
        for(Map<Team, Boolean> m : questionMap.values()){
            m.entrySet().stream().forEach(entry -> entry.getKey().mark(entry.getValue()));
        }
        teamList.sort((a,b) -> a.getScore() > b.getScore() ? 1 : -1);
        return teamList.get(0);
    }
}
