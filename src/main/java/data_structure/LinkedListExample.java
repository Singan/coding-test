package data_structure;

public class LinkedListExample {
    public static void main(String[] args) {

        LinkList linkList = new LinkList();
        linkList.insertAt(0,"0번 입니다.");
        linkList.insertAt(1,"1번 입니다.");
        linkList.insertAt(2,"2번 입니다.");
        linkList.insertAt(3,"3번 입니다.");
        linkList.printAll();
    }
    private static class LinkList{
        int count;
        Node head; //0번의 노드
        public LinkList() {
            count = 0;
            head = null;
        }
        public void deleteAll(){
            head = null;
            count = 0;
        }
        public void insertAt(int index, Object data){
            if(count<index|| index<0){
                throw new IndexOutOfBoundsException("인덱스 범위 초과");
            }
            Node n = new Node(data); // 삽입될 새로운 노드 객체
            if(index==0){ // 인덱스가 0 일 경우
                n.nextNode = head;
                head = n;
            }else{
                Node findNode = head;
                for (int i = 0; i < index-1; i++) {//삽입되어야 할 자리의 앞 노드를 찾는 작업
                    findNode = findNode.nextNode;
                }
                n.nextNode = findNode.nextNode; // 삽입될 노드의 다음 노드를 현재 넣고 싶은 인덱스 자리에 있는 노드로 지정
                findNode.nextNode= n; // 자신을 가르키게 될 노드를 지정
            }
            count++;
        }
        public void printAll(){
            Node n = head;
            for (int i = 0; i < count; i++) {
                System.out.println(n.data);
                n= n.nextNode;
            }
        }
    }
    private static class Node{
        Object data;
        Node nextNode;

        public Node(Object data) {
            this.data = data;
        }
    }
}
