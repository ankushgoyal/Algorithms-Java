import java.util.*;

import datastrs.ArrayListOnSteroids;

/**
 * Problem: Scheduling Problem
 * Input: A set I of n intervals on the line.
 * Output: What is the largest subset of mutually non-overlapping intervals which can be selected from I ?
 * @author agoyal
 *
 */
public class OptimalScheduling {
	
	public List<List<Integer>> findOptimalSchedule(List<List<Integer>> options) {
		List<List<Integer>> optimalSchedule = new ArrayList<List<Integer>>();
		
		while (options.size() > 0) {
			int earliestOption = findEarliestCompletionDate(options);
			optimalSchedule.add(options.get(earliestOption));
			removeNonDisjoint(options, earliestOption);
		}
		
		return optimalSchedule;
	}
	
	public int findEarliestCompletionDate(List<List<Integer>> options) {
		int index = 0;
		List<Integer> earliestOption = options.get(0);
		for(int i = 0; i < options.size(); i++) {
			List<Integer> option = options.get(i);
			if(option.get(1) < earliestOption.get(1)) {
				earliestOption = option;
				index = i;
			}
		}
		return index;
	}
	
	public void removeNonDisjoint(List<List<Integer>> options, int index) {
		List<Integer> earliestOption = options.get(index);
		List<Integer> indicesToRemove = new ArrayList<Integer>();
		
		for(int i = 0; i < options.size(); i++) {
			if (isDisjoint(earliestOption, options.get(i)))
				continue;
			indicesToRemove.add(i);
		}
		
		Collections.sort(indicesToRemove, Collections.reverseOrder());
		
		for(int i : indicesToRemove) {
			options.remove(i);
		}
	}
	
	public boolean isDisjoint(List<Integer> one, List<Integer> two) {
		return (one.get(1) < two.get(0) || one.get(0) > two.get(1));
	}
	
	public static void main(String[] args) {
		OptimalScheduling os = new OptimalScheduling();
		List<List<Integer>> options = new ArrayList<List<Integer>>();
		options.add(new ArrayListOnSteroids<Integer>().addItem(2).addItem(25));
		options.add(new ArrayListOnSteroids<Integer>().addItem(3).addItem(6));
		options.add(new ArrayListOnSteroids<Integer>().addItem(17).addItem(21));
		options.add(new ArrayListOnSteroids<Integer>().addItem(4).addItem(12));
		options.add(new ArrayListOnSteroids<Integer>().addItem(15).addItem(25));
		
		System.out.println(os.findOptimalSchedule(options));
	}
	
}
