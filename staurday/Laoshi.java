package examtion.staurday;

import java.util.*;

public class Laoshi implements Comparable<Laoshi>
{
    public String xingming;
    public int nianling;

    public Laoshi(String xingming, int nianling)
    {
        this.xingming = xingming;
        this.nianling = nianling;
    }

    @Override
    public String toString()
    {
        return "Laoshi{" +
                "xingming='" + xingming + '\'' +
                ", nianling=" + nianling +
                '}';
    }

    // 实现自然排序
    @Override
    public int compareTo(Laoshi other)
    {
        if (this.nianling != other.nianling)
        {
            return other.nianling - this.nianling; // 年龄降序排列
        }
        else
        {
            return other.xingming.compareTo(this.xingming); // 年龄相同，按名字降序排列
        }
    }

    // 自定义排序比较器
    public static Comparator<Laoshi> NianlingXingmingComparator = new Comparator<Laoshi>()
    {
        @Override
        public int compare(Laoshi laoshi1, Laoshi laoshi2)
        {
            if (laoshi1.nianling != laoshi2.nianling)
            {
                return laoshi2.nianling - laoshi1.nianling; // 年龄降序排列
            }
            else
            {
                return laoshi2.xingming.compareTo(laoshi1.xingming); // 年龄相同，按名字降序排列
            }
        }
    };

    public static void main(String[] args)
    {
        Laoshi a = new Laoshi("jack", 15);
        Laoshi b = new Laoshi("marry", 14);
        Laoshi c = new Laoshi("tom", 15);
        Laoshi d = new Laoshi("lucy", 16);
        Laoshi e = new Laoshi("pink", 17);

        // 使用自然排序进行排序
        TreeSet<Laoshi> ziRanPaiXuSet = new TreeSet<>();
        ziRanPaiXuSet.add(a);
        ziRanPaiXuSet.add(b);
        ziRanPaiXuSet.add(c);
        ziRanPaiXuSet.add(d);
        ziRanPaiXuSet.add(e);
        System.out.println("使用自然排序：");
        for (Laoshi laoshi : ziRanPaiXuSet)
        {
            System.out.println(laoshi);
        }

        // 使用自定义排序进行排序
        TreeSet<Laoshi> ziDingYiPaiXuSet = new TreeSet<>(NianlingXingmingComparator);
        ziDingYiPaiXuSet.add(a);
        ziDingYiPaiXuSet.add(b);
        ziDingYiPaiXuSet.add(c);
        ziDingYiPaiXuSet.add(d);
        ziDingYiPaiXuSet.add(e);
        System.out.println("\n使用自定义排序：");
        for (Laoshi laoshi : ziDingYiPaiXuSet)
        {
            System.out.println(laoshi);
        }
    }
}