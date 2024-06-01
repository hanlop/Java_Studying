package examtion.staurday;

public class IndexOutOfBoundsExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};

        try {
            // 可能抛出异常的代码块
            int value = numbers[3]; // 访问超出索引范围的元素
            System.out.println("这里永远不会被执行，因为异常已经发生");
        } catch (ArrayIndexOutOfBoundsException e) {
            // 处理异常的代码块
            System.out.println("捕获到索引越界异常：" + e.getMessage());
        }

        System.out.println("异常已经处理，程序继续执行");
    }
}

