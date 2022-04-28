public class SelectionSort {
    public void sort(Comparable[] objects, boolean asc) {
        for (int i = 0; i < objects.length - 1; i++) {
            // 每轮选择一个最大或最小的索引。
            int selectIndex = i;
            for (int j = i + 1; j < objects.length; j++) {
                if (!compare(objects[selectIndex], objects[j], asc)) {
                    selectIndex = j;
                }

            }
            if (selectIndex != i) {
                // 交换默认索引的位置和最新索引的位置
                swap(objects, selectIndex, i);
            }
        }
    }
}

@Test
public void selectionSortTest()
{
    Integer[] arr = {6,3,1,9,2,8,5,3,6};
    new SelectionSort().sort(arr,false);
    System.out.println(Arrays.toString(arr));
}
