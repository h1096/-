public class InsertionSort {
    public void sort(Comparable[] objects, boolean asc) {
        for (int i = 1; i < objects.length; i++) {
            // 比较已经整理好的扑克牌
            for (int j = i; j > 0; j--) {
                if (!compare(objects[j - 1], objects[j], asc)) {
                    swap(objects, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }
}

@Test
public void InsertionSortTest()
{
    Integer[] arr = {6,3,1,9,2,8,5,3,6};
    new InsertionSort().sort(arr, false);
    System.out.println(Arrays.toString(arr));
}
