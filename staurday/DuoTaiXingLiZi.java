package examtion.staurday;

// ���� ShiWu
class ShiWu
{
    public void eat()
    {
        System.out.println("ʳ�ﱻ����");
    }
}

// ���� ShuiGuo
class ShuiGuo extends ShiWu
{
    @Override
    public void eat()
    {
        System.out.println("ˮ��������");
    }

    public void chew() {
        System.out.println("��ˮ��Ҫ�׽�");
    }
}

// ���� RouLei
class RouLei extends ShiWu
{
    @Override
    public void eat()
    {
        System.out.println("���౻����");
    }

    public void slice()
    {
        System.out.println("������Ҫ��Ƭ");
    }
}

// ����
public class DuoTaiXingLiZi
{
    public static void main(String[] args)
    {
        // �����������͵����ã��������������
        ShiWu shiWu1 = new ShuiGuo();
        ShiWu shiWu2 = new RouLei();

        // ��̬�ԣ����õ����������д����
        shiWu1.eat(); // ���: ˮ��������
        shiWu2.eat(); // ���: ���౻����

        // ʹ�� instanceof ����������
        if (shiWu1 instanceof ShuiGuo)
        {
            ShuiGuo shuiGuo = (ShuiGuo) shiWu1;
            shuiGuo.chew(); // ���: ��ˮ��Ҫ�׽�
        }

        if (shiWu2 instanceof RouLei)
        {
            RouLei rouLei = (RouLei) shiWu2;
            rouLei.slice(); // ���: ������Ҫ��Ƭ
        }

        // ���ʹ�ô�������ͣ�instanceof ���Է�ֹ ClassCastException
        if (shiWu1 instanceof RouLei)
        {
            RouLei rouLei = (RouLei) shiWu1;
            rouLei.slice(); // ����ִ�У���Ϊ shiWu1 ���� RouLei ����
        } else
        {
            System.out.println("shiWu1 ���� RouLei ����");
        }
    }
}
