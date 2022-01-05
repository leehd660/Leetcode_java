import java.util.ArrayList;
import java.util.List;

public class CloneGraph {
//    처음에는 cloneGraph자체를 재귀함수로 만드려고 했지만, 그러면 전역변수에 list를 만들어야해서 이렇게 구성을 했었음
//    방식 자체는 맞았는데, for문에서 엄청 바보같이 범위 지정 잘못해줘서 모든 노드를 클론하라는 문제가 나타났었음;;;
//    그런데 그렇게 하니까 두번째 함수를 사용할 때, total이 clear되지 않아서 문제가 틀렸음.
//    그래서 total을 함수 내에서 선언하기 위해서는 cloneGraph자체를 재귀함수로 만드는 것은 불가능했음. 따라서 비슷한 재귀함수인 cloneNode 함수를 만들어서 성공

//    static ArrayList<Node> total = new ArrayList<>();

    public Node cloneGraph(Node node) {
        ArrayList<Node> total = new ArrayList<>();
        if (node == null) {
            return null;
        }
        else if (node.neighbors.isEmpty()) {
            Node answer = new Node(node.val);
            return answer;
        }
        else {
            int val = node.val;
            Node answer = new Node(val);
            total.add(answer);
            answer.neighbors = new ArrayList<>();
            for (Node neighbor : node.neighbors) {
                boolean check = false;
                for (int j=0; j<total.size(); j++) {
                    if (total.get(j).val == neighbor.val) {
                        answer.neighbors.add(total.get(j));
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    answer.neighbors.add(cloneNode(neighbor,total));
                }
            }
            return answer;
        }
    }

    static Node cloneNode(Node node, ArrayList<Node> total) {
        if (node == null) {
            return null;
        }
        else if (node.neighbors.isEmpty()) {
            Node answer = new Node(node.val);
            return answer;
        }
        else {
            int val = node.val;
            Node answer = new Node(val);
            total.add(answer);
            answer.neighbors = new ArrayList<>();
            for (Node neighbor : node.neighbors) {
                boolean check = false;
                for (int j=0; j<total.size(); j++) {
                    if (total.get(j).val == neighbor.val) {
                        answer.neighbors.add(total.get(j));
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    answer.neighbors.add(cloneNode(neighbor, total));
                }
            }
            return answer;
        }
    }


}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
