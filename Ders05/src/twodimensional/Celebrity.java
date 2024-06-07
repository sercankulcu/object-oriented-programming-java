package twodimensional;
/*
 * Here is a Java program that determines whether there is a celebrity in a group of people, 
 * and if so, returns their index:
 * 
 * This program uses two pointers to iterate through the knows array, starting at the beginning 
 * and end, respectively. At each step, it moves the pointers inwards if the person at the left 
 * knows the person at the right, or vice versa. This way, it narrows down the potential 
 * celebrity to a single person.
 * */

public class Celebrity {
  // A celebrity is defined as a person who is known by everyone, but does not know anyone else
  public static int findCelebrity(int[][] knows) {
    // Edge case: return -1 if the array is empty or has fewer than 2 elements
    if (knows == null || knows.length < 2) {
      return -1;
    }

    // Initialize two pointers, left and right, to the start and end of the array, respectively
    int left = 0;
    int right = knows.length - 1;

    // Iterate while the pointers have not crossed
    while (left < right) {
      // If person at left knows person at right, move left pointer to the right
      if (knows[left][right] == 1) {
        left++;
      }
      // Otherwise, move right pointer to the left
      else {
        right--;
      }
    }

    // At this point, left and right should be pointing to the same person, who may or may not be the celebrity
    // Check if this person is a celebrity
    for (int i = 0; i < knows.length; i++) {
      // If this person knows someone, or someone doesn't know them, they are not a celebrity
      if (i != left && (knows[left][i] == 1 || knows[i][left] == 0)) {
        return -1;
      }
    }

    // If all checks pass, return the index of the celebrity
    return left;
  }
  
  public static void main(String[] args) {
    int[][] knows = {
      {0, 1, 0, 1},
      {0, 0, 1, 1},
      {0, 0, 0, 1},
      {0, 0, 0, 0}
    };
    int celebrity = Celebrity.findCelebrity(knows);
    if (celebrity == -1) {
      System.out.println("There is no celebrity.");
    } else {
      System.out.println("Celebrity found at index " + celebrity + ".");
    }
  }
}
