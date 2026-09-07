import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int low = 1;
        int high = position[position.length - 1] - position[0];
        int ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canPlace(position, m, mid)) {
                ans = mid;        // Try to find a larger minimum force
                low = mid + 1;
            } else {
                high = mid - 1;   // Reduce the target force
            }
        }
        
        return ans;
    }
    
    private boolean canPlace(int[] position, int m, int minForce) {
        int count = 1; // Place the first ball in the first basket
        int lastPos = position[0];
        
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= minForce) {
                count++;
                lastPos = position[i];
                
                if (count >= m) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
