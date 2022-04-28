public class HeapSort {
    public void sort(Comparable[] objects, boolean asc) {
        // 先创建一个堆.
        createHeap(objects, objects.length, asc);
        // 遍历所有节点
        for (int i = objects.length - 1; i > 0; i--) {
            // 交换顶部元素和最后一个元素
            swap(objects, 0, i);
            // 移除最后一个节点
            // -- 其实什么也不做
            // 对剩下元素重新进行堆化
            heapify(objects, i, 0, asc);
        }


        // 将顶部元素取出来放到数组的后面,
        // 因此:从小到大用大顶堆,从大到小用小顶堆
    }

    public void createHeap(Comparable[] objects, int n, boolean asc) {

        // 方式1.从上到下,从左到右
        // 插入一次,交换一次,并返回上级继续交换,直至到达最顶层.

        // 方式2.从下到上,从右到左 [时间复杂度更低]


        // 这里选择了方式2

        // 为什么还要减2呢?
        // n - 1 是为了取到最后一个对象的下标.

        int parent = (n - 1 - 1) / 2;
        // 遍历所有根节点
        for (int i = parent; i >= 0; i--) {
            heapify(objects, n, i, asc);
        }
    }

    // 堆化
    public void heapify(Comparable[] objects, int len, int parent, boolean asc) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        // 挑选出左节点或者右节点中符合条件的那个.
        int selectIndex = parent;
        if (left < len && !compare(objects[left], objects[selectIndex], asc)) {
            selectIndex = left;
        }
        if (right < len && !compare(objects[right], objects[selectIndex], asc)) {
            selectIndex = right;
        }


        if (selectIndex != parent) {
            swap(objects, parent, selectIndex);
            // 没有互换,层级自然不会出现变化,因此没必要在进行堆化
            // 如果发送了交换,说明子节点已经变化,新的子节点完全有可能比子节点的子节点还大或者小...
            heapify(objects, len, selectIndex, asc);
        }
    }
}
