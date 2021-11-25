
public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1= new Player(player1Name);
        this.player2= new Player(player2Name);
    }
    private Player playerNamed(String playerName){
        return player1.getName().equals(playerName) ? player1 : player2;
    }
    public void wonPointBy(String playerName) {
        playerNamed(playerName).wonPoint();
    }

    public String getScore() {
        String score;
        int difference = differenceInPoints();
        if (difference==0) {
            if(player1.getPoints()<=2){
                score=pointsToStringOf(player1.getPoints())+"-All";
            }
            else{
                score = "Deuce";
            }
        }
        else if (inAdvantageStage()){
            if (difference==1) score ="Advantage player1";
            else if (difference ==-1) score ="Advantage player2";
            else if (difference>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else {
            score=pointsToStringOf(player1.getPoints())+"-"+pointsToStringOf(player2.getPoints());
        }
        return score;
    }

    private boolean inAdvantageStage() {
        return player1.getPoints()>=4 || player2.getPoints()>=4;
    }

    private int differenceInPoints() {
        return player1.getPoints()-player2.getPoints();
    }
    private String pointsToStringOf(int points){
        String scoreString="";
        switch(points) {
            case 0:
                scoreString="Love";
                break;
            case 1:
                scoreString="Fifteen";
                break;
            case 2:
                scoreString="Thirty";
                break;
            case 3:
                scoreString="Forty";
                break;
        }
        return scoreString;
    }
}