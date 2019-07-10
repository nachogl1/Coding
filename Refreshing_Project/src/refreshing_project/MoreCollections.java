
package refreshing_project;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ignacio_Gonzalez
 */
public class MoreCollections {
    public static void main(String[] args){
        int[] arr={4,4,5,3,7};
        List <Object> list = new LinkedList<>();
        
        Collections.addAll(list,arr[1],arr[3]);
    
        list.stream().forEach((o) -> {
            System.out.println(o);
        });
        System.out.println("Sorted");
        list.stream().sorted().forEach(System.out::println);
        
        List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");

        //System.out.println(Collections.binarySearch(list,4));
        System.out.println("Copy");
        List <Object> list2 = new LinkedList<>(list);
        list2.stream().forEach((o) -> {
            System.out.println(o);
        });
        
        System.out.println("Returns true if the two specified collections have no elements in common.: "+ !Collections.disjoint(list, list2));
        
        Collections.fill(list2,1);
        list2.stream().forEach((o) -> {
            System.out.println(o);
        });
        System.out.println("1 appears "+Collections.frequency(list2, 1)+" times");
        list2.add(2);
        
        Collections.replaceAll(list2, 1, 3);
        Collections.reverse(list2);
        list2.stream().forEach((o) -> {
            System.out.println(o);
        });
        
        Collections.rotate(list2,1);//numbers of rotations
        Collections.shuffle(list2);
        Collections.sort(messages);
        
        //swap
        //unmodifiableDataStruture
        //SynchroizedDataStructure
        
    }
}
