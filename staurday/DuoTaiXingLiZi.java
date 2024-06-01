package examtion.staurday;

// 父类 ShiWu
class ShiWu
{
    public void eat()
    {
        System.out.println("食物被吃了");
    }
}

// 子类 ShuiGuo
class ShuiGuo extends ShiWu
{
    @Override
    public void eat()
    {
        System.out.println("水果被吃了");
    }

    public void chew() {
        System.out.println("吃水果要咀嚼");
    }
}

// 子类 RouLei
class RouLei extends ShiWu
{
    @Override
    public void eat()
    {
        System.out.println("肉类被吃了");
    }

    public void slice()
    {
        System.out.println("吃肉类要切片");
    }
}

// 主类
public class DuoTaiXingLiZi
{
    public static void main(String[] args)
    {
        // 创建父类类型的引用，但引用子类对象
        ShiWu shiWu1 = new ShuiGuo();
        ShiWu shiWu2 = new RouLei();

        // 多态性：调用的是子类的重写方法
        shiWu1.eat(); // 输出: 水果被吃了
        shiWu2.eat(); // 输出: 肉类被吃了

        // 使用 instanceof 检查对象类型
        if (shiWu1 instanceof ShuiGuo)
        {
            ShuiGuo shuiGuo = (ShuiGuo) shiWu1;
            shuiGuo.chew(); // 输出: 吃水果要咀嚼
        }

        if (shiWu2 instanceof RouLei)
        {
            RouLei rouLei = (RouLei) shiWu2;
            rouLei.slice(); // 输出: 吃肉类要切片
        }

        // 如果使用错误的类型，instanceof 可以防止 ClassCastException
        if (shiWu1 instanceof RouLei)
        {
            RouLei rouLei = (RouLei) shiWu1;
            rouLei.slice(); // 不会执行，因为 shiWu1 不是 RouLei 类型
        } else
        {
            System.out.println("shiWu1 不是 RouLei 类型");
        }
    }
}
