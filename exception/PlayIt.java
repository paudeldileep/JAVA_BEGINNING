import javax.sound.midi.*;

public class PlayIt {
    public void play() {
        try {
            Sequencer player = MidiSystem.getSequencer();
            System.out.println("Got a sequencer");
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            player.setSequence(seq);

            player.start();

        } catch (MidiUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PlayIt play1 = new PlayIt();
        play1.play();
    }
}
