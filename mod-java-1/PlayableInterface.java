interface Playable { void play(); }
class Guitar implements Playable {
    public void play() { System.out.println("Playing Guitar"); }
}
class Piano implements Playable {
    public void play() { System.out.println("Playing Piano"); }
}
public class PlayableInterface {
    public static void main(String[] args) {
        Playable g = new Guitar(), p = new Piano();
        g.play(); p.play();
    }
}
