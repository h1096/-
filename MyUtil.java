public class MyUtil {
    public static void swap(Object[] arr, int a, int b) {
        Object temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static boolean compare(Comparable a, Comparable b, boolean asc) {

        // asc:
        //  true:升序
        //  false:降序


        // 如果是升序,就说明左边比右边小,那么compareTo返回负数
        // 如果是降序,就说明左边比右边大,那么compareTo返回正数


        int compare = a.compareTo(b);
        return compare == 0 || (asc && compare < 0) || (!asc && compare > 0);
    }
    
}
