package STRINGS;

public class _1_ShortestPathNEWS {
    // Given a route containing 4 directions N, E, W, S
    // Find the shortest path to reach destination
    // Initial point = (0, 0)
    // O(n)
    public static void main(String args[]){
        String direction = "WNEENESENNN";
    int x = 0, y = 0;
    for(int i = 0; i<direction.length(); i++)
    {
        if (direction.charAt(i) == 'N')
            y++;
        else if (direction.charAt(i) == 'S')
            y--;
        else if (direction.charAt(i) == 'E')
            x++;
        else
            x--;
    }
    System.out.println("("+x+", "+y+")");
    double distance = Math.sqrt((x*x)+(y*y));
    System.out.println("The shortest distance is = "+distance);
    }
}
