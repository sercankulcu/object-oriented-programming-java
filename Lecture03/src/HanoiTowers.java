/*
 * Here is a Java code that can be used to solve the Tower of Hanoi puzzle and print the 
 * solution to the console:
 * 
 * This code uses a recursive algorithm to solve the Tower of Hanoi puzzle. The basic idea is 
 * to move the top numDisks - 1 disks from the fromPeg to the auxPeg using the toPeg as the 
 * auxiliary peg, then move the remaining disk from the fromPeg to the toPeg, and finally move 
 * the numDisks - 1 disks from the auxPeg to the toPeg using the fromPeg as the auxiliary peg.
 * 
 * */

public class HanoiTowers {

    public static final int NUM_DISKS = 3;

    public static void main(String[] args) {
        // solve the puzzle using the recursive algorithm
        solveTowerOfHanoi(NUM_DISKS, 'A', 'B', 'C');
    }

    public static void solveTowerOfHanoi(int numDisks, char fromPeg, char toPeg, char auxPeg) {
        if (numDisks == 1) {
            // move the top disk from the fromPeg to the toPeg
            System.out.println("Move disk " + numDisks + " from peg " + fromPeg + " to peg " + toPeg);
        } else {
            // move the top numDisks - 1 disks from the fromPeg to the auxPeg using the toPeg as the auxiliary peg
            solveTowerOfHanoi(numDisks - 1, fromPeg, auxPeg, toPeg);
            // move the remaining disk from the fromPeg to the toPeg
            System.out.println("Move disk " + numDisks + " from peg " + fromPeg + " to peg " + toPeg);
            // move the numDisks - 1 disks from the auxPeg to the toPeg using the fromPeg as the auxiliary peg
            solveTowerOfHanoi(numDisks - 1, auxPeg, toPeg, fromPeg);
        }
    }

}
