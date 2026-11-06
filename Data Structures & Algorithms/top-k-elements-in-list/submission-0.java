

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Store top K pairs
        int[] top = new int[2 * k];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int frequency = entry.getValue();
            int number = entry.getKey();

            for (int j = 0; j < k; j++) {

                int freqIndex = j * 2;
                int numIndex = freqIndex + 1;

                if (frequency > top[freqIndex]) {

                    // Shift previous pairs to the right
                    for (int x = k - 1; x > j; x--) {
                        top[x * 2] = top[(x - 1) * 2];
                        top[x * 2 + 1] = top[(x - 1) * 2 + 1];
                    }

                    top[freqIndex] = frequency;
                    top[numIndex] = number;

                    break;
                }
            }
        }

        // Step 3: Extract numbers
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = top[i * 2 + 1];
        }

        return result;
    }
}

