package com.example.screenstuff;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Interface extends Application {
    private Stage primaryStage;
    private PlayerNameScreen playerNameScreen;
    private PlayScreen playScreen;
    private StartScreen startScreen;
    private LoadScreen loadScreen;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;

        //Create instances of the screen handling classes and attach this interface instance to those classes.
        playerNameScreen = new PlayerNameScreen(this);
        playScreen = new PlayScreen(this);
        startScreen = new StartScreen(this);
        loadScreen = new LoadScreen(this);


        stage.setTitle("Gorpu Chess!");
        stage.setScene(startScreen.getStartScreen());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public Stage getStage() {
        return primaryStage;
    }

    /**
     * Intended to send the coordinates of the clicked tile to the backend. Currently the playground to test chessboard
     * features.
     * @param column
     * @param row
     */
    public void click(int column, int row) {
        ArrayList<Integer> validTileOne = new ArrayList<>();

        if(column == 0 && row == 0) playScreen.updatePlayScreen("r1b1k1nr/p2p1pNp/n2B4/1p1NP2P/6P1/3P1Q2/P1P1K3/q5b1 w KQkq - 0 1");

        else if(column == 0 && row == 7) playScreen.updatePlayScreen("8/8/8/4p1K1/2k1P3/8/8/8 b - - 0 1");

        else if(column == 7 && row == 0) playScreen.updatePlayScreen("4k2r/6r1/8/8/8/8/3R4/R3K3 w Qk - 0 1");

        else if(column == 7 && row == 7) playScreen.updatePlayScreen("rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR b KQkq e3 0 1");

        else playScreen.updatePlayScreen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");



        System.out.println(column);
        System.out.println(row);
    }

    public void toMenu() {
        primaryStage.setScene(startScreen.getStartScreen());
    }

    public void toPNScreen() {
        primaryStage.setScene(playerNameScreen.getScene());
    }

    public void toChessboard() {
        primaryStage.setScene(playScreen.getScene());
    }

    public void toNewChessboard(String whiteName, String blackName) {
        playScreen.setWhitePlayerName(whiteName);
        playScreen.setBlackPlayerName(blackName);
        playScreen.updatePlayScreen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        primaryStage.setScene(playScreen.getScene());
    }

    /**
     * Switch scene displayed to a scene that displays all the finished games to view through.
     */
    public void loadFGames() {
        //loadScreen.populateButtonBar(list of finished games);
        loadScreen.setLabel("Finished Games:");
        primaryStage.setScene(loadScreen.getScene());
    }

    /**
     * Switch the scene displayed to a scene that displays all the unfinished games to pick back up from.
     */
    public void loadUFGames() {
        //loadScreen.populateButtonBar(list of unfinished games);
        loadScreen.setLabel("Unfinished Games:");
        primaryStage.setScene(loadScreen.getScene());
    }
}