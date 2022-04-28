public class QuickSort {
    public void sort(Comparable[] objects, boolean asc) {
        sort(objects, 0, objects.length - 1, asc);
    }

    public void sort(Comparable[] objects, int low, int high, boolean asc) {
        if (low >= high) {
            return;
        }
        int index = partition(objects, low, high, asc);
        //int index = partition2(objects, low, high, asc);

        // 将low到high的元素分为左右两个子组.
        // 然后让左子组有序.
        sort(objects, low, index - 1, asc);
        // 再让右子组有序.
        sort(objects, index + 1, high, asc);
        // 找一个基准值
    }

    // 分组,并返回基准值新的索引
    // 这里采用了填坑法,还有一种指针交换法
    public int partition(Comparable[] objects, int low, int high, boolean asc) {
        // 指向每组的第一个,但其实这样效率有问题,如果是一个已经有序的...原则上应该随机选择
        Comparable key = objects[low];
        int left = low;
        int right = high;
        while (left < right) {
            // 从右向左
            // 以升序为例:
            //      需要找到右边比基准值小的,放到左边去,如果比基准值大,则继续移动
            while (left < right && compare(key, objects[right], asc)) right--;
            // 将找到的元素填到左边的坑里面
            if (left < right) {
                objects[left] = objects[right];
            }
            // 从左向右
            // 以升序为例:
            //      需要找到左边比基准值大的,放到右边去,如果比基准值小,则继续移动.
            while (left < right && compare(objects[left], key, asc)) left++;
            if (left < right) {
                objects[right] = objects[left];
            }
        }
        // 全部移动完毕后,将坑填上基准值
        objects[left] = key;
        return left;
    }

    // 这里采用了指针交换法
    public int partition2(Comparable[] objects, int low, int high, boolean asc) {
        // 指向每组的第一个,但其实这样效率有问题,如果是一个已经有序的...
        Comparable key = objects[low];
        int left = low;
        int right = high;
        while (left < right) {
            // 从右向左
            // 以升序为例:
            //      需要找到右边比基准值小的,放到左边去,如果比基准值大,则继续移动
            while (left < right && compare(key, objects[right], asc)) right--;
            // 从左向右
            // 以升序为例:
            //      需要找到左边比基准值大的,放到右边去,如果比基准值小,则继续移动.
            while (left < right && compare(objects[left], key, asc)) left++;
            if (left < right) {
                // 交换left和right
                swap(objects, left, right);
            }
        }
        // 全部移动完毕后,将基准值和重合点进行交换
        // 重合后,基准值的下标仍为low,二重合点的下标为left或right
        swap(objects, low, left);
        return left;
    }
}
