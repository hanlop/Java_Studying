package examtion.staurday;

public class SuoyinYuejieYichangLiZi {
    public static void main(String[] args)
    {
        try
        {
            fangwenShuzuYuanSu();
        }
        catch (Array e)
        {
            System.out.println("异常：" + e.getMessage());
        }

        System.out.println("继续运行");
    }

    public static void fangwenShuzuYuanSu() throws Array
    {
        int[] shuzu = {1, 2, 3};

        // 尝试访问不存在的索引
        System.out.println(shuzu[3]);
    }
}
