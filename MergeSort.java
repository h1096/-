public class MergeSort {


    public void sort(Comparable[] objects, boolean asc) {

        // 辅助数组先创建出来,减少后续频繁创建辅助数组.
        Comparable[] assist = new Comparable[objects.length];

        // 拆分
        sort(objects, 0, objects.length - 1, assist, asc);
    }

    public void sort(Comparable[] objects, int low, int high, Comparable[] assist, boolean asc) {
        // 边界检查
        if (low == high) {
            return;
        }
        // 之所以这样,是为了防止溢出
        int mid = low + ((high - low) >> 1);
        // 对左边进行归并排序
        sort(objects, low, mid, assist, asc);
        // 对右边进行归并排序
        sort(objects, mid + 1, high, assist, asc);

        // 将两个相邻的有序子组进行合并
        merge(objects, low, mid, high, assist, asc);
    }

    public void merge(Comparable[] objects, int low, int mid, int high, Comparable[] assist, boolean asc) {
        // 左侧范围 low ~ mid
        // 右侧范围 mid+1  ~ high

        // 指向左侧第一个元素
        int p1 = low;
        // 指向右侧第一个元素
        int p2 = mid + 1;
        // 指向辅助数组第一个元素
        int p3 = 0;
        while (p1 <= mid && p2 <= high) {
            // 这里为啥无需取反,因为要选择合适的一个.
            if (compare(objects[p1], objects[p2], asc)) {
                // 左侧的符合
                // 加入到辅助数组
                assist[p3++] = objects[p1++];
            } else {
                assist[p3++] = objects[p2++];
            }
        }
        // 还有剩余的
        while (p1 <= mid) {
            assist[p3++] = objects[p1++];
        }
        while (p2 <= high) {
            assist[p3++] = objects[p2++];
        }
        // 将辅助数组拷贝到原数组
        System.arraycopy(assist, 0, objects, low, high - low + 1);
    }


}
