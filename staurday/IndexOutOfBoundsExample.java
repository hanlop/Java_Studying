package examtion.staurday;

public class IndexOutOfBoundsExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};

        try {
            // �����׳��쳣�Ĵ����
            int value = numbers[3]; // ���ʳ���������Χ��Ԫ��
            System.out.println("������Զ���ᱻִ�У���Ϊ�쳣�Ѿ�����");
        } catch (ArrayIndexOutOfBoundsException e) {
            // �����쳣�Ĵ����
            System.out.println("��������Խ���쳣��" + e.getMessage());
        }

        System.out.println("�쳣�Ѿ������������ִ��");
    }
}

