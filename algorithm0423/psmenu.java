package algorithm0423;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class psmenu {
    
    public static HashMap<String,Integer> test = new HashMap<>();


    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ArrayList<String> last = new ArrayList<>();
        for(int i =0; i<course.length; i++ ){
            for(int j =0; j<orders.length; j++){
                combi(0,0,course[i],new char[course[i]], orders[j]);
            }

            
            List<Entry<String, Integer>> list2 = new ArrayList<Entry<String, Integer>>(test.entrySet());
            Collections.sort(list2, new Comparator<Entry<String, Integer>>(){
    
                @Override
                public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                } 
            });    
            for(int j =0; j<list2.size(); j++){
                if(list2.get(j).getValue() == 1 || list2.get(j).getValue() != list2.get(0).getValue()){
                    break;
                }else{
                    last.add(list2.get(j).getKey());
                }
            }
            test = new HashMap<>();
        }
        Collections.sort(last);  
        answer = new String[last.size()];
        for(int i=0; i< last.size(); i++){
            answer[i] = last.get(i);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void combi(int count, int idx,int N, char[] arr, String order){
        if(count == N){
            char[] temp = arr.clone();
            Arrays.sort(temp);
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i< arr.length; i++ ){
                sb.append(temp[i]);
            }
            String pars = sb.toString();
            if(test.keySet().contains(pars)){
                // System.out.println("check : "+arr.toString());
                test.put(pars, test.get(pars)+1);
            }else{
                test.put(pars, 1);
            }
            return;
        }
        for(int i=idx; i < order.length(); i++){
            arr[count] = order.charAt(i);
            combi(count+1, i+1,N,arr, order);
        }
    }


    
    public static void main(String[] args) {
        solution( new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4});
        solution( new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2,3,5});
        solution( new String[]{"XYZ","XWY","WXA"}, new int[]{2,3,4});


    }
}
