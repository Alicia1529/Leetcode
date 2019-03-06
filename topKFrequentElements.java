class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int each:nums){
            map.put(each,map.getOrDefault(each,0)+1);
        }
        List<Integer> value = new ArrayList<Integer>(map.values());
        List<Integer> ans = new ArrayList<Integer>();
        Collections.sort(value,Collections.reverseOrder());
        int flag = value.get(k-1);
        for (int each:map.keySet()){
            if (map.get(each)>=flag){
                ans.add(each);
            }
        }
        return ans;
    }
}



//bucket sort
public List<Integer> topKFrequent(int[] nums, int k) {

	List<Integer>[] bucket = new List[nums.length + 1];
	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

	for (int n : nums) {
		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
	}

	for (int key : frequencyMap.keySet()) {
		int frequency = frequencyMap.get(key);
		if (bucket[frequency] == null) {
			bucket[frequency] = new ArrayList<>();
		}
		bucket[frequency].add(key);
	}

	List<Integer> res = new ArrayList<>();

	for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
		if (bucket[pos] != null) {
			res.addAll(bucket[pos]);
		}
	}
	return res;
}
