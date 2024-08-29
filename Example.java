class Main extends App {
    Vector2 chaserPosition;
    double time;

    void setup() {
        chaserPosition = new Vector2();
        time = 0.0;
    }

    void loop() {
        if (!keyToggled('P')) { time += 0.0167; }
        if (mouseHeld) {
            chaserPosition = chaserPosition.plus(Vector2.directionVectorFrom(chaserPosition, mousePosition));
        }
        drawLine(chaserPosition, mousePosition, Vector3.white);
        drawCircle(chaserPosition, 2.0, Vector3.rainbowSwirl(time));
        drawCenterRectangle(mousePosition, new Vector2(4.0), Vector3.cyan);
    }

    public static void main(String[] arguments) {
        App app = new Main();
        app.setWindowBackgroundColor(Vector3.black);
        app.setWindowSizeInWorldUnits(64.0, 64.0);
        app.setWindowCenterInWorldUnits(0.0, 0.0);
        app.setWindowHeightInPixels(512);
        app.setWindowTopLeftCornerInPixels(64, 64);
        app.run();
    }
}