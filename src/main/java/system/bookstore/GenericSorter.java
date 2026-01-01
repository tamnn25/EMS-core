package system.bookstore;


import system.bookstore.MyComparable;
import java.util.*;

public class GenericSorter {

    // Generic method để sắp xếp bất kỳ list nào implement MyComparable
    public static <T extends MyComparable<T>> void sort(List<T> list) {
        list.sort(T::compareTo);
    }

    // Generic method với custom comparator
    public static <T> void sort(List<T> list, Comparator<T> comparator) {
        list.sort(comparator);
    }

    // Tìm phần tử nhỏ nhất trong list
    public static <T extends MyComparable<T>> T findMin(List<T> list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        T min = list.get(0);
        for (T item : list) {

//            System.out.println("student " + item);

//            System.out.println("findmin method" + item.compareTo(min));

            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        System.out.println("T from interface" + min);
        return min;
    }

    // Tìm phần tử lớn nhất trong list
    public static <T extends MyComparable<T>> T findMax(List<T> list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    // Kiểm tra list có được sắp xếp không
    public static <T extends MyComparable<T>> boolean isSorted(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
}