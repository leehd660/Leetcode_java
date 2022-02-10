import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        boolean answer = false;
        //set을 만들어서 숫자를 하나씩 넣어보기
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            int size = set.size();
            set.add(i);
            //set에 넣었는데도 사이즈가 같으면, 중복이 있다는 의미임으로 true를 return
            if (size == set.size()) {
                answer = true;
                break;
            }
        }
        return answer;
    }
}
