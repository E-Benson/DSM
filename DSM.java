import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DSM {
	private BufferedReader in;
	private static final char[] lang = {'a', 'b', 'c'};
	private static int[] acceptStates = {3, 7};
	private static final int[][] states = {
			{0, 1, 4},
            {2, 1, 4},
            {0, 3, 4},
            {3, 3, 3},
            {6, 5, 8},
            {6, 1, 4},
            {7, 1, 4},
            {7, 7, 7},
            {7, 1, 4}
	};

	public DSM() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	public static void main(String[] args) throws IOException{
    		DSM sm = new DSM();
	    	sm.run();
	}

	public void run() throws IOException {
		while (true) {
            int state = 0;
            System.out.println("Enter a string...");
            char c = (char) in.read();
            boolean valid = false;
            while (c != '\n') {
                valid = (move(state, c) == -1) ? false : true;
                if (valid)
                    state= move(state, c);
                c = (char) in.read();
            }
            valid = (valid) ? true : false;
            System.out.println((valid) ? (isValid(state)) ? "Accepted" : "Rejected" : "No");
		}
	}

	public static int move(int state, char str) {
		for (int i = 0; i < lang.length; i++) {
			if (str == lang[i])
				return (states[state][i]);
		}
		return -1;
	}

	public static boolean isValid(int state) {
		for (int i = 0; i < acceptStates.length; i++) {
			if (state == acceptStates[i])
				return true;
		}
		return false;
	}
}
