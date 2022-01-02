package hashmaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class EmployeesNumberUnderManager {
    public static void numberOfEmployees(HashMap<String,String> map){
        HashMap<String, HashSet<String>> tree = new HashMap<>();

        String ceo = "";
        for(String employee : map.keySet()) {
            String manager = map.get(employee);

            if (manager.equals(employee)) {
                ceo = manager;
            } else {

                if (tree.containsKey(manager)) {
                    HashSet<String> employees = tree.get(manager);
                    employees.add(employee);
                } else {
                    HashSet<String> employees = new HashSet<>();
                    employees.add(employee);
                    tree.put(manager, employees);
                }
            }
        }
        HashMap<String,Integer> output = new HashMap<>();
        getSize(tree, ceo, output);

        for(String result : output.keySet()){
            System.out.println(result + " " + output.get(result));
        }
    }

    public static int getSize(HashMap<String,HashSet<String>> tree, String manager, HashMap<String,Integer> output){
        if(tree.containsKey(manager)==false){
            output.put(manager,0);
            return 1;
        }

        int size = 0;

        for(String employees : tree.get(manager)){
            int childSize = getSize(tree,employees,output);
            size += childSize;
        }

        output.put(manager,size);
        return size + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<String,String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(sc.next(),sc.next());
        }

        numberOfEmployees(map);
    }
}
