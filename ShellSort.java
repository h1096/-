public class ShellSort {

    // 其实这个序列可以直接指定的。
    // [1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905, 8929, 16001,
    // 36289, 64769, 146305, 260609, 587521, 1045505, 2354689,
    // 4188161, 9427969, 16764929, 37730305, 67084289, 150958081,
    // 268386305, 603906049, 1073643521]
    private static ArrayList<Integer> sedgewickSequence = makeSedgewickSequence();


    public static ArrayList<Integer> makeSedgewickSequence() {
        ArrayList<Integer> sedgewickSequence = new ArrayList<>();
        int value;
        int i = 1;
        int j = 2;
        while (true) {
            //max：（9*4^i - 9*2^i+1 , 4^j-3*2^j+1)
            int a = (int) (9 * Math.pow(4, i - 1) - 9 * Math.pow(2, i - 1) + 1);
            int b = (int) (Math.pow(4, j - 1) - 3 * Math.pow(2, j - 1) + 1);
            if (a > b) {
                j++;
                value = a;
            } else {
                i++;
                value = b;
            }
            if (value == Integer.MAX_VALUE) {
                // 那么大的值已经没有意义了。
                break;
            }
            sedgewickSequence.add(value);
        }
        return sedgewickSequence;
    }


    //Hibbard增量序列、Knuth增量序列、Sedgewick增量序列

    //这里采用了Sedgewick增量序列
    public int getSequenceValue(int size) {
        int index = 0;
        for (; ; index++) {
            if (sedgewickSequence.get(index + 1) > (size << 1)) {
                break;
            }
        }
        return index;
    }


    public void sort(Comparable[] objects, boolean asc) {
        int times = getSequenceValue(objects.length);
        //System.out.printf("将进行%d次分组\n", times + 1);

        // 分几次
        for (int i = times; i >= 0; i--) {
            int gap = sedgewickSequence.get(i);
            //System.out.printf("第%d次分组的增量为:%d\n", times - i + 1, gap);

            // 对每组元素进行插入排序
            // 将待插入的元素插入到有序的集合中.
            // 找到所有待插入的元素
            //System.out.printf("待插入的元素个数为:%d\n", objects.length - gap);
            for (int j = gap; j < objects.length; j++) {

                // 找出和他一组的,所在的位置.
                for (int k = j; k >= gap; k -= gap) {
                    int left = k - gap;
                    int right = k;
                    //System.out.printf("left:  %d [%d]\tright:  %d  [%d]\n", left, objects[left], right, objects[right]);

                    if (!compare(objects[left], objects[right], asc)) {
                        swap(objects, left, right);
                        //System.out.println("交换后: " + Arrays.toString(objects));
                    } else {
                        break;
                    }
                }
            }

        }
    }
}


