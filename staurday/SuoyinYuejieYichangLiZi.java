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
            System.out.println("�쳣��" + e.getMessage());
        }

        System.out.println("��������");
    }

    public static void fangwenShuzuYuanSu() throws Array
    {
        int[] shuzu = {1, 2, 3};

        // ���Է��ʲ����ڵ�����
        System.out.println(shuzu[3]);
    }
}
