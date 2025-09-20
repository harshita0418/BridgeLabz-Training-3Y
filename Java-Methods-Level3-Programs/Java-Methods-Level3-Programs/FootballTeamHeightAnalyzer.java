class FootballTeam {
    private int[] heights;
    private int teamSize;
    
    public FootballTeam(int teamSize) {
        this.teamSize = teamSize;
        this.heights = new int[teamSize];
        generateRandomHeights();
    }
    
    private void generateRandomHeights() {
        for (int i = 0; i < teamSize; i++) {
            heights[i] = (int) (Math.random() * 101) + 150;
        }
    }
    
    public int findSum() {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }
    
    public double findMeanHeight() {
        return (double) findSum() / teamSize;
    }
    
    public int findShortestHeight() {
        int shortest = heights[0];
        for (int height : heights) {
            if (height < shortest) {
                shortest = height;
            }
        }
        return shortest;
    }
    
    public int findTallestHeight() {
        int tallest = heights[0];
        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }
        return tallest;
    }
    
    public void displayResults() {
        System.out.println("Football Team Heights Analysis");
        System.out.print("Heights: ");
        for (int height : heights) {
            System.out.print(height + " ");
        }
        System.out.println();
        System.out.println("Sum of heights: " + findSum());
        System.out.println("Mean height: " + findMeanHeight() + " cm");
        System.out.println("Shortest height: " + findShortestHeight() + " cm");
        System.out.println("Tallest height: " + findTallestHeight() + " cm");
    }
}

public class FootballTeamHeightAnalyzer {
    public static void main(String[] args) {
        FootballTeam team = new FootballTeam(11);
        team.displayResults();
    }
}
