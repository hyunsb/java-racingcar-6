package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.game.GameResultDto;
import racingcar.domain.game.RacingGame;
import racingcar.domain.game.Rounds;
import racingcar.domain.random.GameRandomNumberGenerator;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {

    public void play() {
        RacingGame racingGame = this.generateNewRacingGame();
        while (!racingGame.isEnd()) {
            racingGame.race();
        }
        GameResultDto result = racingGame.getResult();
        OutputView.printResult(result);
    }

    private RacingGame generateNewRacingGame() {
        List<String> names = InputView.inputCarNames();
        RandomNumberGenerator randomNumberGenerator = new GameRandomNumberGenerator();
        Cars cars = Cars.createBy(names, randomNumberGenerator);

        int inputRounds = InputView.inputRounds();
        Rounds rounds = new Rounds(inputRounds);

        return new RacingGame(cars, rounds);
    }
}
