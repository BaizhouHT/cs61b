package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * @Description:
 * @Author: Harrison
 * @Date: 2/27/2024 11:37 AM
 * @Version:
 */
public class GuitarHero {
    private static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static boolean charCheck(char key) {
        return keyboard.indexOf(key) < 0;
    }

    public static void main(String[] args) {
        GuitarString[] grr = new GuitarString[keyboard.length()];
        for (int i = 0; i < keyboard.length(); i++) {
            grr[i] = new GuitarString(440 * Math.pow(2, (i - 24) / 12));
        }
        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (charCheck(key)) {
                    continue;
                }
                grr[keyboard.indexOf(key)].pluck();
            }

            /* compute the superposition of samples */
            double sample = 0.0;
            for (int i = 0; i < keyboard.length(); i++) {
                sample += grr[i].sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < keyboard.length(); i++) {
                grr[i].tic();
            }
        }
    }
}
