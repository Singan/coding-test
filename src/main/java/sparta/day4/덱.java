package sparta.day4;

import java.io.*;

public class 덱 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder builder = new StringBuilder();
        MyDequeue dequeue = new MyDequeue();
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String[] s = br.readLine().split(" ");
            switch (s[0]) {
                case "push_front":
                    dequeue.pushFront(Integer.parseInt(s[1]));
                    break;
                case "push_back":
                    dequeue.pushBack(Integer.parseInt(s[1]));
                    break;
                case "pop_front":
                    builder.append(dequeue.popFront()).append("\n");
                    break;
                case "pop_back":
                    builder.append(dequeue.popBack()).append("\n");
                    break;
                case "size":
                    builder.append(dequeue.size).append("\n");
                    break;
                case "empty":
                    builder.append((dequeue.size == 0 ? 1 : 0)).append("\n");
                    break;
                case "front":
                    builder.append(dequeue.front()).append("\n");
                    break;
                case "back":
                    builder.append(dequeue.back()).append("\n");
                    break;
            }
        }
        bf.write(builder.toString());
        bf.flush();
    }

    static class MyDequeue {
        private Node head;
        private Node tail;
        int size = 0;

        public void pushBack(int value) {
            Node node = new Node(value);
            node.value = value;
            if (size != 0) {
                node.prev = tail;
                tail.next = node;
            } else {
                head = node;
            }
            tail = node;
            size++;
        }

        public void pushFront(int value) {
            Node node = new Node(value);
            node.value = value;
            if (size != 0) {
                node.next = head;
                head.prev = node;
            } else {
                tail = node;
            }
            head = node;
            size++;
        }
        public int popBack() {
            if (tail == null) {  // tail 이 null인 경우
                return -1;
            }

            //마지막 노드를 삭제하고 이전 노드를 마지막 노드로 만들어야 한다.
            //null 이면 size 가 0인 것임으로 -1을 리턴한다.
            int value = tail.value;
            tail = tail.prev; // 마지막 노드 전 노드를 마지막 노드로 변경
            if (tail != null) {// 더이상 노드가 없을 경우엔 실행하지 않는다.
                tail.next = null;
            } else {
                head = null;
            }
            size--;
            return value;
        }

        public int popFront() {
            if (head == null) {  // head가 null인 경우
                return -1;
            }


            int value = head.value;

            head = head.next; // 현재 head 다음 노드를 head 로 가져온다.

            if (head != null) { // head 노드엔 prev 가 필요없음.
                head.prev = null;
            }else { // head node 가 null 이라면 모든 노드가 없어야함.
                tail = null;
            }

            size--;
            return value;
        }

        public int front() {
            return head == null ? -1 : head.value;
        }

        public int back() {
            return tail == null ? -1 : tail.value;
        }
    }

    static class Node {
        Node prev = null;
        Node next = null;
        int value = 0;
        Node(int value) {
            this.value = value;
        }
    }
}
