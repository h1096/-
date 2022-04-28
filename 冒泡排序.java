public class BubbleSort {
    public void sort(Comparable[] objects, boolean asc) {
        for (int i = 0; i < objects.length - 1; i++) {
            for (int j = 0; j < objects.length - i - 1; j++) {
                // 为啥要取反? 只有不满足时才交换
                if (!compare(objects[j], objects[j + 1], asc)) {
                    swap(objects, j, j + 1);
                }
            }
        }
    }
}

@Test
public void bubbleSortTest()
{
    Integer[] arr = {6,3,1,9,2,8,5,3,6};
    new BubbleSort().sort(arr,false);
    System.out.println(Arrays.toString(arr));
}
