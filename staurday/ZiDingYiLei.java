package examtion.staurday;

public class ZiDingYiLei
{
    // ˽�г�Ա����
    private String mingzi;
    private int nianling;

    // ��̬�����
    static
    {
        System.out.println("��̬����飺�����ʱִ��");
    }

    // �����
    {
        System.out.println("����飺���󴴽�ʱִ��");
    }

    // �޲ι�����
    public ZiDingYiLei()
    {
        this.mingzi = "Ĭ����";
        this.nianling = 0;
        System.out.println("�޲ι�����������Ĭ�϶���");
    }

    // �вι�����
    public ZiDingYiLei(String mingzi, int nianling)
    {
        this.mingzi = mingzi;
        this.nianling = nianling;
        System.out.println("�вι������������������Ķ���");
    }

    // Getter����
    public String getMingzi()
    {
        return mingzi;
    }

    public int getNianling()
    {
        return nianling;
    }

    // Setter����
    public void setMingzi(String mingzi)
    {
        this.mingzi = mingzi;
    }

    public void setNianling(int nianling)
    {
        this.nianling = nianling;
    }

    // toString()����
    @Override
    public String toString()
    {
        return "ZiDingYiLei{mingzi='" + mingzi + "', nianling=" + nianling + "}";
    }

    // �����������Դ���
    public static void main(String[] args)
    {
        System.out.println("ʹ���޲ι�����������һ������");
        ZiDingYiLei duixiang1 = new ZiDingYiLei();
        System.out.println(duixiang1);

        System.out.println("\nʹ���вι����������ڶ�������");
        ZiDingYiLei duixiang2 = new ZiDingYiLei("С��", 25);
        System.out.println(duixiang2);
    }
}
