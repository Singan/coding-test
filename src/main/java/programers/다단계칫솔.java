package programers;

import java.util.Arrays;
import java.util.HashMap;

public class 다단계칫솔 {
    public static void main(String[] args) {
//        int[] a = new Solution().solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
//                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
//                new String[]{"young", "john", "tod", "emily", "mary"},
//                new int[]{12, 4, 2, 5, 10});
//
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
    }

    private static class Solution {
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int[] answer = new int[enroll.length];
            int price = 100;
            HashMap<String, String> referralMap = new HashMap<>();
            HashMap<String, Integer> salesMap = new HashMap<String, Integer>();
            for (int i = 0; i < enroll.length; i++) {
                referralMap.put(enroll[i], referral[i]);
                salesMap.put(enroll[i], 0);
            }
            for (int i = 0; i < seller.length; i++) {
                int mySalesPrice = amount[i] * price;
                String myName = seller[i];
                int referralCost =  (int)(mySalesPrice/10+mySalesPrice%10);
                mySalesPrice=mySalesPrice-referralCost;
                String ref = referralMap.get(myName);
                while (!ref.equals("-")){

                    if(referralCost<10){
                        salesMap.put(ref,salesMap.get(ref)+referralCost);
                        ref=referralMap.get(ref);
                        break;
                    }
                    salesMap.put(ref,salesMap.get(ref)+referralCost-(int)(referralCost*0.1));
                    referralCost=(int)(referralCost*0.1);
                    ref=referralMap.get(ref);

                }

                salesMap.put(myName, salesMap.get(myName) + mySalesPrice);
            }
            for (int i = enroll.length - 1; i >= 0; i--) {
                int myAccount = salesMap.get(enroll[i]);


                answer[i] = myAccount;
            }


            return answer;

        }

        public int s(){
            return 0;
        }
    }
}
