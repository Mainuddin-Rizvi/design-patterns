// State Interface
interface State {
    void play(MediaPlayer context);
    void pause(MediaPlayer context);
    void stop(MediaPlayer context);
}

// Concrete State Class for Playing State
class PlayingState implements State {
    @Override
    public void play(MediaPlayer context) {
        System.out.println("Already playing.");
    }

    @Override
    public void pause(MediaPlayer context) {
        System.out.println("Pausing the media player.");
        context.setState(new PausedState());
    }

    @Override
    public void stop(MediaPlayer context) {
        System.out.println("Stopping the media player.");
        context.setState(new StoppedState());
    }
}

// Concrete State Class for Paused State
class PausedState implements State {
    @Override
    public void play(MediaPlayer context) {
        System.out.println("Resuming the media player.");
        context.setState(new PlayingState());
    }

    @Override
    public void pause(MediaPlayer context) {
        System.out.println("Already paused.");
    }

    @Override
    public void stop(MediaPlayer context) {
        System.out.println("Stopping the media player.");
        context.setState(new StoppedState());
    }
}

// Concrete State Class for Stopped State
class StoppedState implements State {
    @Override
    public void play(MediaPlayer context) {
        System.out.println("Starting the media player.");
        context.setState(new PlayingState());
    }

    @Override
    public void pause(MediaPlayer context) {
        System.out.println("Cannot pause. The media player is stopped.");
    }

    @Override
    public void stop(MediaPlayer context) {
        System.out.println("Already stopped.");
    }
}

// Context Class
class MediaPlayer {
    private State currentState;

    public MediaPlayer() {
        // Initial state of the media player
        this.currentState = new StoppedState();
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void play() {
        currentState.play(this);
    }

    public void pause() {
        currentState.pause(this);
    }

    public void stop() {
        currentState.stop(this);
    }
}

// Client
public class StatePattern{
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayer();

        mediaPlayer.play();  // Starting the media player.
        mediaPlayer.pause(); // Pausing the media player.
        mediaPlayer.stop();  // Stopping the media player.

        mediaPlayer.pause(); // Cannot pause. The media player is stopped.
        mediaPlayer.play();  // Starting the media player.
        mediaPlayer.stop();  // Stopping the media player.
    }
}
