package com.dy.threadDemo.queueDemo;

//实现必须保证线程安全
//阻塞无界优先级队列
public class PriorityBlockingQueueDemo {

    //初始化
    private  Integer initialCapacity = 2;

    //队列数量
    int capacity;

    Integer[] data;

    //队列中的元素数量
    int count = 0;

    PriorityBlockingQueueDemo(int capacity) {
        if (capacity < initialCapacity) {
            data = new Integer[initialCapacity];
            this.capacity = initialCapacity;
        } else {
            this.capacity=capacity;
            data = new Integer[capacity];
        }
    }


    public static void main(String[] args) {

        //  PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        PriorityBlockingQueueDemo priorityBlockingQueueDemo = new PriorityBlockingQueueDemo(16);
        priorityBlockingQueueDemo.insert(23);
        priorityBlockingQueueDemo.insert(43);
        priorityBlockingQueueDemo.insert(3123);
        priorityBlockingQueueDemo.insert(1);
        priorityBlockingQueueDemo.insert(1);
        priorityBlockingQueueDemo.insert(1);
        priorityBlockingQueueDemo.insert(1);
        priorityBlockingQueueDemo.insert(1);
        priorityBlockingQueueDemo.insert(1);
        priorityBlockingQueueDemo.insert(32323);
        priorityBlockingQueueDemo.insert(3232356);
        while (!priorityBlockingQueueDemo.isEmpty()){
            System.out.println(priorityBlockingQueueDemo.pop());
        }



    }

    public void insert(Integer item) {
        if (count < capacity) {
            data[count] = item;
            shiftUp(count);
            count = count + 1;
        }
        //扩容
    }


    //最大堆的性质：父节点永远大于子节点
    private void shiftUp(int index) {
        //index是插入的节点 节点为0的，左孩子是奇数 右孩子是偶数
        //判断是左孩子还是右孩子
        int parentIndex;
        if (index == 0) {
            return;
        }
        if (index % 2 == 0) {
            parentIndex = ((index - 2) < 0 ? 0 : index - 2) / 2;
        } else {
            parentIndex = ((index - 1) < 0 ? 0 : index - 1) / 2;
        }
        if (data[index] > data[parentIndex]) {
            return;
        }
        swap(index, parentIndex);
        shiftUp(parentIndex);


    }

    public boolean isEmpty() {
        return count <= 0;
    }

    public int pop() {
        int result = this.data[0];
        data[0] = data[count - 1];
        count--;
        shiftDown(0);
        return result;
    }

    private void shiftDown(int index) {
        if (index >= count) {
            return;
        }
        //左孩子
        int leftChild = (index * 2 + 1) > count ? count : index * 2 + 1;
        //右孩子
        int rightChild = index * 2 + 2 > count ? count : index * 2 + 2;
        //如果孩子节点大于父子节点 则交换位置
        int maxChildIndex = data[rightChild] < data[leftChild] ? rightChild : leftChild;
        if (data[maxChildIndex] > data[index]) {
            return;
        }
        swap(maxChildIndex, index);
        shiftDown(maxChildIndex);
        if (maxChildIndex == count) {
            return;
        }
    }

    public void swap(int index1, int intdex2) {
        Integer temp = data[index1];
        data[index1] = data[intdex2];
        data[intdex2] = temp;
    }
}
